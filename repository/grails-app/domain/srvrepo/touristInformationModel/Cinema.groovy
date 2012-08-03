package srvrepo.touristInformationModel

class Cinema {//extends Place{
	
	def scaffold = true
	
	static hasmany = [movies : Movie]

    static constraints = {
		
    }
}
