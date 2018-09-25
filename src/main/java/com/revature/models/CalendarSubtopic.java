package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "CALENDAR_SUBTOPIC")
@SequenceGenerator(name = "calendar_subtopic_seq_name", sequenceName = "calendar_subtopic_seq", initialValue = 3, allocationSize = 1)
public class CalendarSubtopic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_subtopic_seq_name")
	private int id;

	@NotNull
	@Column(name = "subtopic_id")
	private int subtopicId;

	@NotNull
	@Column(name = "calendar_curriculum_id")
	private int calendarCurriculumId;

	public CalendarSubtopic() {
	}

	public CalendarSubtopic(int id, int subtopicId, int calendarCurriculumId) {
		super();
		this.id = id;
		this.subtopicId = subtopicId;
		this.calendarCurriculumId = calendarCurriculumId;
	}

	public CalendarSubtopic(int subtopicId, int calendarCurriculumId) {
		super();
		this.subtopicId = subtopicId;
		this.calendarCurriculumId = calendarCurriculumId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubtopicId() {
		return subtopicId;
	}

	public void setSubtopicId(int subtopicId) {
		this.subtopicId = subtopicId;
	}

	public int getCalendarCurriculumId() {
		return calendarCurriculumId;
	}

	public void setCalendarCurriculumId(int calendarCurriculumId) {
		this.calendarCurriculumId = calendarCurriculumId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calendarCurriculumId;
		result = prime * result + id;
		result = prime * result + subtopicId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarSubtopic other = (CalendarSubtopic) obj;
		if (calendarCurriculumId != other.calendarCurriculumId)
			return false;
		if (id != other.id)
			return false;
		if (subtopicId != other.subtopicId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarSubtopic [id=" + id + ", subtopicId=" + subtopicId + ", calendarCurriculumId="
				+ calendarCurriculumId + "]";
	}

}
