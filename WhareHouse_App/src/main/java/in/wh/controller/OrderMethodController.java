package in.wh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.wh.model.OrderMethod;
import in.wh.service.IOrderMethodService;

@Controller
@RequestMapping("orderMethod")
public class OrderMethodController {
	
	@Autowired
	private IOrderMethodService orderMethodSeervice;
	
	
	@GetMapping("/register")
	public String showOrderRegisterForm() {
		return "order/registerForm";
	}
	

	@PostMapping("/submit")
	public String submitOrderRegisterForm(@ModelAttribute("or") OrderMethod orderMethod,Map<String , Object> map,RedirectAttributes attr) {
		System.out.println(orderMethod);
		String registerResult=orderMethodSeervice.saveOrderMethod(orderMethod);
		attr.addFlashAttribute("registerResult", registerResult);
		
		return "redirect:showOrders";
		
	}
	
	@GetMapping("/edit")
	public String showOrderUpdateForm(@RequestParam("id") Integer id,@ModelAttribute("o" )OrderMethod orderMethod ){
		OrderMethod ot=orderMethodSeervice.getOneOrderMethodById(id);
		BeanUtils.copyProperties(ot, orderMethod);
		return "order/editForm";
	}
	
	@GetMapping("/showOrders")
	public String showAllOrders(Map<String, Object> map) {
		List<OrderMethod> li=orderMethodSeervice.getAllOrderMethod();
	    int size=li.size();
	    String msg;
	    if(size<1) {
	    	msg="No records Found";
	    	map.put(msg, msg);
	    }else {
	    	map.put("liOrders",li );
	    }
		return "order/showOrder";
	}
	
	@GetMapping("/oneOrder")
	public String showOneOrderById(@RequestParam Integer id,Map<String,Object> map) {
		
		OrderMethod o=orderMethodSeervice.getOneOrderMethodById(id);
		map.put("orderMethod", o);
		
		
		return "order/oneOrderMethod";
	}
	
	@GetMapping("/deleteOne")
	public String deleteOneOrderById(@RequestParam("id")Integer id,RedirectAttributes at) {
		
		String delmsg=orderMethodSeervice.deleteOrderMethodById(id);
		at.addFlashAttribute("delmsg", delmsg);
		return "redirect:showOrders";
	}
	
	
	
	
	

}
