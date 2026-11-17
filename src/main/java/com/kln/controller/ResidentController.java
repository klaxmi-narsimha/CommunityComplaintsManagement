package com.kln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kln.model.Complaint;
import com.kln.model.ResidentEntity;
import com.kln.service.Residentservice;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ResidentController {
	

	ResidentEntity residentEntity;
	
	Complaint complaint;
	
	@Autowired
	Residentservice residentservice;
	
	
	
	
	@GetMapping("/register")	
	public String register() {

		return "register";
	}
	
  @PostMapping("/residentregister")
	
	public String residentRegister(HttpServletRequest req,Model model) {
	  
	  String p1= req.getParameter("name");
	  String p2= req.getParameter("userName");
	  String p3 = req.getParameter("block");
	  String p4 = req.getParameter("flatNumber");
	  String p5 = req.getParameter("mobileNo");
	  String p6 = req.getParameter("email");
	  String p7 = req.getParameter("password");
	  String p8 = req.getParameter("confirmPassword");

	  residentEntity=new ResidentEntity(p1,p2,p3,p4,p5,p6,p7);
	  
	  residentservice.residentRegister(residentEntity);
		return "redirect:/";
		
	}
   @GetMapping("/residentpanel")
  public String registerResident(HttpServletRequest req,HttpSession session) {
	   
	   String p1 = req.getParameter("email");
	   String p2 = req.getParameter("password");
	   
	   ResidentEntity residentLogin = residentservice.residentLogin(p1, p2);
	   
	   if(residentLogin!=null) {
		   
		   session.setAttribute("loggedResident", residentLogin);
		   
	   return "residentPanel";
	  }
	   else {
		   
		   return "redirect:/";
	   }
  }
   
   @GetMapping("/back")
   public String back() {
	   
	return "residentPanel";
	   
	   
   }
   
   
   @GetMapping("/complaintform")
   public String complaintForm(HttpSession session) {
	   
	   ResidentEntity resident =
	            (ResidentEntity) session.getAttribute("loggedResident");
	   if(resident != null) {
	   return "complaintForm";
	   }
	   else 
		   return"redirect:/";
   }
   
   @PostMapping("/submitcomplaint")
   public String submitComplaint(HttpServletRequest request,HttpSession session) {
	   
	   ResidentEntity resident =
	            (ResidentEntity) session.getAttribute("loggedResident");
	   
	//   int residentId = resident.getResidentId();
	   
//	  int id=residentEntity.getResidentId();
//	   String email = residentEntity.getEmail();
	  // String password = residentEntity.getPassword();
	   String category = request.getParameter("category");
	    String subject = request.getParameter("subject");
	    String description = request.getParameter("description");
   
	    Complaint residentComplaint = new Complaint(category,subject,description,resident);
	    
	    residentservice.residentComplaint(residentComplaint);
	   
	    return "redirect:/home/back";

   }
   
   @GetMapping("/residentcomplaints")
   public String residentComplaints(HttpSession req,Model model) {
	   ResidentEntity resident =
	            (ResidentEntity) req.getAttribute("loggedResident");
	   
	   int id=resident.getResidentId();
	   
	   List<Complaint> residentComplaints = residentservice.getResidentComplaints(id);
	   model.addAttribute("complaints", residentComplaints);
	return "residentComplaints";
	   
	   
   }

}
