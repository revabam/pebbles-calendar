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
	private Integer id;

	@NotNull
	@Column(name = "subtopic_id")
	private Integer subtopic_id;

	@NotNull
	@Column(name = "calendar_curriculum_id")
	private Integer calendarCurriculum_id;

	public CalendarSubtopic() {
	}

	public CalendarSubtopic(Integer id, Integer subtopic_id, Integer calendarCurriculum_id) {
		super();
		this.id = id;
		this.subtopic_id = subtopic_id;
		this.calendarCurriculum_id = calendarCurriculum_id;
	}

	public CalendarSubtopic(Integer subtopic_id, Integer calendarCurriculum_id) {
		super();
		this.subtopic_id = subtopic_id;
		this.calendarCurriculum_id = calendarCurriculum_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubtopic_id() {
		return subtopic_id;
	}

	public void setSubtopic_id(Integer subtopic_id) {
		this.subtopic_id = subtopic_id;
	}

	public Integer getCalendarCurriculum_id() {
		return calendarCurriculum_id;
	}

	public void setCalendarCurriculum_id(Integer calendarCurriculum_id) {
		this.calendarCurriculum_id = calendarCurriculum_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calendarCurriculum_id == null) ? 0 : calendarCurriculum_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subtopic_id == null) ? 0 : subtopic_id.hashCode());
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
		if (calendarCurriculum_id == null) {
			if (other.calendarCurriculum_id != null)
				return false;
		} else if (!calendarCurriculum_id.equals(other.calendarCurriculum_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (subtopic_id == null) {
			if (other.subtopic_id != null)
				return false;
		} else if (!subtopic_id.equals(other.subtopic_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarSubtopic [id=" + id + ", subtopic_id=" + subtopic_id + ", calendarCurriculum_id="
				+ calendarCurriculum_id + "]";
	}
}
