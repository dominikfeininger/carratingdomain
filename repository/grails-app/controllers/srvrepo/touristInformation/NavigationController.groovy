package srvrepo.touristInformation
		
import groovyx.net.http.*
import srvrepo.Service
import grails.converters.JSON

class NavigationController {

    def index = {
        render(text: "navigation")
    }
    
    def route = { 
		//parse url
		def serviceProvider = Service.findWhere(name:params.serviceName)
		
		def myLatitude = params.mylat
		def myLongitude = params.mylon
		def destLatitude = params.destlat
		def destLongitude = params.destlon
		//System.out.println(latitude)
		System.out.println("$serviceProvider.url?mylat=$myLatitude&mylon=$myLongitude&destlat=$destLatitude&destlon=$destLongitude" )
		//make google request
		def http = new HttpURLClient( )
		//request
		def resp = http.request(url: "$serviceProvider.url?mylat=$myLatitude&mylon=$myLongitude&destlat=$destLatitude&destlon=$destLongitude" )
		
		//adds server code
		def tmpServerCode = "{\"server_code\":\"100\","
		//handles the result
		def data = resp.getData().toString()
		//removes the first character from the result
		def madeData = data.substring(1)
		//combines everything
		def concat = tmpServerCode += madeData += "}"
		//make it JSON format
		def jsonRep = JSON.parse(concat)
		
		System.out.println(concat)
		render (contentType: "text/json", text: jsonRep as JSON )
	}
}
