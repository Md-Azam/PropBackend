package com.arshaa.repository;

import com.arshaa.entity.Guest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
    Guest findById(String guestId);

	Guest getGuestBybedId(String bedId);

	Guest getGuestBybedIdAndGuestStatus(String bedId, String guestStatus);

	Optional<Guest> findByBuildingId(int buildingId);

	Optional<List<Guest>> findByBuildingIdAndGuestStatus(int buildingId, String guestStatus);

	List<Guest> findByGuestStatus(String guestStatus);
	
	
	
	Guest getPersonalNumberById(String id);
	
	Guest getBedIdById(String id );
	
	Guest getNameById(String id);
	
	
	
	



}
