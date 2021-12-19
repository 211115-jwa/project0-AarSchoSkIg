package com.revature.services;

import java.util.Set;

import com.revature.beans.Bicycle;

public interface ServicesForUsers {
	/*Users are able to search for Bikes by model, color, Id number, Terrain Type, login, 
	 * update User information, and add new bikes.
	 */
	public Person register(Person newUser);
	public Person logIn(String username, String password);
	public Bicycle updateBicycle(Bicycle bicycleToUpdate);
	public Bicycle addNewBicycle(int bicycleId, Bicycle newBicycle);
	public Set<Bicycle> viewAvailableBicycles();
	public Set<Bicycle> searchAvailableBicyclesByBrand(String brand);
	public Set<Bicycle> searchAvailableBicyclesByColor(String color);
	public Set<Bicycle> searchAvailableBicyclesByTerrainType(String terrainType);
}
