// Shipment Type Entity class

package in.wh.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Shipment_Tab")
public class ShipmentType implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "shipment_id_col")
	private Integer shipmentId;
	

	@Column(name = "shipment_mode_col",length = 30)
	private String shipmentMode;
	

	@Column(name = "shipment_code_col",length = 30)
	private String shipmentCode;
	

	@Column(name = "shipment_enable_ship_col",length = 30)
	private Boolean enableShipment;
	

	@Column(name = "shipment_grade_col",length = 30)
	private String shipmentGrade;
	

	@Column(name = "shipment_grade_col",length = 50)
	private String description;
	
	
	
	

}
