package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

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
	
	private static Set<Bicycle> mockavailableBicyclesByColor;
	
	@BeforeAll
	public static void mockavailableBicyclesSetup() {
		mockavailableBicyclesByColor = new HashSet<>();
		
		for (int i = 1; i<=5; i++) {
			Bicycle bicycle = new Bicycle();
			bicycle.setId(i);
			if (i<3)
				bicycle.setColor("White");
			mockavailableBicyclesByColor.add(bicycle);
	}
		
	}
	
	@Test
	public void searchByColorExists() {
		String color = "White";
		
		when(bicycleDAO.getAll()).thenReturn(mockavailableBicyclesByColor);
		Set<Bicycle> actualColors = bicycleService.searchAvailableBicycleByColor(color);
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
		
		when(bicycleDAO.getAll()).thenReturn(mockavailableBicyclesByColor);
		Set<Bicycle> actualBikes = bicycleService.searchAvailableBicycleByColor(color);
		
		assertTrue(actualBikes.isEmpty()); 
	}
}	
