package org.springframework.samples.petclinic.junit5;

public class Study {
	private StudyStatus status = StudyStatus.DRAFT;

	public StudyStatus getStatus() {
		return status;
	}

	public void setStatus(StudyStatus status) {
		this.status = status;
	}
}
