package srvrepo.touristInformation

import groovyx.net.http.*

import groovyx.net.http.*

import grails.converters.JSON
import srvrepo.touristInformationModel.CulturePlace
import srvrepo.Service

class CulturePlaceController {

	def index() {
		render(text: "CulturePlace index")
	}

	def findInKmRangeJSON(){

		//def service = new Service()
		def service = Service.findByName(params.serviceName)
		if(service != null){
			//System.out.println("not null!! " + service.url);
			service.calls ++
			service.save(flush:true)

			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylon
			def range = params.range
			def kind = params.culturePlaceType
			//def rangeType

			def http = new HttpURLClient( )
			//setup url
			//TODO: change cusine to culture place
			String dynamicURL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&kind=$kind"
			System.out.println(dynamicURL);
			//request
			def resp = http.request(url:dynamicURL)

			//make it JSON format
			def jsonRep = JSON.parse(resp.getData().toString())
			//render result
			//render (contentType: "text/json", text: jsonRep as JSON )
			//System.out.println(resp.data.toString())
			render(text:resp.data.toString())
		}else{
			//System.out.println("NULL " + params.serviceName);
			render(text:"\"server_code\":\"151\", \"message\":\"service not available\"")
		}
	}
	//XML
	def findInKmRange(){

		//def service = new Service()
		def service = Service.findByName(params.serviceName)
		if(service != null){
			//System.out.println("not null!! " + service.url);
			service.calls ++
			service.save(flush:true)

			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylon
			def range = params.range
			def kind = params.culturePlaceType
			//def rangeType

			def http = new HttpURLClient( )
			//setup url
			String dynamicURL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&kind=$kind"
			System.out.println(dynamicURL);
			//request
			def resp = http.request(url:dynamicURL)

			render(text:resp.getData().toString())
		}else{
			//System.out.println("NULL " + params.serviceName);
			render(text:"<?xml version=\"1.0\"?><node><server_code>151</server_code><messgae>service not available</messgae></node>")
		}

	}

	def findInMinRange(){
		render (text:"findInMinRange")
	}

	def findInDuration(){
		render (text:"findInDuration")
	}

	def getEventsOfMuseum(){
		render (text:"getEventsOfMuseum")
	}
}

