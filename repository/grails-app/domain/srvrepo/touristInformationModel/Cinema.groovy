package srvrepo.touristInformationModel

import java.io.File;

class Cinema{
	
	def scaffold = true
	
	GPSLocation location
	//static hasOne = [location : GPSLocation]
	
	def String name;
	def String description;
	def File picture
	
	static hasMany = [movies : Movie]

    static constraints = {
		
    }
}
