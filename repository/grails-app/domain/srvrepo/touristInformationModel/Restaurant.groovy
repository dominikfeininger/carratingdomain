package srvrepo.touristInformationModel

import srvrepo.touristInformationModel.types.RestaurantType;

class Restaurant extends Place{
	
	def scaffold = true
	
	RestaurantType restaurantType 

    static constraints = {
		
    }
	
	/*
	Restaurant(String tmpNme, String tmpDescription){
		this.name = tmpNme
		this.description = tmpDescription
	}
	*/
}



