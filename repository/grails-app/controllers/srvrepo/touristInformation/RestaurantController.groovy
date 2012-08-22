package srvrepo.touristInformation

import groovyx.net.http.*
import grails.converters.JSON
import srvrepo.touristInformationModel.Restaurant
import srvrepo.Service

class RestaurantController {

    def index() {
		render (text:"restaurant index")	
	}
	
	def findAtTripService(){
		//parse url
		def myLatitude = params.mylat
		def myLongitude = params.mylon
		def range = params.range
		def cuisine = params.cuisine
		//System.out.println(latitude)
		
		//make request to my parser Server
		def http = new HttpURLClient( )
		//setup url, returns jason, makes request with google api places key:AIzaSyBr9DXHMIE0FENaFKFE7P_S7HSmXh9-9Io
		String staticUrl = "http://feininger.dyndns.biz:8090/ServiceProviders/Restaurant/findAtGoogle?mylat=$myLatitude&mylon=$myLongitude&range=$range&cuisine=$cuisine"
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
	/*
	def find(){

		Restaurant wRestaurant = new Restaurant("El Diablolo 2","mexican restaurant")
		wRestaurant.save()
		System.out.println(wRestaurant.name);
		//def wRestaurant = Restaurant.get()
		//System.out.println(wRestaurant.name);

		render(text: "<?xml version=\"1.0\"?><rootnode><server_code>100</server_code><restaurant><r_name>$wRestaurant.name</r_name><r_description>$wRestaurant.description</r_description></restaurant></rootnode>", contentType: "text/xml", encoding: "UTF-8")
	}
	*/
	
	def findAtGoogle(){
		 
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

	def findInRange(){
		//def service = new Service()
		def service = Service.findByName(params.serviceName)
		if(service != null){
			//System.out.println("not null!! " + service.name);
			service.calls ++
			service.save(flush:true)
		}else{
			//System.out.println("NULL " + params.serviceName);
		}
		
		//parse url
		def myLatitude = params.mylat
		def myLongitude = params.mylon
		def range = params.range
		def cuisine = params.cuisine
		def rangeType
		
		def http = new HttpURLClient( )
		//setup url
		String dynamicURL = "$service.url&locLat=$myLatitude&locLong=$myLongitude&radius=$range&cuisine=$cuisine"
		System.out.println(dynamicURL);
		//request
		def resp = http.request(url:dynamicURL)
		//make it JSON format
		def jsonRep = JSON.parse(resp.getData().toString())
		//render result
		render (contentType: "text/json", text: jsonRep as JSON )
	}	
}
