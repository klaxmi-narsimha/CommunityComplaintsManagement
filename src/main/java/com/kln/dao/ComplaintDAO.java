package com.kln.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kln.model.Complaint;
import com.kln.status_codes.StatusCodes;

@Component
public class ComplaintDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void residentComplaint(Complaint complaint) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.persist(complaint);
		
		
	}

	@Transactional
	public List<Complaint> getAllComplaints() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		SelectionQuery<Complaint> selectionQuery = currentSession.createSelectionQuery("SELECT c FROM Complaint c JOIN FETCH c.resident",Complaint.class);
	
		return selectionQuery.list();
		
	}

	@Transactional
	public List<Complaint> getComplaints() {
		
        Session currentSession = sessionFactory.getCurrentSession();
		
		SelectionQuery<Complaint> selectionQuery = currentSession.createSelectionQuery("SELECT c FROM Complaint c JOIN FETCH c.resident where resolutionRemark=?1 or resolutionRemark=?2",Complaint.class);
	
		selectionQuery.setParameter(1,StatusCodes.PENDING);
		selectionQuery.setParameter(1,StatusCodes.PROGESS);
		return selectionQuery.list();
		
	}

	@Transactional
	public List<Complaint> getResolvedComplaints() {
		 Session currentSession = sessionFactory.getCurrentSession();
			
			SelectionQuery<Complaint> selectionQuery = currentSession.createSelectionQuery("SELECT c FROM Complaint c JOIN FETCH c.resident Where status=?1",Complaint.class);
		
			
			selectionQuery.setParameter(1,StatusCodes.RESOLVED.name());
			
			return selectionQuery.list();
			
		}

	@Transactional
	public List<Complaint> getResidentComplaints(int id) {
		 Session currentSession = sessionFactory.getCurrentSession();
			
			SelectionQuery<Complaint> selectionQuery = currentSession.
					createSelectionQuery("SELECT c FROM Complaint c JOIN FETCH c.resident Where resident.residentId=?1",Complaint.class);
		
			selectionQuery.setParameter(1,id);
			
			return selectionQuery.list();
			
	}

	@Transactional
	public List<Complaint> getUnResolvedComplaints() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		SelectionQuery<Complaint> selectionQuery = currentSession.
				createSelectionQuery("SELECT c FROM Complaint c JOIN FETCH c.resident Where c.status!=?1",Complaint.class);
	
		selectionQuery.setParameter(1,StatusCodes.RESOLVED.name());
		
		return selectionQuery.list();
		
	}

		@Transactional
		public void updateComplaint(int complaintId, String status, String remark) {

		    Session session = sessionFactory.getCurrentSession();

		    Complaint complaint = session.find(Complaint.class, complaintId);

		    if (complaint != null) {

		        complaint.setStatus(status);
		        complaint.setResolutionRemark(remark);

		        session.merge(complaint);
		    }
		}
		
	}

	


