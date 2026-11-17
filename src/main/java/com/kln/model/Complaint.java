package com.kln.model;


import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int complaintId;

    @Column(nullable = false)
    private String category;
    
    @Column(nullable = false)
    private String subject;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String status = "PENDING";

    private String resolutionRemark;

    private LocalDateTime createdAt;

    // Foreign Key Relationship

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id", nullable = false)
    private ResidentEntity resident;


    public Complaint() {
    }


    // Automatically set date and status before saving

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();

        if (this.status == null) {
            this.status = "PENDING";
        }
        
        
    }


	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", category=" + category + ", subject=" + subject
				+ ", description=" + description + ", status=" + status + ", resolutionRemark=" + resolutionRemark
				+ ", createdAt=" + createdAt + ", resident=" + resident + "]";
	}


	public int getComplaintId() {
		return complaintId;
	}


	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getResolutionRemark() {
		return resolutionRemark;
	}


	public void setResolutionRemark(String resolutionRemark) {
		this.resolutionRemark = resolutionRemark;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public ResidentEntity getResident() {
		return resident;
	}


	public void setResident(ResidentEntity resident) {
		this.resident = resident;
	}
	public void Complaint() {
		
	}

	public Complaint(String category,String subject,String description,ResidentEntity resident) {
		super();
		this.category = category;
		this.subject = subject;
		this.description = description;
		this.resident = resident;
	}


	public Complaint(int complaintId, String category, String subject, String description, String status,
			String resolutionRemark, LocalDateTime createdAt, ResidentEntity resident) {
		super();
		this.complaintId = complaintId;
		this.category = category;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.resolutionRemark = resolutionRemark;
		this.createdAt = createdAt;
		this.resident = resident;
	}


	public Complaint(String category, String subject, String description, String status, String resolutionRemark,
			LocalDateTime createdAt, ResidentEntity resident) {
		super();
		this.category = category;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.resolutionRemark = resolutionRemark;
		this.createdAt = createdAt;
		this.resident = resident;
	}


    
}