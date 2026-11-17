package com.kln.service;


import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kln.dao.ComplaintDAO;
import com.kln.dao.ResidentDAO;
import com.kln.model.Complaint;
import com.kln.model.ResidentEntity;

@Component
public class Residentservice {
	
	@Autowired
	ResidentDAO residentDAO;
	
	@Autowired
	ComplaintDAO complaintDAO;
	
	public  void residentRegister(ResidentEntity resident) {
		
		residentDAO.residentRegister(resident);
		
	}
	
public  ResidentEntity residentLogin(String email,String password) {
		
		ResidentEntity resident = residentDAO.residentLogin(email,password);
		if(resident != null) {
			return resident;
		}
		else {
			return null;
		}
		
	}

public String residentComplaint(Complaint complaint) {
	
	complaintDAO.residentComplaint(complaint);
	
	return null;
	
	
}

public List<ResidentEntity> getAllResidents() {
	
	List<ResidentEntity> allResidents = residentDAO.getAllResidents();
	
	return allResidents;
}

public List<Complaint> getResidentComplaints(int id) {
	return complaintDAO.getResidentComplaints(id);
	
	
}
	
}
