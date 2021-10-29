package com.xoriant.banking.poc.controller;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;
import org.w3c.dom.Entity;

import com.xoriant.banking.poc.dao.ManagerDaoImpl;
import com.xoriant.banking.poc.model.Address;
import com.xoriant.banking.poc.model.Branch;
import com.xoriant.banking.poc.model.Gender;
import com.xoriant.banking.poc.model.ManagerAuth;
import com.xoriant.banking.poc.model.PersonInfo;
import com.xoriant.banking.poc.model.Roles;
import com.xoriant.banking.poc.service.ManagerService;

@Controller
public class ManagerController {
    @Value("${spring.application.name}")
    
  
    String appName;

   @Autowired
   ManagerService managerService;
    
    @RequestMapping
    public String index(Model model) {
    	System.out.println(System.getProperty("user.dir"));

        return "index";
    }
    
    @GetMapping("/greeting")
        public String greetingForm(Model model) {
          model.addAttribute("greeting", new Greeting());
          return "greeting";
        }
    
//    @GetMapping("/home")
//    public String abc(Model model) {
//      model.addAttribute("manager", new ManagerAuth());
//      return "home";
//    }

        @PostMapping("/greeting")
        public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
          model.addAttribute("greeting", greeting);
          return "result";
        }
        
//        @PostMapping("/home")
//        public String loginSubmit(@ModelAttribute ManagerAuth login, Model model) {
//        	if(login.getUserName().equals("admin")&&login.getPass().equals("123"))
//        		{
//        		//insert into userlogin tables
//        		   System.out.println("==========Login success...================");
//        		   return "home";
//        		}
//        	else
//        	{
//        		
//        		 System.out.println("<<<<<<<<----------Login Fails-------->>>>>>>>>>");
//        		 model.addAttribute("Loing Fails", login);
//        		 return "home";
//        	}
//
////         
//        }
        
//        @GetMapping("/managerHome")
//        public String managerHome1(Model model) {
//         
//            return "managerHome";
//        }
        
        @GetMapping("/managerHome")
        public String managerHome(Model model) {
          return "managerHome";
        }
        @GetMapping("/addBranch")
        public String addBranch(Model model) {
        	 model.addAttribute("branch", new Branch());
         
          return "addBranch";
        }
        
        @PostMapping("/addBranch")
        public String addBranchPerform(@RequestParam("userName") String userName,
        		@RequestParam("password") String password,
        		@RequestParam("branchId") String branchId,
        		@RequestParam("branchName") String branchName,
        		@RequestParam("ifscCode") String ifscCode,
        		@RequestParam("micrCode") String micrCode
         	 
        		) {
        	
         
        	
        	
        	if(userName.equals("admin")&&password.equals("admin"))
        		{
        		  Branch branchObj = new Branch();
        		  branchObj.setBranchId(Integer.parseInt(branchId));
        		  branchObj.setBranchName(branchName); 
        		  branchObj.setIfscCode(ifscCode);
        		  branchObj.setMicrCode(micrCode);
        		  
     
     		 managerService.addNewBranch(branchObj);
        		   System.out.println("==========Branch Added success...================");
        		 
        		   return "addBranch";
        		}
        	else
        	{
        		
        		 System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");
        		 
        		 return "addBranch";
        	}
       
        }
        
        
        @PostMapping("/addCustomer")
        public String addCustomerPerform(@RequestParam("userName") String userName,
        		@RequestParam("password") String password,
        	
        		@RequestParam("personName") String personName,
        		@RequestParam("dateOfBirth") String dateOfBirth,
        		@RequestParam("mobile") String mobile,
        		@RequestParam("doorNo") int doorNo,
        		@RequestParam("city") String city,
        		@RequestParam("area") String area,
        		@RequestParam("state") String state,
        		@RequestParam("pinCode") String pinCode,
        		@RequestParam("branchId") int branchId,
        		@RequestParam("gender") String gender
         	 
        		) {

        	if(userName.equals("admin")&&password.equals("admin"))
        		{
        		int g_id;
        		if(gender.equals("MALE"))
        			g_id=1;
        		else
        			g_id=2;
        		  Gender gen = new Gender(g_id,gender);
        		  Roles roles = new Roles(1,"CUSTOMER");
        		  Address address = new Address(doorNo,city,area, state,pinCode.toString(),"CUSTOMER",branchId);
        		  PersonInfo personInfo = new PersonInfo(personName,gen,dateOfBirth,mobile,address,roles,"CUSTOMER");     
     		 managerService.addNewPerson(personInfo);
        		   System.out.println("==========Customer Added success...================");
        		 
        		   return "addCustomer";
        		}
        	else
        	{
        		
        		 System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");
        		 
        		 return "addCustomer";
        	}
       
        }
        
        @PostMapping("/updateCustomer")
        public String updateCustomerPerform(@RequestParam("userName") String userName,
        		@RequestParam("password") String password,
        	
        		@RequestParam("personName") String personName,
        		@RequestParam("dateOfBirth") String dateOfBirth,
        		@RequestParam("mobile") String mobile,
        		@RequestParam("customerId") int customerId
        	
         	 
        		) {

        	if(userName.equals("admin")&&password.equals("admin"))
        		{
        		  PersonInfo personInfo = new PersonInfo();
        		  personInfo.setPersonName(personName);;
        		  personInfo.setDob(dateOfBirth);
        		  personInfo.setMobNumber(mobile);
        		 personInfo.setPersonType("MANAGER");;
        	 		 managerService.updateCustomer(customerId,personInfo);
        		   System.out.println("==========Customer Updated success...================");
        		 
        		   return "updateCustomer";
        		}
        	else
        	{
        		
        		 System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");
        		 
        		 return "updateCustomer";
        	}
       
        }
        
        
        @PostMapping("/deleteCustomer")
        public String deleteCustomerPerform(@RequestParam("userName") String userName,
        		@RequestParam("password") String password, 
        		@RequestParam("customerId") int customerId
        	
         	 
        		) {

        	if(userName.equals("admin")&&password.equals("admin"))
        		{
        		 
        	 		 managerService.deleteCustomer(customerId);
        		   System.out.println("==========Customer Deleted success...================");
        		 
        		   return "deleteCustomer";
        		}
        	else
        	{
        		
        		 System.out.println("<<<<<<<<----------Admin Login Fails-------->>>>>>>>>>");
        		 
        		 return "deleteCustomer";
        	}
       
        }
        
        
        
        @GetMapping("/addCustomer")
        public String addCustomer(Model model) {
          return "addCustomer";
        }
        
        @GetMapping("/updateCustomer")
        public String updateCustomer(Model model) {
          return "updateCustomer";
        }
        @GetMapping("/addAccount")
        public String addAccount(Model model) {
          return "addAccount";
        }
        @GetMapping("/editAccount")
        public String editAccount(Model model) {
          return "editAccount";
        }
        @GetMapping("/deleteAccount")
        public String deleteAccount(Model model) {
          return "deleteAccount";
        }
        
        @GetMapping("/deleteCustomer")
        public String deleteCustomer(Model model) {
          return "deleteCustomer";
        }
        @GetMapping("/viewCustomerList")
        public String viewCustomerList(Model model) {
          return "viewCustomerList";
        }
        @GetMapping("/transaction")
        public String transaction(Model model) {
          return "transaction";
        }
        
        

//        
//        @GetMapping("/error")
//        public String error(Model model) {
//        
//            return "error";
//        }
        
        @GetMapping("/customerHome")
        public String customerHome(Model model) {
        
            return "customerHome";
        }
        
}