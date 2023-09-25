package in.wh.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.wh.model.ShipmentType;
import in.wh.repository.IShipmentTypeRepository;
import in.wh.service.IShipmentTypeService;


@Service
public class ShipmentTypeServiceIMPL implements IShipmentTypeService {
	
	@Autowired
	private IShipmentTypeRepository shipRepo;
	
	

	@Override
	public String saveShipmentType(ShipmentType shipmentType) {
		Integer savedId=shipRepo.save(shipmentType).getShipmentId();
		return "shipment is saved By Id"+savedId;
	}

	@Override
	public String updateShipmentTypeById(Integer id) {
		ShipmentType s=null;
	    Optional<ShipmentType> opt=shipRepo.findById(id);
	    if (opt.isPresent()) {
			ShipmentType shipmentType=opt.get();
			s=shipRepo.save(shipmentType);
		}
		return "Shipment was updated Succesfully by id"+s.getShipmentId();
	}

	@Override
	public String deleteShipmentTypeById(Integer id) {
 
		Optional<ShipmentType> opt=shipRepo.findById(id);
		
		String outputMsg=null;
		if (opt.isPresent()) {
			shipRepo.deleteById(id);
			outputMsg="ShipmentType Deleted SUccesfully ";
		}
		else {
			outputMsg="ShipmentType not found for deletion";
		}
		
		return outputMsg;
	}

	@Override
	public ShipmentType retriveShipmentTypeById(Integer id) {
	
		Optional<ShipmentType> opt=shipRepo.findById(id);
		ShipmentType sh=null;
		if (opt.isPresent()) {
			sh=opt.get();
		}
		return sh;
	}

	@Override
	public Boolean isShipmentTypeByIdAvailable(Integer id) {
		return shipRepo.existsById(id);
	}

	
}
