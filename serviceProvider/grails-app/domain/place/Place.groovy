package place

import navigation.Location

class Place {

    static constraints = {
		
		def String name;
		def String description;
		def Location placeLocation;
		def File pic;
    }
}
