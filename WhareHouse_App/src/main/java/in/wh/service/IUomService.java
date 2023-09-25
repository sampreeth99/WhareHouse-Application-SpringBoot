package in.wh.service;

import in.wh.model.Uom;

public interface IUomService {
	
	public String saveUom(Uom uom);
	
	public String updateUomById(Integer id);
	
	public String deleteUomById(Integer id);
	
	public Uom retriveUomById(Integer id);
	
	public boolean isUomByIdAvailable(Integer id);
	
	
	

}
