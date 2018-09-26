package com.revature.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.CalendarEvent;

/**
 * This is the repository that implements CRUD functionality directly to the
 * calendar_event table in the database. The methods in this class are called
 * from the CalendarService class methods. You can create custom methods here,
 * or use the built-in JPA methods available by extending the JPA repository
 * such as findAll() and save().
 * 
 * @author author Derek Loisel batch 1806-jun18-usf-java trainer Wezley
 *         Singleton
 */
@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Integer> {

	CalendarEvent findCalendarEventById(int id);

	@Query("SELECT c FROM CalendarEvent c WHERE c.endDateTime <= :currentDate AND c.statusId = :statusId")
	List<CalendarEvent> findCalendarEventByStatusIdAndDate(@Param("statusId") int statusId, @Param("currentDate") Date currentDate);

}
