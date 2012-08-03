package srvrepo.touristInformation
		
import groovyx.net.http.*

import grails.converters.JSON

class NavigationController {

    def index = {
        render(text: "navigation")
    }
    
    def route = { 
		//parse url
		def myLatitude = params.mylat
		def myLongitude = params.mylon
		def destLatitude = params.destlat
		def destLongitude = params.destlon
		//System.out.println(latitude)
		
		//make google request
		def http = new HttpURLClient( )
		//request
		def resp = http.request(url: "http://maps.google.com/maps?saddr=$myLatitude,$myLongitude&daddr=$destLatitude,$destLongitude&output=dragdir" )
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
		//System.out.println(madeData)
		System.out.println(concat)
		render (contentType: "text/json", text: jsonRep as JSON )
	}
}
