package com.revature.services;

import java.util.Set;

import com.revature.beans.Bicycle;

public interface UserServices {
	public int addNewBicycle(Bicycle newBicycle);
	public Bicycle editBicycle(Bicycle bicycleToEdit);
	public Bicycle getBicycleById(int id);
	public Set<Bicycle> searchAvailableBicycles(String color);
	public Set<Bicycle> searchAvailableBicyclesByColor(String color);
	public Set<Bicycle> searchAvailableBicycleByBrand(String brand);
}

