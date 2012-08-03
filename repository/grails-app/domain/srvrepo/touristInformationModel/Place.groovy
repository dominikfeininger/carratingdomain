package srvrepo.touristInformationModel

class Place {
	
	def scaffold = true
	
	//static hasOne = [location : GPSLocation]
	
	def String name;
	def String description;
	def File picture

    static constraints = {

    }
}
