package com.revature.data;

import java.util.Set;

public interface BicycleDAO<Bicycle> {
	
	public int create(Bicycle dataToAdd);
	public Bicycle getById(int id);
	public Set<Bicycle> getAll();
	public void update(Bicycle dataToUpdate);
	public void delete(Bicycle dataToDelete);

}
