import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class ClientExampleController {
	
  	RestTemplate employeeClient = new RestTemplate();
	UIData uiData = new UIData();

	public String serviceUrl() {
	    return "http://localhost:8012";
	}
	
    @RequestMapping(value="/emplist", method=RequestMethod.GET)
    public String listEmployee(Model model) {
    	Employee[] employees = employeeClient.getForObject(serviceUrl()+"/employees",Employee[].class);
    	uiData.setEmployees(Arrays.asList(employees));
       model.addAttribute("uidata",uiData );
        return "list";
    } 

    @RequestMapping(value="/empinfo/{empNo}", method=RequestMethod.GET)
    public String Infoemployee(Model model, @PathVariable("empNo") String empNo) {
    	Employee employee = employeeClient.getForObject(serviceUrl()+"/employee/"+empNo, Employee.class);
    	uiData.setEmployee(employee);
       model.addAttribute("uidata",uiData );
        return "employee";
    } 
    
    @RequestMapping(value="/addemployee/{action}/{empNo}", method=RequestMethod.GET)
    public String addEmployeeForm(Model model, @PathVariable("action") String action, @PathVariable("empNo") String empNo) {
    	if (action.equals("UPDATE") && !empNo.contentEquals("new")) {
    		Employee employee = employeeClient.getForObject(serviceUrl()+"/employee/"+empNo, Employee.class);
        	uiData.setEmployee(employee);
        	uiData.setAction("UPDATE");
    	} else uiData.setAction("ADD");
       model.addAttribute("uidata",uiData );
        return "add";
    }   

    @RequestMapping(value="/addemployee/{action}", method=RequestMethod.POST)
    public String addEmployee(@ModelAttribute UIData uiData, Model model, @PathVariable("action") String action) throws RestClientException, UnsupportedEncodingException {
    	if (action.equals("ADD"))
    	 employeeClient.postForObject(serviceUrl()+"/employee", uiData.getEmployee(), Employee.class);
    	else
    	 employeeClient.put("serviceUrl()+\"/employee", uiData.getEmployee());	
        return "redirect:/emplist"; 
    }
    
    @RequestMapping(value="/delemployee/{empNo}", method=RequestMethod.GET)
    public String delEmployee(Model model,@PathVariable("empNo") String empNo) {
    	employeeClient.delete(serviceUrl()+"/employee/"+empNo); 
        return "redirect:/emplist";
    }

}