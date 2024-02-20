package in.wh.service.impl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.wh.model.OrderMethod;
import in.wh.repository.IOrderMethodRepository;
import in.wh.service.IOrderMethodService;
import jakarta.persistence.criteria.Order;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService{
	
	@Autowired
	private IOrderMethodRepository orderMethodRepo;

	@Override
	public String saveOrderMethod(OrderMethod orderMethod) {
		OrderMethod o=orderMethodRepo.save(orderMethod);
		String msg;
		if(!(o==null)) {
			Integer orderId=o.getOrderMethodId();
			msg="Oder Registered SUccesfully by Id"+orderId;
			System.out.println("from service "+o);
		}else {
			msg="Order Registration failed";
		}
		return msg;
	}

	@Override
	public String updateOrderMethodById(Integer id,OrderMethod od) {
		
		Optional<OrderMethod> opt=orderMethodRepo.findById(id);
		OrderMethod o;
		String msg;
		if(opt.isPresent()) {
			o=orderMethodRepo.save(od);
			msg="Order is Updated succesfully by id"+" "+od.getOrderMethodId();
		}else {
			msg="Order not found for deletion";
		}
		
		return msg;
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		
		List<OrderMethod> liOrders=orderMethodRepo.findAll();
		
		return liOrders;
	}

	@Override
	public OrderMethod getOneOrderMethodById(Integer id) {
		 Optional<OrderMethod> opt=orderMethodRepo.findById(id);
		 
		 OrderMethod od=opt.get();
		return od;
	}

	@Override
	public String deleteOrderMethodById(Integer id) {
		String msg;
		if (id!=null) {
			orderMethodRepo.deleteById(id);
			msg="Order deleted by Id"+id;
			
		}else {
			msg="Order not found for deletion";
		}
		return msg;
	}
	

}
