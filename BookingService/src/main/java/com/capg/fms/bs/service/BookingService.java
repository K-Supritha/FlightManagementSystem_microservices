package com.capg.fms.bs.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bs.dao.BookingDAO;
import com.capg.fms.bs.dto.Booking;
import com.capg.fms.bs.exceptions.BookingNotFoundException;
@Service
public class BookingService implements IBookingService{
	@Autowired
	private BookingDAO bookingDao;
	
	
	
	public void setBookingDao(BookingDAO bookingDao) 
	{
		this.bookingDao = bookingDao;
	}
	
	@Transactional(readOnly=true)
	public Optional<Booking> getBookingDetails(long bookingId) throws BookingNotFoundException
	{
		Optional<Booking> opt=bookingDao.findById(bookingId);
		if (!opt.isPresent())
			throw new BookingNotFoundException();
		return bookingDao.findById(bookingId);
	}
	
	@Transactional(readOnly=true)
	public List<Booking> getAllBookingDetails()
	{
		return bookingDao.findAll(Sort.by(Sort.Direction.DESC, "bookingId"));
	}
	
	@Transactional
	public Booking addBookingDetails(Booking booking)
	{
		
			return bookingDao.save(booking);
	}
	
	
	@Transactional
	public void updateBookingDetails(Booking booking)
	{
		bookingDao.save(booking);
	}
	
	@Transactional
	public void deleteBookingDetails(long bookingId, Booking booking) throws BookingNotFoundException
	{
		Optional<Booking> opt=bookingDao.findById(bookingId);
		if (!opt.isPresent())
		throw new BookingNotFoundException();
		bookingDao.deleteById(bookingId);
	}

}
