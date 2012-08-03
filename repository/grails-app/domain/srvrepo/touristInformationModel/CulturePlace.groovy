package srvrepo.touristInformationModel

import java.io.File;

import srvrepo.touristInformationModel.types.CultureType

class CulturePlace{
	
	def scaffold = true
	
	GPSLocation location
	//static hasOne = [location : GPSLocation]
	
	def String name;
	def String description;
	def File picture
	
	static hasMany = [events : Event]
	
	CultureType culturePlaceType

    static constraints = {
    }

}
