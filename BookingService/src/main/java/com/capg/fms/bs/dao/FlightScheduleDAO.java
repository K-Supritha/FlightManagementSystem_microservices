package com.capg.fms.bs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.bs.dto.FlightSchedule;
@Repository
public interface FlightScheduleDAO extends JpaRepository<FlightSchedule,String>{

}
