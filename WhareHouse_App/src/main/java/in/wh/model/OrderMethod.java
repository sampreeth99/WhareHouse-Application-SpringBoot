package in.wh.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "OrderMethod_Table")

public class OrderMethod implements Serializable {
	
	@Id
	@SequenceGenerator(name = "ordermethod_gen",initialValue = 3000,allocationSize = 1)
	@GeneratedValue(generator ="ordermethod_gen" )
	@Column(name = "oder_method_id_col")
	private Integer orderMethodId;

	@Column(name = "Order_mode_col",length = 50)
	private String orderMode;
	
	@Column(name = "order_code_col",length = 50)
	private String orderCode;

	@Column(name = "order_type_col",length = 50)
	private String orderType;

	@Column(name = "order_Accept_col",length = 50)
	private String orderAccept;

	@Column(name = "order_description_col",length = 100)
	private String description;
	
	
	

}
