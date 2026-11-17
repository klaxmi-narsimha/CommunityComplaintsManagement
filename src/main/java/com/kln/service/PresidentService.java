package com.kln.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kln.dao.ComplaintDAO;
import com.kln.model.Complaint;

@Component
public class PresidentService {
	
	
	@Autowired
	ComplaintDAO complaintDAO;

	
	public List<Complaint> getAllComplaints() {
		
		return complaintDAO.getAllComplaints();
		
		
		
	}


	public List<Complaint> getComplaints() {
		
		return complaintDAO.getComplaints();
			}


	public List<Complaint> getresolvedComplaints() {
		return complaintDAO.getResolvedComplaints();
	}


	public List<Complaint> getUnResolvedComplaints() {
		return complaintDAO.getUnResolvedComplaints();
	}


	public void updateComplaint(int complaintId, String status, String remark) {
		 complaintDAO.updateComplaint(complaintId, status, remark);
		
	}
	

}
