package com.revature.models;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="CALENDAR_EVENT")
@SequenceGenerator(name="calendar_event_seq_name", sequenceName="calendar_event_seq", initialValue=3, allocationSize=1)
public class CalendarEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="calendar_event_seq_name")
	private Integer id;
	
	@NotNull
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="status_id")
	private Integer status_id;
	
	@NotNull
	@Column(name="start_date_time")
	private Date startDateTime;
	
	@NotNull
	@Column(name="end_date_time")
	private Date endDateTime;
	
	@NotNull
	@Column(name="calendar_subtopic_id")
	private Integer calendarSubtopic_id;
	
	public CalendarEvent() {}

	public CalendarEvent(Integer id, String title, String description, Integer status_id, Date startDateTime,
			Date endDateTime, Integer calendarSubtopic_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status_id = status_id;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.calendarSubtopic_id = calendarSubtopic_id;
	}

	public CalendarEvent(String title, String description, Integer status_id, Date startDateTime, Date endDateTime,
			Integer calendarSubtopic_id) {
		super();
		this.title = title;
		this.description = description;
		this.status_id = status_id;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.calendarSubtopic_id = calendarSubtopic_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Integer getCalendarSubtopic_id() {
		return calendarSubtopic_id;
	}

	public void setCalendarSubtopic_id(Integer calendarSubtopic_id) {
		this.calendarSubtopic_id = calendarSubtopic_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calendarSubtopic_id == null) ? 0 : calendarSubtopic_id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
		result = prime * result + ((status_id == null) ? 0 : status_id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		CalendarEvent other = (CalendarEvent) obj;
		if (calendarSubtopic_id == null) {
			if (other.calendarSubtopic_id != null)
				return false;
		} else if (!calendarSubtopic_id.equals(other.calendarSubtopic_id))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDateTime == null) {
			if (other.endDateTime != null)
				return false;
		} else if (!endDateTime.equals(other.endDateTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startDateTime == null) {
			if (other.startDateTime != null)
				return false;
		} else if (!startDateTime.equals(other.startDateTime))
			return false;
		if (status_id == null) {
			if (other.status_id != null)
				return false;
		} else if (!status_id.equals(other.status_id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarEvent [id=" + id + ", title=" + title + ", description=" + description + ", status_id="
				+ status_id + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", calendarSubtopic_id=" + calendarSubtopic_id + "]";
	}
	
	
}
