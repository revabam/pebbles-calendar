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
	private Integer id;

	@NotNull
	@Column(name = "curriculum_id")
	private Integer curriculum_id;

	@NotNull
	@Column(name = "batch_id")
	private Integer batch_id;

	public CalendarCurriculum() {
	}

	public CalendarCurriculum(Integer id, Integer curriculum_id, Integer batch_id) {
		super();
		this.id = id;
		this.curriculum_id = curriculum_id;
		this.batch_id = batch_id;
	}

	public CalendarCurriculum(Integer curriculum_id, Integer batch_id) {
		super();
		this.curriculum_id = curriculum_id;
		this.batch_id = batch_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCurriculum_id() {
		return curriculum_id;
	}

	public void setCurriculum_id(Integer curriculum_id) {
		this.curriculum_id = curriculum_id;
	}

	public Integer getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(Integer batch_id) {
		this.batch_id = batch_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batch_id == null) ? 0 : batch_id.hashCode());
		result = prime * result + ((curriculum_id == null) ? 0 : curriculum_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (batch_id == null) {
			if (other.batch_id != null)
				return false;
		} else if (!batch_id.equals(other.batch_id))
			return false;
		if (curriculum_id == null) {
			if (other.curriculum_id != null)
				return false;
		} else if (!curriculum_id.equals(other.curriculum_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarCurriculum [id=" + id + ", curriculum_id=" + curriculum_id + ", batch_id=" + batch_id + "]";
	}
}
