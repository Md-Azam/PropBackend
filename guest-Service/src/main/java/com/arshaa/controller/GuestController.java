package com.arshaa.controller;

import com.arshaa.common.Bed;
import com.arshaa.common.GuestInfo;
import com.arshaa.common.GuestModel;
import com.arshaa.entity.Guest;
import com.arshaa.model.DailyActive;
import com.arshaa.model.GuestsInNotice;
import com.arshaa.model.VacatedGuests;
import com.arshaa.repository.GuestRepository;
import com.arshaa.service.GuestInterface;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/guest")
public class GuestController {

	@Autowired(required = true)
    private GuestRepository repository;

    @Autowired(required = true)
    private GuestInterface service;

    @GetMapping("/getAllGuests")
    public List<Guest> getAllGuests() {
        return service.getGuests();
    }

    @PostMapping("/addGuest")
    public Guest saveGuest(@RequestBody Guest guest) {

        return service.addGuest(guest);

    }

    @GetMapping("/getGuestByGuestId/{id}")
    public Guest getOneGuest(@PathVariable("id") String id) {
        return service.getGuestById(id);
    }

    
    
    @DeleteMapping("/deleteGuestByGuestId/{id}")
    public void delete(@PathVariable("id") String id) {
        service.deleteGuest(id);
    }

    @PutMapping("/updateDueAmount")
    public double updateDueAmount(@RequestBody Guest guest) {
        return service.updateGuest(guest);
    }
  //http://localhost:7000/guest/findDueAmount/{guestId}
   	//FETCHING DUE AMOUNT BASED ON GUESTID .
   	@GetMapping("/findDueAmount/{guestId}")
   	public List<Guest> getByGuestId(@PathVariable String guestId) {
   		return service.getByGuestId(guestId);

   	}
     
   	  //http://localhost:7000/guest/getDueAmountOnDashBoard.
   	//FETCHING OverAllDUE AMOUNT. .
   	@GetMapping("/getDueAmountOnDashBoard")
   	public List<Guest> getTotalDue() {
   		return service.getTotalDue();

   	}

   	@GetMapping("/getGuestByBedId/{guestStatus}/{bedId}")
   	public ResponseEntity<GuestModel> getGuestByBedIdAndGuestStatus(@PathVariable String guestStatus, String bedId)
   	{
   		GuestModel gm=new GuestModel();
   		try {
   			Guest guest=repository.getGuestBybedIdAndGuestStatus(bedId,guestStatus);
   	   		if(guest.isGuestStatus().equalsIgnoreCase("active") ||guest.isGuestStatus().equalsIgnoreCase("inNotice") )
   	   		{
   	   			gm.setFirstName(guest.getFirstName());
   	   			gm.setId(guest.getId());
   	   			return new ResponseEntity(guest, HttpStatus.OK);
   	   		}
   				return new ResponseEntity("Guest is Inactive", HttpStatus.OK);
   		}
   		catch (Exception e) {
			// TODO: handle exception
				return new ResponseEntity(e.getMessage(), HttpStatus.OK);

		}
   		   	}
  
   	@GetMapping("/getPendingAndCompletedById/{buildingId}")
   	public List<Guest> getPendingByBuildingId(@PathVariable int buildingId) {
   	return service.getPendingByBuildingId(buildingId);
   	}
   	
//   	@GetMapping("/getFinalDueAmountForCheckout/{id}")
//   	public List<Guest> getCheckOutAmountByGuestId(@PathVariable String id){
//   	return service.getCheckOutAmountByGuestId(id);
//   	}
   	
   	@GetMapping("/get/{id}")
   	public List<Guest> getCheckOutDate(@PathVariable String id){
   		return service.getCheckOutAmountByGuestId(id);
   	}
   	
   	@GetMapping("/getFinalCheckout/{id}")
	public List<Guest> finalCheckOutGuest(@PathVariable String id){
   	return service.getFinalDueAmountById(id);
   	}
   	
   	
   	@GetMapping("/onClickDues/{id}")
   	public List<Guest> getOnlyDues(@PathVariable String id){
   		return service.getOnlyDues(id);
   	}
   	@GetMapping("/findGuestsAreInNotice/{guestStatus}")
   	public List<GuestsInNotice> findByBuildingIdAndGuestStatus(@PathVariable String guestStatus)
   	{

		return service.findByBuildingIdAndGuestStatus(guestStatus);
   	}

   	@GetMapping("/findGuestAreVacated/{guestStatus}")
   	public List<VacatedGuests> findByGuestStatus(@PathVariable String guestStatus)
   	{
		return service.findByGuestStatus(guestStatus);
   	}
   	
   	@GetMapping("/dto/{id}")
   	public GuestInfo findGuestInfoByGuestId(@PathVariable String id ){
   		return this.service.findGuestInfoById(id);
   	}
   	@GetMapping("/getTotalPaid/{id}")
   	public List<Guest> getTotalAmountByGuestId(@PathVariable String id){
   		return this.service.getTotalAmountByGuestId(id);
   	}
   	
   	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/getBedIdByGuestId/{id}")
	public ResponseEntity geeGuestBedByGuestId(@PathVariable String id) {
		
			Guest guest= repository.getBedIdById(id);
			return new ResponseEntity(guest.getBedId(),HttpStatus.OK);
   	}
@SuppressWarnings({ "unchecked", "rawtypes" })
@GetMapping("/getPhoneNumberByGuestId/{id}")
public ResponseEntity getPersonalNumberById(@PathVariable String id) {
	Guest guest = repository.getPersonalNumberById(id);
	return new ResponseEntity(guest.getPersonalNumber() , HttpStatus.OK);
}

@GetMapping("/dailyandMonthly/{guestStatus}")
public List<DailyActive> getByDailyAndMonthly(@PathVariable String guestStatus) {
 return this.service.findByGuestStatuss(guestStatus);
	
}

@SuppressWarnings("unchecked")
@GetMapping("/getNameByGuestId/{id}")
public ResponseEntity getGuestNumberById(@PathVariable String id) {
	Guest guest = repository.getNameById(id);
	return new ResponseEntity(guest.getFirstName().concat(" ").concat(guest.getLastName()) ,HttpStatus.OK );
}








}
