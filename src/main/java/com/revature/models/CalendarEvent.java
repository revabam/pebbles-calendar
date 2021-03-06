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

/**
 * This class is a java bean for the CALENDAR_EVENT table
 * It includes all the fields in the table as well as getters and setters for all of them
 * There are also methods that override the hashCode(), equals(), and toString() methods
 * 
 * @author Alicia Douglas | Spark1806-USF-Java | Steven Kelsey
 */

@Entity
@Component
@Table(name = "CALENDAR_EVENT")
@SequenceGenerator(name = "calendar_event_seq_name", sequenceName = "calendar_event_seq", initialValue = 3, allocationSize = 1)
public class CalendarEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_event_seq_name")
	private int id;

	@NotNull
	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "status_id")
	private int statusId;

	@NotNull
	@Column(name = "start_date_time")
	private Date startDateTime;

	@NotNull
	@Column(name = "end_date_time")
	private Date endDateTime;

	@NotNull
	@Column(name = "trainer_id")
	private String trainerId;

	@Column(name = "batch_id")
	private int batchId;

	@NotNull
	@Column(name = "subtopic_id")
	private int subTopicId;

	@Column(name = "flagged_id")
	private int flaggedId;

	public CalendarEvent() {
	}

	public CalendarEvent(int id, String title, String description, int statusId, Date startDateTime, Date endDateTime,
			String trainerId, int batchId, int subTopicId, int flaggedId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.statusId = statusId;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.trainerId = trainerId;
		this.batchId = batchId;
		this.subTopicId = subTopicId;
		this.flaggedId = flaggedId;
	}

	public CalendarEvent(String title, String description, int statusId, Date startDateTime, Date endDateTime,
			String trainerId, int batchId, int subTopicId, int flaggedId) {
		super();
		this.title = title;
		this.description = description;
		this.statusId = statusId;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.trainerId = trainerId;
		this.batchId = batchId;
		this.subTopicId = subTopicId;
		this.flaggedId = flaggedId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
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

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getSubTopicId() {
		return subTopicId;
	}

	public void setSubTopicId(int subTopicId) {
		this.subTopicId = subTopicId;
	}

	public int getFlaggedId() {
		return flaggedId;
	}

	public void setFlaggedId(int flaggedId) {
		this.flaggedId = flaggedId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + flaggedId;
		result = prime * result + id;
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
		result = prime * result + statusId;
		result = prime * result + subTopicId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
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
		if (batchId != other.batchId)
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
		if (flaggedId != other.flaggedId)
			return false;
		if (id != other.id)
			return false;
		if (startDateTime == null) {
			if (other.startDateTime != null)
				return false;
		} else if (!startDateTime.equals(other.startDateTime))
			return false;
		if (statusId != other.statusId)
			return false;
		if (subTopicId != other.subTopicId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarEvent [id=" + id + ", title=" + title + ", description=" + description + ", statusId="
				+ statusId + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", trainerId="
				+ trainerId + ", batchId=" + batchId + ", subTopicId=" + subTopicId + ", flaggedId=" + flaggedId + "]";
	}

}
