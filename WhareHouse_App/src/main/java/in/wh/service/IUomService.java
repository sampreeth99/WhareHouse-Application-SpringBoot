package in.wh.service;

import java.util.List;

import in.wh.model.Uom;

public interface IUomService {
	
	public String saveUom(Uom uom);
	
	public String updateUomById(Uom uom);
	
	public String deleteUomById(Integer id);
	
	public Uom retriveUomById(Integer id);
	
	public List<Uom> retriveAllUom();

	public boolean isUomByIdAvailable(Integer id);
	
	
	

}
