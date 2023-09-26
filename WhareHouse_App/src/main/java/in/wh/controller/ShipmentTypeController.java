package in.wh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.wh.model.ShipmentType;
import in.wh.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipmentType")
public class ShipmentTypeController {
	
	@Autowired
	private IShipmentTypeService shipService;
	
	@GetMapping("/register")
	public String showShipmentRegisterForm() {
		return "shipment_register_form";
		
	}
	
	@PostMapping("/save")
	public String processShipmentRegister(@ModelAttribute ShipmentType shipmentType,Map<String, Object> map) {
	
		String saveOuptput=shipService.saveShipmentType(shipmentType);
		map.put("savedResultMsg", saveOuptput);
		return "register_success";
		
	}
	
	@GetMapping("allShipmentTypes")
	public String getAllShipmentTypes(Map<String, Object> map) {
		List<ShipmentType> listofShipmentTypes=shipService.retriveAllShipmentType();
		map.put("listOfShipmets", listofShipmentTypes);
		return "all_shipments";
	}
	
	@GetMapping("oneShipmentType")
	public String getOneShipmentTypeById(@RequestParam Integer id,Map<String, Object> map) {
		ShipmentType oneShipmentType=shipService.retriveShipmentTypeById(id);
		System.out.println(oneShipmentType);
		map.put("oneShipmentType", oneShipmentType);
		return "show_one_shipment";
	}
	
	@GetMapping("/deleteById")
	public String deleteShipmentById(@RequestParam Integer id,Map<String, Object> map) {
		String deleteOuput=shipService.deleteShipmentTypeById(id);
		map.put("deleteOuput", deleteOuput);
		return "forward:allShipmentTypes";
	}
	
	
	
	
	
	
	

}
