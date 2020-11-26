package com.capg.fms.bs.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bs.dao.PassengersDAO;
import com.capg.fms.bs.dto.Passengers;
import com.capg.fms.bs.exceptions.BookingNotFoundException;
import com.capg.fms.bs.exceptions.PassengerNotFoundException;
@Service
public class PassengersService implements IPassengersService {
	@Autowired
	private PassengersDAO pdao;
	public void setPdao(PassengersDAO pdao) { this.pdao=pdao;}

	@Transactional(readOnly=true)
	public Optional<Passengers> getPassenger(String uid) throws PassengerNotFoundException
	{
		Optional<Passengers> opt=pdao.findById(uid);
		if (!opt.isPresent())
			throw new BookingNotFoundException();
		return pdao.findById(uid);
	}

	@Transactional(readOnly=true)
	public List<Passengers> getAllPassengers()
	{
		return pdao.findAll();
	}

	@Transactional
	public Passengers addPassenger(Passengers passenger)
	{
		return pdao.save(passenger);
	}

	@Transactional
	public void updatePassenger(Passengers passenger) 
	{
		pdao.save(passenger);
	}

	@Transactional
	public void deletePassenger(String uid) throws PassengerNotFoundException
	{
		Optional<Passengers> opt=pdao.findById(uid);
		if (!opt.isPresent())
			throw new BookingNotFoundException();
		pdao.deleteById(uid);
	}

}
