package in.wh.service;

import java.util.List;

import in.wh.model.OrderMethod;
import jakarta.persistence.criteria.Order;

public interface IOrderMethodService {
	
	public String saveOrderMethod(OrderMethod orderMethod);

	public String updateOrderMethodById(Integer id,OrderMethod od);
	
	public List<OrderMethod> getAllOrderMethod();
	
	public OrderMethod getOneOrderMethodById(Integer id);

	public String deleteOrderMethodById(Integer id);
	



}
