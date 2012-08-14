package srvrepo.touristInformationModel

import java.io.File;
import srvrepo.touristInformationModel.types.RestaurantType;

class Restaurant{
	
	def scaffold = true
	
	GPSLocation location
	//static hasOne = [location : GPSLocation]
	
	def String name;
	def String description;
	def File picture
	
	RestaurantType restaurantType 

    static constraints = {
		
    }
	
	Restaurant(){
		
	}
	
	Restaurant(String tmpNme, String tmpDescription){
		this.name = tmpNme
		this.description = tmpDescription
	}
	
}



