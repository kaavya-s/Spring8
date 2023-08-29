package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Bike;

public interface BikeRepo extends JpaRepository<Bike, Integer>{
	@Query(value="select * from Bike where year = :y",nativeQuery=true)
	public List<Bike> getBike(@Param("y") int years);
	

	@Query(value="select * from Bike where year=:y and bike_name=:bk",nativeQuery=true)
	public List<Bike> getFromyearname(@Param("y") int year,@Param("bk") String bikeName);
	
	@Query(value="select * from Bike where bike_name like :bk%",nativeQuery=true)
	public List<Bike> getBikeName(@Param("bk") String bikeName);

}
