package com.capg.fms.bs.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.bs.dto.Booking;
@Repository
public interface BookingDAO extends JpaRepository<Booking,Long>{

}
