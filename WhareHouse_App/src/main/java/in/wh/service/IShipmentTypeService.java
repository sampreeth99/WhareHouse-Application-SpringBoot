package in.wh.service;

import java.util.List;

import in.wh.model.ShipmentType;

public interface IShipmentTypeService {
	
	public String saveShipmentType(ShipmentType shipmentType);
	
	public String updateShipmentTypeById(ShipmentType shipmentType);
	
	public String deleteShipmentTypeById(Integer id);
	
	public ShipmentType retriveShipmentTypeById(Integer id);
	
	public List<ShipmentType> retriveAllShipmentType();
	
	
	public Boolean isShipmentTypeByIdAvailable(Integer id);
	
	
	
	

}
