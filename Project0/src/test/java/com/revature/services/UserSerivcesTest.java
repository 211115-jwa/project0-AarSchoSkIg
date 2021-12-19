package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.beans.Bicycle;
import com.revature.data.BicycleCustomerServices;
import com.revature.data.BicycleDAO;

@ExtendWith(MockitoExtension.class)
public class UserSerivcesTest {
	
	@Mock
	private BicycleDAO bicycleDAO;
	
	@InjectMocks
	private BicycleCustomerServices bicycleService = new BicycleCustomerServicesImpl();
	
	private static Set<Bicycle> mockavailableBicycles;
	
	@BeforeAll
	public static void mockavailableBicyclesSetup() {
		mockavailableBicycles = new HashSet<>();
		
		for (int i = 1; i<=5; i++) {
			Bicycle bicycle = new Bicycle();
			bicycle.setId(i);
			if (i<3)
				bicycle.setColor("White");
				bicycle.setBrand("Mongoose");
			mockavailableBicycles.add(bicycle);
	}
		
	}
	
	@Test
	public void searchByColorExists() {
		String color = "White";
		
		when(bicycleDAO.getAll()).thenReturn(mockavailableBicycles);
		Set<Bicycle> actualColors = bicycleService.searchAvailableBicycles(color);
		boolean onlyWhite = true; 
		for (Bicycle bicycle : actualColors) {
			if(!bicycle.getColor().equals(color))
				onlyWhite = false;
		}
		
		assertTrue(onlyWhite);
		
	}
	
	@Test
	public void searchByColorDoesntExist() {
		String color = "kdsj;fklaghjkghfkjd";
		
		when(bicycleDAO.getAll()).thenReturn(mockavailableBicycles);
		Set<Bicycle> actualBikes = bicycleService.searchAvailableBicyclesByColor(color);
		
		assertTrue(actualBikes.isEmpty()); 
	}
	
	@Test
	public void searchByBrandExists() {
		String brand = "Mongoose";
		
		when(bicycleDAO.getAll()).thenReturn(mockavailableBicycles);
		Set<Bicycle> actualBrands = bicycleService.searchAvailableBicycleByBrand(brand);
		boolean onlyMongoose = true; 
		for (Bicycle bicycle : actualBrands) {
			if(!bicycle.getColor().equals(brand))
				onlyMongoose = false;
		}
		
		assertTrue(onlyMongoose);
	}
	
	@Test
	public void searchByBrandDoesntExist() {
		String brand = "Puffy";
		
		when(bicycleDAO.getAll()).thenReturn(mockavailableBicycles);
		Set<Bicycle> actualBrands = bicycleService.searchAvailableBicycleByBrand(brand);
		
		assertTrue(actualBrands.isEmpty()); 
	}

}
