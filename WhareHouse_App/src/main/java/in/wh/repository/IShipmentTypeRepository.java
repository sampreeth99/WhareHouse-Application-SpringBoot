package in.wh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.wh.model.ShipmentType;

public interface IShipmentTypeRepository extends JpaRepository<ShipmentType, Integer> {

}
