package srvrepo.touristInformation

import srvrepo.touristInformation.PlaceHelper
import groovyx.net.http.*
import grails.converters.JSON
import srvrepo.touristInformationModel.CulturePlace
import srvrepo.Service

class CulturePlaceController {

	def index() {
		render(text: "CulturePlace index")
	}

	def findInKmRange(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylon
			def range = params.range
			def kind = params.culturePlaceType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&kind=$kind"
			//System.out.println(uRL);
			//request
			def resp = PlaceHelper.makeHTTPRequestWithXML(uRL)
			//render result
			//System.out.println(resp.data.toString())
			//TODO: change if neccessary
			render(text:resp.data.toString())
		}catch (Exception){
			render(text:PlaceHelper.getServerCode151XML())
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
			def kind = params.culturePlaceType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&kind=$kind"
			//System.out.println(uRL);
			//request
			def resp = PlaceHelper.makeHTTPRequestWithJson(uRL)
			//render result
			//System.out.println(resp.data.toString())
			render(text:resp.data.toString())
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
			def kind = params.culturePlaceType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&duration=$duration&kind=$kind"
			//System.out.println(uRL);
			//request
			def resp = PlaceHelper.makeHTTPRequestWithJson(uRL)
			//render result
			//System.out.println(resp.data.toString())
			render(text:resp.data.toString())
		}catch (Exception){
			render(text:PlaceHelper.getServerCode151JSON())
		}
	}

	def getEventsOfMuseum(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			//parse url
			def museumId = params.museumId
			//build new url
			String uRL = "$service.url?museumId=$museumId"
			//System.out.println(uRL);
			//request
			def resp = PlaceHelper.makeHTTPRequestWithXML(uRL)
			//render result
			//System.out.println(resp.data.toString())
			render(text:resp.data.toString())
		}catch (Exception){
			render(text:PlaceHelper.getServerCode151XML())
		}
	}
}

