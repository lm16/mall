package controller;

import bean.Customer;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import service.CustomerService;
import service.impl.CustomerServiceImpl;

@Controller
@SessionAttributes("customerName")
public class CustomerController {

    private CustomerService userService = new CustomerServiceImpl();

    
    
    @RequestMapping(value="/validate.do", method= RequestMethod.POST)
    public @ResponseBody String validate(@RequestBody Customer customer, ModelMap modelmap){

        String result = userService.validate(customer);
        System.out.println(customer.getCustomerName()+"\n"+customer.getCustomerPass());

        if(result.equals("success")) {
        	modelmap.addAttribute("customerName", customer.getCustomerName());
        }
        
        return result;
    }

    @RequestMapping(value="/register.do", method=RequestMethod.POST)
    public @ResponseBody String register(@RequestBody Customer customer){

        String result = userService.register(customer);

        

        return result;
    }
    
    @RequestMapping("/logout.do")
    public String logout(SessionStatus status, HttpSession session){

        session.removeAttribute("customerName");

        status.setComplete();

        return "shop.jsp";
    }


}
