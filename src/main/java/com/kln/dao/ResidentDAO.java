package com.kln.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kln.model.ResidentEntity;


@Component
public class ResidentDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public String residentRegister(ResidentEntity resident) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.persist(resident);
		
		return null;
		
		
		
	}

	@Transactional
	public ResidentEntity residentLogin(String email,String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		SelectionQuery<ResidentEntity> selectionQuery = currentSession.createSelectionQuery("From ResidentEntity Where email=?1 and password=?2",ResidentEntity.class);
		
		selectionQuery.setParameter(1,email);
		selectionQuery.setParameter(2,password);
		
		ResidentEntity uniqueResult = selectionQuery.uniqueResult();
		
		return uniqueResult;
		
	}

	@Transactional
	public List<ResidentEntity> getAllResidents() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<ResidentEntity> query = currentSession.createQuery("From ResidentEntity",ResidentEntity.class);
		
		return query.list();
		
	}

}
