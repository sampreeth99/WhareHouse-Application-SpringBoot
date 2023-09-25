package in.wh.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.wh.model.Uom;
import in.wh.repository.IUomRepository;
import in.wh.service.IUomService;

@Service
public class UomServiceIMPL implements IUomService{
	
	@Autowired
	private IUomRepository uomRepo;

	@Override
	public String saveUom(Uom uom) {
		return uomRepo.save(uom).getUomId()+"based Uom is Saved Succesfully";
	}

	@Override
	public String updateUomById(Integer id) {

		
		
		return null;
	}

	@Override
	public String deleteUomById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uom retriveUomById(Integer id) {
		Optional<Uom> opt=uomRepo.findById(id);
		return opt.get();
	}

	@Override
	public boolean isUomByIdAvailable(Integer id) {
		return uomRepo.existsById(id);
	}

	
	
}
