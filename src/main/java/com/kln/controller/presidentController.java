package com.kln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kln.model.Complaint;
import com.kln.service.PresidentService;
import com.kln.service.Residentservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class presidentController {
	
	@Autowired
	Residentservice residentService;
	
	@Autowired
	PresidentService presidentService;
	
	final String userName="admin@123";
	final String password="admin@123";
	
	
	@GetMapping("/presidentlogin")
	public String presidentLogin() {
		
		return "presidentLogin";
		
	}
	
	
	@GetMapping("/presidentpanel")
	public String presidentpanel(HttpServletRequest req) {
		
		
		String u = req.getParameter("username");
		String p = req.getParameter("password");
		
		if(userName.equals(u) && password.equals(p)) {
			req.getSession().setAttribute("loggedIn",true);
			
		return "presidentPanel";
		}
		
		else {
		return "presidentLogin";
		}
	}
	
	@GetMapping("/residentslist")
	public String residentsList(Model model,HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		
		if(session==null || session.getAttribute("loggedIn")==null) {
			  return "redirect:/";
	    }
		else {
			 model.addAttribute("residents", residentService.getAllResidents());
			    return "residentsList";
		}	
	}
	
	@GetMapping("/viewcomplaints")
	public String viewComplaints(HttpServletRequest req,Model model) {
		
		HttpSession session=req.getSession(false);
		
		List<Complaint> allComplaints=presidentService.getComplaints();
		model.addAttribute("complaints",allComplaints);
		if(session==null || session.getAttribute("loggedIn")==null) {
			 return "redirect:/home/presidentlogin";
	    }
		else {
		return "allComplaints";
		}
	}
	
	@GetMapping("/allcomplaints")
	public String allComplaints(HttpServletRequest req,Model model) {
		HttpSession session=req.getSession(false);
		 
		List<Complaint> allComplaints=presidentService.getAllComplaints();
		model.addAttribute("complaints",allComplaints);
		 
		if(session==null || session.getAttribute("loggedIn")==null) {
			 return "redirect:/home/presidentlogin";
	    }
		else {
		return "allComplaints";
		}
	}
	
	@GetMapping("/resolvedcomplaints")
	public String resolvedComplaints(HttpServletRequest req,Model model) {
		
		HttpSession session=req.getSession(false);
		
		List<Complaint> allComplaints=presidentService.getresolvedComplaints();
		model.addAttribute("complaints",allComplaints);
		
		
		if(session==null || session.getAttribute("loggedIn")==null) {
			 return "redirect:/home/presidentlogin";
	    }
		else {
		return "resolvedComplaints";
		}
	}
	
	

	@GetMapping("/complaints")
	public String unResolvedComplaints(HttpServletRequest req,Model model){
		 List<Complaint> allComplaints=presidentService.getUnResolvedComplaints();
			model.addAttribute("complaints",allComplaints);
			
			HttpSession session=req.getSession(false);
			
			if(session==null || session.getAttribute("loggedIn")==null) {
				  return "redirect:/home/presidentlogin";
		    }
			else {
			return "complaints";
			}
	}
	
	@GetMapping("/dashboard")
	public String back(HttpServletRequest req) {
		
		HttpSession session=req.getSession(false);
		
		if(session==null || session.getAttribute("loggedIn")==null) {
			 return "redirect:/home/presidentlogin";
	    }
		return "presidentPanel";
	}
	
	@PostMapping("/updatecomplaint")
	public String updateComplaint(HttpServletRequest request) {

		int complaintId = Integer.parseInt(
			    request.getParameter("complaintId")
			);
	    String status = request.getParameter("status");

	    String remark = request.getParameter("resolutionRemark");

	    presidentService.updateComplaint(complaintId, status, remark);

	    return "redirect:/home/dashboard";
	}
	
	
}
