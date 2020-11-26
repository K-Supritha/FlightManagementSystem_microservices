package com.capg.fms.bs.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.bs.dto.Passengers;
@Repository
public interface PassengersDAO extends JpaRepository<Passengers,String>{

}
