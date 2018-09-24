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
@Table(name = "CALENDAR_CURRICULUM")
@SequenceGenerator(name = "calendar_curriculum_seq_name", sequenceName = "calendar_curriculum_seq", initialValue = 3, allocationSize = 1)
public class CalendarCurriculum implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_curriculum_seq_name")
	private int id;

	@NotNull
	@Column(name = "curriculum_id")
	private int curriculumId;

	@NotNull
	@Column(name = "batch_id")
	private int batchId;

	public CalendarCurriculum() {
	}

	public CalendarCurriculum(int id, int curriculumId, int batchId) {
		super();
		this.id = id;
		this.curriculumId = curriculumId;
		this.batchId = batchId;
	}

	public CalendarCurriculum(int curriculumId, int batchId) {
		super();
		this.curriculumId = curriculumId;
		this.batchId = batchId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(int curriculumId) {
		this.curriculumId = curriculumId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + curriculumId;
		result = prime * result + id;
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
		CalendarCurriculum other = (CalendarCurriculum) obj;
		if (batchId != other.batchId)
			return false;
		if (curriculumId != other.curriculumId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarCurriculum [id=" + id + ", curriculumId=" + curriculumId + ", batchId=" + batchId + "]";
	}

}
