package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.beans.Bicycle;

public class BicycleDAOTest {
	
	private BicycleDAO bicycleDAO = new BicyclePostgres();
	
	@Test // Test 
	public void getByIdWhenIdExists() {
		// setup
		int idInput = 1;
		// call idOutput method for testing
		Bicycle idOutput = bicycleDAO.getById(idInput);
		// assert that it did what it is expected to do
		assertEquals(1, idOutput.getId());
	}
}
