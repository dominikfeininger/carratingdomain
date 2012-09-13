package srvrepo.touristInformation

import groovyx.net.http.*
import srvrepo.touristInformation.PlaceHelper
import grails.converters.JSON
import srvrepo.touristInformationModel.Restaurant
import srvrepo.Service

class RestaurantController {

	def index() {
		render (text:"restaurant index")
	}

	def findInKmRange(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylng
			def range = params.range
			def cuisine = params.cuisine
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLng=$myLongitude&radius=$range&cuisine=$cuisine"
			//System.out.println(uRL);
			//request
			def resp = PlaceHelper.makeHTTPRequestWithJson(uRL)
			//render result
			//System.out.println("resp: " + (resp as JSON))//.toString())
			render(text:resp.toString())//resp)
		}catch (Exception){
			System.out.println("exception" + Exception);
			render(text:PlaceHelper.getServerCode151JSON())
		}
	}

	def findInMinRange(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylon
			def range = params.range
			def cuisine = params.cuisine
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&cuisine=$cuisine"
			//System.out.println(uRL);
			//request
			def resp = PlaceHelper.makeHTTPRequestWithJson(uRL)
			//render result
			//System.out.println(resp.data.toString())
			render(text:resp.toString())
		}catch (Exception){
			render(text:PlaceHelper.getServerCode151JSON())
		}
	}

	def findInDuration(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylon
			def range = params.range
			def cuisine = params.cuisine
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&cuisine=$cuisine"
			//System.out.println(uRL);
			//request
			def resp = PlaceHelper.makeHTTPRequestWithXML(uRL)
			//render result
			//System.out.println(resp.data.toString())
			//TODO: change if neccessary
			render(text:resp.toString())
		}catch (Exception){
			render(text:PlaceHelper.getServerCode151XML())
		}
	}
}
