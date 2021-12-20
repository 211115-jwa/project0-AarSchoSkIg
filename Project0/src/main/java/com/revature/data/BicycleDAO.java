package com.revature.data;

import java.util.Set;
import com.revature.beans.Bicycle;

public interface BicycleDAO {
	
	public int create(Bicycle dataToAdd);
	public Bicycle getById(int id);
	public Set<Bicycle> getAll();
	public void update(Bicycle dataToUpdate);
	public void delete(Bicycle dataToDelete);
	

}
