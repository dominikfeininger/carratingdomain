package srvrepo.mobileApp

import groovyx.net.http.*

import grails.converters.JSON

class CinemaController {

    def index() { 
		render(text:"cinema index", encoding: "UTF-8")
	}
	
	def findCinema(){
		//make google request
		def http = new HttpURLClient( )
		//request
		def resp = http.request(url: "http://feininger.dyndns.biz:8090/ServiceProviders/Cinema/find" )
		//adds server code
		def tmpServerCode = "{\"server_code\":\"100\","
		//handles the result
		def data = resp.getData()//.toString()
		//removes the first character from the result
			//def madeData = data.substring(1)
		//combines everything
			//def concat = tmpServerCode += madeData += "}"
		//make it JSON format
		//def jsonRep = JSON.parse(data)//concat)
		//System.out.println(data)
		//System.out.println(jsonRep)
		render (contentType: "text/json", text: "$data")// as JSON )
	}
	
}
