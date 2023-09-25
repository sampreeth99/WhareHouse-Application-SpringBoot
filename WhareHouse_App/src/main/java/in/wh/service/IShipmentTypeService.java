package in.wh.service;

import in.wh.model.ShipmentType;

public interface IShipmentTypeService {
	
	public String saveShipmentType(ShipmentType shipmentType);
	
	public String updateShipmentTypeById(Integer id);
	
	public String deleteShipmentTypeById(Integer id);
	
	public ShipmentType retriveShipmentTypeById(Integer id);
	
	public Boolean isShipmentTypeByIdAvailable(Integer id);
	
	
	

}
