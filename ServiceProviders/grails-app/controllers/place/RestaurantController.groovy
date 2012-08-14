package place
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.2' )

import groovy.json.*
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*
import place.GooglePlace

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.TEXT

import org.apache.http.client.methods.*

class RestaurantController {

	def index(){
		render(text:"restaurant index")
	}
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[placeInstanceList: GooglePlace.list(params), placeInstanceList: GooglePlace.count()]
	}    
	
	def findAtGoogle(){
		
		//parse url
		def myLatitude = params.mylat
		def myLongitude = params.mylon
		def range = params.range
		def cuisine = params.cuisine
		//System.out.println(latitude)
		
//setup url, returns jason, makes request with google api places key:AIzaSyBr9DXHMIE0FENaFKFE7P_S7HSmXh9-9Io
		String staticUrl = "https://maps.googleapis.com/maps/api/place/search/json?location=$myLatitude,$myLongitude&radius=$range&types=food&keyword=$cuisine&sensor=false&key=AIzaSyBr9DXHMIE0FENaFKFE7P_S7HSmXh9-9Io"
		def http = new HTTPBuilder( staticUrl )
		
		http.request(GET,TEXT) { req ->
		  
		  response.success = { resp, reader ->
			assert resp.status == 200
			println "My response handler got response: ${resp.statusLine}"
			println "Response length: ${resp.headers.'Content-Length'}"
			System.out << reader // print response reader
		  }
		  
		  // called only for a 404 (not found) status code:
		  response.'404' = { resp ->
			println 'Not found'
		  }
		}
		
		//make request
		//def http = new HttpURLClient()
		
		//request
		def result// = http.request(url: staticUrl)
		def data = result.getData().toString()
		def jsonObj = new JsonSlurper().parseText(data)

		GooglePlace place1 = new GooglePlace("googleplacename")
		place1.types = "googleplacetypes"
		place1.save()
		
		//System.out.println(GooglePlace.get() as JSON)
		
		GooglePlace place
		JSONArray inputArray = new JSONArray(jsonObj.results);
		inputArray.each {entry ->
			JSONObject jo = entry
			place = new GooglePlace(jo.name.toString(),jo.geometry.toString(),jo.types.toString(),jo.vicinity.toString())
			/*
			if (!place.save()) {
				place.errors.each {
					println it
				}
			}*/
		}
		render(text:place as JSON)//inputArray.length())
	}
}
