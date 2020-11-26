package com.capg.fms.as;

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

import com.capg.fms.as.dao.AirportDAO;
import com.capg.fms.as.dto.Airport;
import com.capg.fms.as.service.AirportService;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
public class AirportServiceApplicationTests {	
	@Mock
    private AirportDAO airportDao;
	@InjectMocks
	private AirportService airportService;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetAirportList(){
		List<Airport> airportList = new ArrayList<Airport>();
		airportList.add(new Airport("HYD","Rajiv","hyderabad"));
		airportList.add(new Airport("CHN","Maa","chennai"));
		when(airportDao.findAll()).thenReturn(airportList);
		assertEquals(2, airportList.size());
	}
	@Test
	public void testAddAirport() {
		Airport airport=new Airport("1", "Rajiv", "hyderabad");
		airport.setAirportId("1");
		airport.setAirportName("Rajiv");
		airport.setArea("hyderabad");
		airportDao.save(airport);
	}
	
	@Test
	public void testUpdateAirport() {
		Airport airport=new Airport("1", "Rajiv", "hyderabad");
		airportDao.findById("1");
		airportDao.save(airport);
	   verify(airportDao, Mockito.times(1)).save(airport);
	}
	
	@Test
	public void testDeleteAirport(){
	Airport airport=new Airport("1", "Rajiv", "hyderabad");
	airportDao.deleteById("1");
	verify(airportDao, times(1)).deleteById("HYD");
	}
	
	@Test
	public void testViewAirportById()
	{
		Airport airport=new Airport("HYD", "Rajiv", "hyderabad");
		airportDao.findById("HYD");
		verify(airportDao, times(1)).findById("HYD");
	}
	
}