package com.revature.services;

import java.util.Set;
import java.util.stream.Collectors;

import com.revature.beans.Bicycle;
import com.revature.data.BicycleDAO;
import com.revature.data.BicyclePostgres;

public class UserServicesImplm implements UserServices {
	
	private BicycleDAO bicycleDao = new BicyclePostgres();

	@Override
	public Bicycle updateBicycle(Bicycle bicycleToUpdate) {
		if (bicycleDao.getById(bicycleToUpdate.getId()) != null) {
			bicycleDao.update(bicycleToUpdate);
			bicycleToUpdate = bicycleDao.getById(bicycleToUpdate.getId());
			return bicycleToUpdate;
		}
		return null;
	}

	@Override
	public int addNewBicycle(Bicycle newBicycle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bicycle editBicycle(Bicycle bicycleToEdit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bicycle getBicycleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bicycle> searchAvailableBicycles(String color) {
		return bicycleDao.getAll();
	}

	@Override
	public Set<Bicycle> searchAvailableBicyclesByColor(String color) {
		Set<Bicycle> availableBicycleColors = bicycleDao.getByColor("Available");
		availableBicycleColors = availableBicycleColors.stream()
				.filter(bicycle -> bicycle.getColor().toLowerCase().contains(color.toLowerCase()))
				.collect(Collectors.toSet());	
		
		return availableBicycleColors;
	}

	@Override
	public Set<Bicycle> getByBrand(String brand) {
		Set<Bicycle> availableBicycleBrands = bicycleDao.getByBrand("Available");
		
		availableBicycleBrands = availableBicycleBrands.stream()
				.filter(bicycle -> bicycle.getBrand().toLowerCase().contains(brand.toLowerCase()))
				.collect(Collectors.toSet());
		return availableBicycleBrands;
	}

	@Override
	public Set<Bicycle> getByColor(String color) {
		Set<Bicycle> availableBicycleColors = bicycleDao.getByColor("Available");
		
		availableBicycleColors = availableBicycleColors.stream()
				.filter(bicycle -> bicycle.getColor().toLowerCase().contains(color.toLowerCase()))
				.collect(Collectors.toSet());
		return availableBicycleColors;
	}

	@Override
	public Set<Bicycle> getByTerrainType(String terrainType) {
		Set<Bicycle> availableBicycleTerrainTypes = bicycleDao.getByTerrainType("Available");
		
		availableBicycleTerrainTypes = availableBicycleTerrainTypes.stream()
				.filter(bicycle -> bicycle.getTerrainType().toLowerCase().contains(terrainType.toLowerCase()))
				.collect(Collectors.toSet());
		return availableBicycleTerrainTypes;
	}

	@Override
	public Set<Bicycle> searchAvailableBicyclesByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}


}
