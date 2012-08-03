package srvrepo.touristInformation

import groovyx.net.http.*
import grails.converters.JSON

class RestaurantController {

    def index() {
		render (text:"restaurant index")	
	}
	
	def findRestaurants(){
		//TODO: return restaurant
		render(text: "<?xml version=\"1.0\"?><rootnode><server_code>100</server_code><restaurant><r_name>El Diabolo</r_name><r_description>Hot Sauce</r_description></restaurant></rootnode>", contentType: "text/xml", encoding: "UTF-8")
	}
	
	def findRestaurantsAtGoogle(){
		
		//parse url
		def myLatitude = params.mylat
		def myLongitude = params.mylon
		def range = params.range
		def cuisine = params.cuisine
		//System.out.println(latitude)
		
		//make google request
		def http = new HttpURLClient( )
		//setup url, returns jason, makes request with google api places key:AIzaSyBr9DXHMIE0FENaFKFE7P_S7HSmXh9-9Io
		String staticUrl = "https://maps.googleapis.com/maps/api/place/search/json?location=$myLatitude,$myLongitude&radius=$range&types=food&keyword=$cuisine&sensor=false&key=AIzaSyBr9DXHMIE0FENaFKFE7P_S7HSmXh9-9Io"
		//request
		def resp = http.request(url: staticUrl )
		//adds server code
		def tmpServerCode = "{\"server_code\":\"100\","
		//handles the result
		def data = resp.getData().toString()
		//System.out.println(data)
		//removes the first character from the result
		def madeData = data.substring(1)
		//combines everything
		def concat = tmpServerCode += madeData += "}"
		//make it JSON format
		def jsonRep = JSON.parse(concat)
		//System.out.println(madeData)
		//System.out.println(concat)
		render (contentType: "text/json", text: jsonRep as JSON )
	}	
}
