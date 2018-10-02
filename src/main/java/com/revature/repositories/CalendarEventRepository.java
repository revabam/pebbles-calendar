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
 * @author Derek Loisel, Batch: 1806-jun18-usf-java, Trainer: Wezley Singleton
 */
@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Integer> {

	/**
	 * This method finds a calendar event by the given calendar id
	 * 
	 * @param int id
	 * @return Calendar Event
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	CalendarEvent findCalendarEventById(int id);
	
	/**
	 * This method returns a list of calendar event corresponding with the given trainer id
	 * 
	 * @param int trainerId
	 * @return List<CalendarEvent>
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	List<CalendarEvent> findCalendarEventByTrainerId(int trainerId);

	/**
	 * This method pulls all calendar events with the given status and an end date before the given date from the database
	 * 
	 * @param int statusId
	 * @param Date currentDate
	 * @return List<CalendarEvent>
	 * @author Alicia Douglas, Batch: 1806-spark, Trainer: Steven Kelsey
	 */
	@Query("SELECT c FROM CalendarEvent c WHERE c.endDateTime <= :currentDate AND c.statusId = :statusId")
	List<CalendarEvent> findCalendarEventByStatusIdAndDate(@Param("statusId") int statusId, @Param("currentDate") Date currentDate);

}
