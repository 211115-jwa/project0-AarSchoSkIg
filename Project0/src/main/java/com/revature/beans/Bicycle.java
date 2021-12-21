package com.revature.beans;

public class Bicycle {
	private int id;
	private String brand;
	private String color;
	private String terrainType;
	
	public Bicycle () {
		id = 0;
		brand = "Brand";
		color = "Color";
		terrainType = "Type";
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	
	}

	public String getTerrainType() {
		return terrainType;
	}

	public void setTerrainType(String terrainType) {
		this.terrainType = terrainType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + id;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((terrainType == null) ? 0 : terrainType.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicycle other = (Bicycle) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (id != other.id)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (terrainType == null) {
			if (other.terrainType != null)
				return false;
		} else if (!terrainType.equals(other.terrainType))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", brand=" + brand + ",color=" + color + ", terrainType=" + terrainType
				+"]";
	}


}
