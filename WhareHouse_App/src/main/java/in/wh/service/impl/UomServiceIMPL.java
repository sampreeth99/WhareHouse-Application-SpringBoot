package in.wh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	public String updateUomById(Uom uom) {
		Optional<Uom> opt=uomRepo.findById(uom.getUomId());

		Uom uom1=null;
		String updatedMsg=null;
		if (opt.isPresent()) {
			uom1=opt.get();
			BeanUtils.copyProperties(uom, uom1);
			uomRepo.save(uom1);
			updatedMsg="Uom updated succesfully by id"+uom.getUomId();
		}else {
			updatedMsg="Uom not found for updation by id"+uom.getUomId();
			
		}
		
		
		return updatedMsg;
	}

	@Override
	public String deleteUomById(Integer id) {
	
		String deleteOuptput=null;
		Optional<Uom> opt=uomRepo.findById(id);
		if (opt.isPresent()){
			uomRepo.deleteById(id);
			deleteOuptput="Uom is deleted by id"+id;
		}
		else {
			deleteOuptput="Uom is not found by id"+id+"for Deletion";
			
		}
		return deleteOuptput;
	}

	@Override
	public Uom retriveUomById(Integer id) {
		Optional<Uom> opt=uomRepo.findById(id);
		return opt.get();
	}
	
	@Override
	public List<Uom> retriveAllUom() {
	
		return 	uomRepo.findAll();
	}

	@Override
	public boolean isUomByIdAvailable(Integer id) {
		return uomRepo.existsById(id);
	}

	
	
}
