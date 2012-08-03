package srvrepo.touristInformationModel.types

public enum RestaurantType {
	MEXICAN('Mexican'),INDIAN('Indian'),CANADIAN('Canadian'), CHINESE('Chinese')
	
	String name

	def getRestaurantType(String name) {
	  this.name = name
	}
}