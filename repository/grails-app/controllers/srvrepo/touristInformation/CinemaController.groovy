package srvrepo.touristInformation

import groovyx.net.http.*

import grails.converters.JSON
import srvrepo.touristInformationModel.Cinema
import srvrepo.Service

class CinemaController {

	def index() {
		render(text:"cinema index")
	}

	def findInKmRange(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylng
			def range = params.range
			def movieType = params.movieType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLng=$myLongitude&radius=$range&movieType=$movieType"
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

	def findInMinRange(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylon
			def range = params.range
			def movieType = params.movieType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&movieType=$movieType"
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
			def duration = params.duration
			def movieType = params.movieType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&duration=$duration&movieType=$movieType"
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

	def getMoviesForCinema(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			//parse url
			def myLatitude = params.cinemaId
			//build new url
			String uRL = "$service.url?cinemaId=$cinemaId"
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

