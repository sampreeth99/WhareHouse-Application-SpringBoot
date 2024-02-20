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

import in.wh.model.Uom;
import in.wh.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {
	
	@Autowired
	private IUomService uomService;
	
	@GetMapping("/register")
	public String showUomRegisterForm() {
		return "uom/uom_register_form";
	}

	@PostMapping("/save")
	public String processUomRegistration(@ModelAttribute Uom uom , Map<String, Object> map,RedirectAttributes r) {
		String savedResult=uomService.saveUom(uom);
	   r.addFlashAttribute("savedOutput",savedResult);
		return "redirect:allUoms";
	}
	
	@GetMapping("findOne")
	public String getOneUomById(Integer id,Map<String, Object> map) {
		Uom u=uomService.retriveUomById(id);
		map.put("oneUom", u);
		return "uom/show_one_uom";
		
	}

	@GetMapping("allUoms")
	public String showAllUoms(Map<String, Object> map) {
	
		List<Uom> listOfUoms=uomService.retriveAllUom();
		map.put("listOfUoms", listOfUoms);
		return "uom/all_uom";
	}
	
	@GetMapping("/edit")
	public String showUomEditForm(@RequestParam Integer id,@ModelAttribute("u") Uom uom,Map<String, Object> map) {
	
		Uom uom1=uomService.retriveUomById(id);
		if (uom1!=null) {
			BeanUtils.copyProperties(uom1, uom);
		}
		return "uom/editForm";
	}
	
	@PostMapping("/update")
	public String processUomEditForm(@ModelAttribute Uom uom,Map<String, Object> map,RedirectAttributes r) {
	
		String updatesMsg=uomService.updateUomById(uom);
		r.addAttribute("id", uom.getUomId());
		r.addFlashAttribute("updateOutput",updatesMsg);
		return "redirect:findOne";
	}
	
	
	
	
	@GetMapping("/delete")
	public String deleteOnUomById(@RequestParam Integer id,Map<String, Object> map,RedirectAttributes r) {
		String deletedOutput=uomService.deleteUomById(id);
		r.addFlashAttribute("deletedOutput",deletedOutput);
		return "redirect:allUoms";
	
	
	}

}