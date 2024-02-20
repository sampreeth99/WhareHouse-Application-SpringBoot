package in.wh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.wh.model.ShipmentType;
import in.wh.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipmentType")
public class ShipmentTypeController {
	
	char c=25;
	
	 {
		System.out.println("=============="+c);
	}
	
	@Autowired
	private IShipmentTypeService shipService;
	
	@GetMapping("/register")
	public String showShipmentRegisterForm() {
		return "shipment_type/shipment_register_form";
		
	}
	
	@PostMapping("/save")
	public String processShipmentRegister(@ModelAttribute ShipmentType shipmentType,Map<String, Object> map,RedirectAttributes r) {
	
		String saveOuptput=shipService.saveShipmentType(shipmentType);
		r.addFlashAttribute("savedoutput", saveOuptput);
		return "redirect:allShipmentTypes";
		
	}
	
	@GetMapping("allShipmentTypes")
	public String getAllShipmentTypes(Map<String, Object> map) {
		List<ShipmentType> listofShipmentTypes=shipService.retriveAllShipmentType();
		map.put("listOfShipmets", listofShipmentTypes);
		return "shipment_type/all_shipments";
	}
	
	@GetMapping("oneShipmentType")
	public String getOneShipmentTypeById(@RequestParam Integer id,Map<String, Object> map) {
		ShipmentType oneShipmentType=shipService.retriveShipmentTypeById(id);
		System.out.println(oneShipmentType);
		map.put("oneShipmentType", oneShipmentType);
		return "shipment_type/show_one_shipment";
	}
	
	@GetMapping("edit")
	public String showShipmentTypeEditFormById(@RequestParam Integer id,@ModelAttribute("shipForm") ShipmentType shipmentType) {
		ShipmentType shipmentType2=shipService.retriveShipmentTypeById(id);
		String updatedMsg=null;
			BeanUtils.copyProperties(shipmentType2, shipmentType);
		return "shipment_type/editForm";
	}
	
	@PostMapping("/update")
	public String processEditForm(@ModelAttribute ShipmentType shipmentType,Map<String, Object> map,RedirectAttributes r) {
		String updatedMsg=shipService.updateShipmentTypeById(shipmentType);
		r.addFlashAttribute("updatedresult", updatedMsg);
		r.addAttribute("id", shipmentType.getShipmentId());
		return "redirect:oneShipmentType";
	}
	
	@GetMapping("/deleteById")
	public String deleteShipmentById(@RequestParam Integer id,Map<String, Object> map) {
		String deleteOuput=shipService.deleteShipmentTypeById(id);
		map.put("deleteOutput", deleteOuput);
		return "shipment_type/delete_success";
	}
	
	
	
	
	
	
	
	
	
	

}
