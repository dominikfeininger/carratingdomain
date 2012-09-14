package srvrepo.touristInformationModel.types

	
	public enum CultureType {

		MUSEUM('Museum'),CHURCH('Church'),NATURE('Nature'),MONUMENT('Monument'),LANDMARK('Landmark')
		
		String name
	
		def getCultureType(String name) {
		  this.name = name
		}
	}