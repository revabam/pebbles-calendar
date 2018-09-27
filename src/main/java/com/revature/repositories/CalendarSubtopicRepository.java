package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.CalendarSubtopic;

/**
 * This is the repository that implements CRUD functionality directly to the calendar_subtopic table in the database.  
 * The methods in this class are called from the CalendarService class methods. You can create custom methods here, or use the built-in JPA methods available by extending the JPA repository such as findAll() and save().
 * @author Derek Loisel, Batch: 1806-jun18-usf-java, Trainer: Wezley Singleton
 */
@Repository
public interface CalendarSubtopicRepository extends JpaRepository<CalendarSubtopic, Integer> {

	CalendarSubtopic findCalendarSubtopicById(int id);
	
}
