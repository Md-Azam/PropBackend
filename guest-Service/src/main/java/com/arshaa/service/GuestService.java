package com.arshaa.service;

import com.arshaa.common.AmountTotal;
import com.arshaa.common.Bed;
import com.arshaa.common.GuestInfo;
import com.arshaa.common.Payment;
import com.arshaa.entity.Guest;
import com.arshaa.model.DailyActive;
import com.arshaa.model.GuestsInNotice;
import com.arshaa.model.VacatedGuests;
import com.arshaa.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class GuestService implements GuestInterface {
    @Autowired(required = true)
    private GuestRepository repository;

    @Autowired
    @Lazy
    private RestTemplate template;
    
    @Autowired
	@PersistenceContext
	private EntityManager em;

    @Override
    public List<Guest> getGuests() {
        return repository.findAll();
    }

    @Override
    public Guest getGuestById(String guestId) {
        return repository.findById(guestId);
    }

    @Override
    public Guest addGuest(Guest guest) {
        //double initialDefaultrent = 0;
        String bedUri = "http://bedService/bed/updateBedStatusBydBedId";
        String payUri = "http://paymentService/payment/addPaymentAtOnBoarding";
 //     Bed getUniqueBed = template.getForObject("http://bedService/bed/getBedByBedId/" + guest.getBedId(), Bed.class);
//        if (getUniqueBed.getBedId().equalsIgnoreCase(guest.getBedId())) {
//            System.out.println(getUniqueBed.getBedId());
//            guest.setDueAmount(getUniqueBed.getDefaultRent() - guest.getAmountPaid());
//        }
       // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //System.out.println(formatter.format(tSqlDate));
       
        java.sql.Date tSqlDate = new java.sql.Date(guest.getTransactionDate().getTime());
        
        guest.setTransactionDate(tSqlDate);
        
        java.sql.Date cSqlDate = new java.sql.Date(guest.getCheckInDate().getTime());
        
       guest.setCheckInDate(cSqlDate);
        repository.save(guest);
        
        if(guest.getOccupancyType().equalsIgnoreCase("daily"))
        {
        	java.util.Date m = guest.getCheckInDate();
            Calendar cal = Calendar.getInstance();  
            cal.setTime(m);  
            cal.add(Calendar.DATE, guest.getDuration()); 
            m = cal.getTime();   
            System.out.println(m);
            guest.setPlannedCheckOutDate(m);
            guest.setGuestStatus("active");            
            repository.save(guest);
        }
        else if(guest.getOccupancyType().equalsIgnoreCase("monthly"))
        {
        	java.util.Date m = guest.getCheckInDate();
            Calendar cal = Calendar.getInstance();  
            cal.setTime(m);  
            cal.add(Calendar.MONTH, guest.getDuration()); 
            m = cal.getTime();   
            System.out.println(m);
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            //System.out.println(dtf.format(m));  

            guest.setPlannedCheckOutDate(m);
            guest.setGuestStatus("active");            
            repository.save(guest);
        }        
        else {
            guest.setGuestStatus("active");            

            repository.save(guest);
        }


//        System.out.println(initialDefaultrent); 
        guest.setGuestStatus("active");            

        repository.save(guest);
                System.out.println(guest.getDueAmount());
        Bed bedReq = new Bed();
        Payment payReq = new Payment();
        //bed setting
        bedReq.setBedId(guest.getBedId());
        
        bedReq.setGuestId(guest.getId());
        //bedReq.setDueAmount(guest.getDueAmount());
        template.put(bedUri, bedReq, Bed.class);
        //payment setting
        payReq.setGuestId(guest.getId());
        payReq.setBuildingId(guest.getBuildingId());
        payReq.setTransactionId(guest.getTransactionId());
        payReq.setOccupancyType(guest.getOccupancyType());
        payReq.setTransactionDate(tSqlDate);
       // payReq.setCheckinDate(cSqlDate);
        payReq.setAmountPaid(guest.getAmountPaid());
       // payReq.setDueAmount(guest.getDueAmount());
        payReq.setPaymentPurpose(guest.getPaymentPurpose());
        repository.save(guest);
        Payment parRes = template.postForObject(payUri, payReq, Payment.class);
        System.out.println(parRes);
                return guest;
    }

    @Override
    public double updateGuest(Guest guest) {
        Guest newGuest = repository.findById(guest.getId());
        newGuest.setDueAmount(guest.getDueAmount());
        repository.save(newGuest);
        return newGuest.getDueAmount();
    }

    @Override
    public void deleteGuest(String guestId) {
        Guest deleteGuest = repository.findById(guestId);
        repository.delete(deleteGuest);
    }
    
 // Method to fetch the dueamount by guestId .
 	@SuppressWarnings("unchecked")
 	@Override
 	public List<Guest> getByGuestId(String guestId) {
 		// TODO Auto-generated method stub

 		return em.createNamedStoredProcedureQuery("firstProcedure").setParameter("g_id", guestId).getResultList();

 	}

      //Method to fetch all the dueamount .
 	@SuppressWarnings("unchecked")
 	@Override
 	public List<Guest> getTotalDue() {

 		return em.createNamedStoredProcedureQuery("dueDashBoard").getResultList();

 	}

	@Override
	public List<Guest> getPendingByBuildingId(int buildingId) {
		// TODO Auto-generated method stub
		return em.createNamedStoredProcedureQuery("thirdProcedure").setParameter("b_id", buildingId).getResultList();


	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getCheckOutAmountByGuestId(String id) {
	// TODO Auto-generated method stub
	return em.createNamedStoredProcedureQuery("checkOut").setParameter("GUEST__ID" , id).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getFinalDueAmountById(String id) {
		// TODO Auto-generated method stub
		return em.createNamedStoredProcedureQuery("finalDue").setParameter("GUEST_ID" , id).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getOnlyDues(String id) {
		// TODO Auto-generated method stub
		return em.createNamedStoredProcedureQuery("onlyDues").setParameter("GUEST__ID" , id).getResultList();
	}
	
	
	public List<GuestsInNotice> findByBuildingIdAndGuestStatus(String guestStatus)
   	{
Guest gst = new Guest();
		List<Guest> getList = repository.findByGuestStatus(guestStatus);
		List<GuestsInNotice> gin=new ArrayList<>();
		if(gst.getOccupancyType() == " Daily" && gst.getOccupancyType() == "Monthly"  ) {
			getList.forEach(g->{
				GuestsInNotice gs=new GuestsInNotice();
	            gs.setBedId(g.getBedId());
	            String name=template.getForObject("http://bedService/bed/getBuildingNameByBuildingId/"+ g.getBuildingId(), String.class);
	            gs.setBuildingName(name);
	            gs.setCheckInDate(g.getCheckInDate());
	            gs.setCheckOutDate(g.getPlannedCheckOutDate());
	            gs.setEmail(g.getEmail());
	            gs.setOccupancyType(g.getOccupancyType());
	            gs.setBedId(g.getBedId());
	            gs.setFirstName(g.getFirstName().concat(" ").concat(g.getLastName()));
	            gs.setPersonalNumber(g.getPersonalNumber());
	            gs.setId(g.getId());
	            gin.add(gs);
			});
		} if(gst.getOccupancyType() =="Regular" && gst.getGuestStatus() == "InNotice")

		//GuestsInNotice gs=new GuestsInNotice();
		getList.forEach(g->{
			GuestsInNotice gs=new GuestsInNotice();
            gs.setBedId(g.getBedId());
            String name=template.getForObject("http://bedService/bed/getBuildingNameByBuildingId/"+ g.getBuildingId(), String.class);
            gs.setBuildingName(name);
            gs.setCheckInDate(g.getCheckInDate());
            gs.setCheckOutDate(g.getPlannedCheckOutDate());
            gs.setEmail(g.getEmail());
            gs.setOccupancyType(g.getOccupancyType());
            gs.setBedId(g.getBedId());
            gs.setFirstName(g.getFirstName().concat(" ").concat(g.getLastName()));
            gs.setPersonalNumber(g.getPersonalNumber());
            gs.setId(g.getId());
            gin.add(gs);
		});
		return gin;
   	}
	@Override
	public GuestInfo findGuestInfoById(String id) {
		// TODO Auto-generated method stub
		Guest ge=  repository.findById(id);
		
		

			GuestInfo info = new GuestInfo();
			info.setBedId(ge.getBedId());
			info.setEmail(ge.getEmail());
			info.setId(ge.getId());
		      String name=template.getForObject("http://bedService/bed/getBuildingNameByBuildingId/"+ ge.getBuildingId(), String.class);
		      info.setBuildingName(name);
			info.setPersonalNumber(ge.getPersonalNumber());
			info.setOccupancyType(ge.getOccupancyType());
			info.setGuestName(ge.getFirstName().concat(" ").concat(ge.getLastName()));
			return info ;
		
	
	}

	public List<VacatedGuests> findByGuestStatus(String guestStatus)
   	{

		List<Guest> getList = repository.findByGuestStatus(guestStatus);
		List<VacatedGuests> gin=new ArrayList<>();
		
		//GuestsInNotice gs=new GuestsInNotice();
		getList.forEach(g->{
			VacatedGuests gs=new VacatedGuests();
            gs.setBedId(g.getBedId());
            String name=template.getForObject("http://bedService/bed/getBuildingNameByBuildingId/"+ g.getBuildingId(), String.class);
            gs.setBuildingName(name);
            gs.setOccupancyType(g.getOccupancyType());
            
            gs.setCheckOutDate(g.getCheckOutDate());
            gs.setEmail(g.getEmail());
            gs.setBedId(g.getBedId());
            gs.setFirstName(g.getFirstName().concat(" ").concat(g.getLastName()));
            gs.setPersonalNumber(g.getPersonalNumber());
            gs.setId(g.getId());
            gin.add(gs);
		});
		return gin;
   	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getTotalAmountByGuestId(String id) {
		// TODO Auto-generated method stub 
		AmountTotal   tap = new AmountTotal();
	   // return  em.createNamedStoredProcedureQuery("updateAmount").setParameter("GUEST__ID" , id).getResultList();
	    return em.createNamedStoredProcedureQuery("updateAmount").setParameter("GUEST__ID" , id).getResultList();
	}
	@Override
	public List<DailyActive> findByGuestStatuss(String guestStatus) {
		// TODO Auto-generated method stub
		Guest gest = new Guest();
		 List<Guest> guest = repository.findByGuestStatus(guestStatus);
				
		 List<DailyActive> da = new ArrayList<>();
		 if(gest.getOccupancyType() == " Daily" && gest.getOccupancyType() == "Monthly"  ) 
			if(!guest.isEmpty()) 
		 guest.forEach(d->{
			 DailyActive dact = new DailyActive();
			 dact.setBedId(d.getBedId());
			 dact.setGuestStatus(d.getGuestStatus());
			 dact.setId(d.getId());
	           String name=template.getForObject("http://bedService/bed/getBuildingNameByBuildingId/"+ d.getBuildingId(), String.class);
	           dact.setBuildingName(name);
			 dact.setOccupancyType(d.getOccupancyType());
			 dact.setPersonalNumber(d.getPersonalNumber());
			 dact.setFirstName(d.getFirstName().concat(" ").concat(d.getLastName()));
		 
			 da.add(dact);
		
		 	 });
		 //}else
			// return null ;
		 return da ;
		 
	}

	


}
