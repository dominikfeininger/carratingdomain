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

		//def service = new Service()
		def service = Service.findByName(params.serviceName)
		if(service != null){
			//System.out.println("not null!! " + service.url);
			service.calls ++
			service.save(flush:true)
		}else{
			//System.out.println("NULL " + params.serviceName);
		}

		//parse url
		def myLatitude = params.mylat
		def myLongitude = params.mylon
		def range = params.range
		def movieType = params.movieType
		//def rangeType

		def http = new HttpURLClient( )
		//setup url
		//TODO: change cusine to cinema
		String dynamicURL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&movieType=$movieType"
		System.out.println(dynamicURL);
		//request
		def resp = http.request(url:dynamicURL)
		//make it JSON format
		def jsonRep = JSON.parse(resp.getData().toString())
		//render result
		//render (contentType: "text/json", text: jsonRep as JSON )
		//System.out.println(resp.data.toString())
		render(text:resp.data.toString())
	}

	def findInMinRange(){
		render (text:"findInMinRange")
	}

	def findInDuration(){
		render (text:"findInDuration")
	}

	def getMoviessOfCinema(){
		render (text:"getMoviessOfCinema")
	}

}

