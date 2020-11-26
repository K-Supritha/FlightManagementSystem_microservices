package com.capg.fms.fs;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.capg.fms.fs.dao.FlightDAO;
import com.capg.fms.fs.dto.Flight;
import com.capg.fms.fs.service.FlightService;



@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightServiceApplicationTests {	
	@Mock
    private FlightDAO flightDao;
	@InjectMocks
	private FlightService flightService;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetFlightList(){
		List<Flight> flightList = new ArrayList<Flight>();
		flightList.add(new Flight("101","Indigo","domestic",70));
		flightList.add(new Flight("102","kingfisher","domestic",90));
		when(flightDao.findAll()).thenReturn(flightList);
		assertEquals(2, flightList.size());
	}
	@Test
	public void testAddFlight() {
		Flight flight=new Flight("201","Indigo","domestic",70);
		flight.setFlightNo("201");
		flight.setCarrierName("Indigo");
		flight.setFlightModel("domestic");
		flight.setSeatCapacity(70);
		flightDao.save(flight);
	}
	
	@Test
	public void testUpdateFlight() {
		Flight flight=new Flight("201","Indigo","domestic",70);
		flightDao.findById("201");
		flightDao.save(flight);
	   verify(flightDao, Mockito.times(1)).save(flight);
	}
	
	@Test
	public void testDeleteFlight(){
		Flight flight=new Flight("201","Indigo","domestic",70);
		flightDao.deleteById("201");
	verify(flightDao, times(1)).deleteById("201");
	}
	
	@Test
	public void testViewFlightById()
	{
		Flight flight=new Flight("201","Indigo","domestic",70);
		flightDao.findById("201");
		verify(flightDao, times(1)).findById("201");
	}
	
}
