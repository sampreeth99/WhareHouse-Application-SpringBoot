package in.wh.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "Uom_Table")
public class Uom implements Serializable{
	
	@Id
	@SequenceGenerator(name = "uom_Gen",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "uom_Gen")
	@Column(name = "uom_id_col")
	private Integer uomId;
	
	@Column(name = "uom_type_col",length = 30)	
	private String uomType;

	@Column(name = "uom_model_col",length = 30)	
	private String uomModel;

	
	@Column(name = "uom_desc_col",length = 50)	
	private String description;

}
