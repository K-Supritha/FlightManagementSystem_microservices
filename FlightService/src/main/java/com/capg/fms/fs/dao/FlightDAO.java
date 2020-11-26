package com.capg.fms.fs.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.fms.fs.dto.Flight;
@Repository
public interface FlightDAO extends JpaRepository<Flight,String>
{

}
