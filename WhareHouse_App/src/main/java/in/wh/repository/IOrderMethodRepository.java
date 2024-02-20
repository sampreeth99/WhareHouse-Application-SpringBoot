package in.wh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.wh.model.OrderMethod;

public interface IOrderMethodRepository  extends JpaRepository<OrderMethod, Integer>{

}
