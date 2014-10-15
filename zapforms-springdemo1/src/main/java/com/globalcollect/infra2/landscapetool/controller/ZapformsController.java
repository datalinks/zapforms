package com.globalcollect.infra2.landscapetool.controller;

import java.util.List;

import com.globalcollect.infra2.landscapetool.config.LandscapeVariables;
import com.globalcollect.infra2.landscapetool.model.AjaxResponseHolder;
import com.globalcollect.infra2.landscapetool.model.Customer;
import com.globalcollect.infra2.landscapetool.model.CustomerDao;

import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan("com.globalcollect.infra2.landscapetool.controller")
public class ZapformsController implements LandscapeVariables { 
    
    private static final org.slf4j.Logger log  = LoggerFactory.getLogger(ZapformsController.class);
    private String exceptionMessage;
            
    @Autowired
    SessionFactory sessionFactory;

    
    @RequestMapping("/")
    public ModelAndView showIndex(String name, Model model, String id) {
       Customer customer = CustomerDao.getCustomer(id,sessionFactory);
        ModelAndView returnModel = new ModelAndView("customerPage");
        returnModel.addObject("ajrh", customer);
        return returnModel;
    }


    @RequestMapping("/getCustomer")
    public ModelAndView getCustomer(@RequestParam(value="id", required=false ) String id, Model model) {
       Customer customer = CustomerDao.getCustomer(id,sessionFactory);
       
        ModelAndView returnModel = new ModelAndView("customerPage");
        returnModel.addObject("customer", customer);
        return returnModel;
    }

    

    @RequestMapping("/ajax_calc_customer")
    public @ResponseBody
    String ajax_calc_customer(  @RequestParam(value="id", required=false ) String id,
                                @RequestParam(value="balance", required=true ) String balance,
                                @RequestParam(value="amount", required=true ) String amount,
                                Model model) {
        
        double balanceD = new Double(balance).doubleValue();
        double amountD = new Double(amount).doubleValue();
        double calcedD = balanceD-amountD;
        String result = new Double(calcedD).toString();
        System.out.println("NUMBERS: "+id+" balance "+balance+" amount "+amount+" calc"+result);
        return result;
    }

    
    
    @RequestMapping("/ajax_save_customer")
    public @ResponseBody
    String ajax_save_customer(  @RequestParam(value="id", required=false ) String id,
                                @RequestParam(value="balance", required=true ) String balance,
                                @RequestParam(value="amount", required=true ) String amount,
                                Model model) {
        
        double balanceD = new Double(balance).doubleValue();
        double amountD = new Double(amount).doubleValue();
        double calcedD = balanceD-amountD;
        String result = new Double(calcedD).toString();

        CustomerDao.saveBalance(id,calcedD,sessionFactory);
        return result;
    }

    
    
    @RequestMapping("/showCustomers")
    public @ResponseBody ModelAndView showCustomers(Model model) {
       
    	List<Customer> customer = CustomerDao.getCustomers(sessionFactory);
        ModelAndView returnModel = new ModelAndView("allCustomerPage");
        returnModel.addObject("customerz", customer);
        return returnModel;

    }

    
    
    @RequestMapping("/ajax_get_customer")
    public @ResponseBody
    String ajax_get_customer(@RequestParam(value="id", required=false ) String id, Model model) {
    	Customer customer = null;
    	try{
        	customer = CustomerDao.getCustomer(id,sessionFactory);    		
    	}catch(Exception ex){
    		log.error("exception getting customer with id "+id);
    	}
        AjaxResponseHolder ajrh = new AjaxResponseHolder();
        ajrh.setCreditcardUserId(customer.getId());
        ajrh.setCreditcardUserName(customer.getName());
        ajrh.setExceptionMsg(exceptionMessage);
        ajrh.setBalance(customer.getBalance());
   
        String result = customer.getId()+"|:|"+customer.getName()+"|:|"+customer.getBalance();
        return result;
    }

    
}
