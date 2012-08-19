package srvrepo.touristInformation

import groovyx.net.http.*
import org.apache.commons.io.IOUtils
import grails.converters.JSON

class CinemaController {

    def index() { 
		render(text:"cinema index", encoding: "UTF-8")
	}
	
	def findAtGoogle(){
		//make google request
		def http = new HttpURLClient( )
		//request
		def resp = http.request(url: "http://www.google.de" )
		//adds server code
		def tmpServerCode = "{\"server_code\":\"100\","
		//handles the result
		def data = IOUtils.toString(resp.getData(), "UTF-8");
		//def data = resp.getData().toString()
		//(String[])data.toArray(new String[data.size])
		//System.out.println(data)
		//removes the first character from the result
		def madeData = data.substring(1)
		//combines everything
		def concat = tmpServerCode += madeData
		System.out.println(concat)
		//make it JSON format
		def jsonRep = JSON.parse(concat)
		//System.out.println(data)
		//System.out.println(jsonRep)
		render (contentType: "text/json", text: jsonRep as JSON )
	}

	def find(){
		render (contentType: "text/json", text: "{\"server_code\":\"100\"}")
	}
	
	def findAtTripService(){
		
	}
	
}

