package srvrepo.touristInformationModel

import srvrepo.touristInformationModel.types.CultureType

class CulturePlace extends Place{
	
	def scaffold = true
	
	static hasMany = [events : Event]
	
	CultureType culturePlaceType

    static constraints = {
    }

}
