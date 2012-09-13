package srvrepo.touristInformation;

import groovyx.net.http.*
import srvrepo.touristInformation.PlaceHelper
import grails.converters.JSON
import srvrepo.touristInformationModel.Restaurant
import srvrepo.Service

public class PlaceHelper {

	public static String serverCode151JSON = "{\"server_code\":\"151\", \"message\":\"Failed, Service Unavailable !\"}"
	public static String serverCode100JSON = "{\"server_code\":\"100\", \"message\":\"Success\"}"
	public static String serverCode161JSON = "{\"server_code\":\"161\", \"message\":\"Parameter Error !\"}"
	public static String serverCode171JSON = "{\"server_code\":\"171\", \"message\":\"Connection Error !\"}"

	public static String serverCode161XML = "<?xml version=\"1.0\"?><node><server_code>161</server_code><messgae>Parameter Error !</messgae></node>"
	public static String serverCode151XML = "<?xml version=\"1.0\"?><node><server_code>151</server_code><messgae>Failed, Service Unavailable !</messgae></node>"
	public static String serverCode100XML = "<?xml version=\"1.0\"?><node><server_code>100</server_code><messgae>Success</messgae></node>"
	public static String serverCode171XML = "<?xml version=\"1.0\"?><node><server_code>171</server_code><messgae>Connection Error !</messgae></node>"

	static String getServerCode151XML(){
		return serverCode151XML
	}
	
	static String getServerCode161XML(){
		return serverCode161XML
	}

	static String getServerCode100XML(){
		return serverCode100XML
	}

	static String getServerCode171XML(){
		return serverCode171XML
	}

	static String getServerCode171JSON(){
		return serverCode171JSON
	}

	static String getServerCode151JSON(){
		return serverCode151JSON
	}

	static String getServerCode100JSON(){
		return serverCode100JSON
	}

	static String getServerCode161JSON(){
		return serverCode161JSON
	}

	static Service findService(String serviceName){

		def tmpService = Service.findByName(serviceName)
		if(tmpService != null){
			//System.out.println("not null!! " + tmpService.url);
			tmpService.calls ++
			tmpService.save(flush:true)
		}else{
			//System.out.println("NULL " + serviceName);
			tmpService.name = null
		}
		return tmpService
	}

	static String makeHTTPRequestWithJson(String uRL){
		//build HttpURLClient object
		def http = new HttpURLClient( )
		//request
		def resp = http.request(url: uRL)
		return resp.getData()//.toString()
	}

	static String makeHTTPRequestWithXML(String uRL){
		//build HttpURLClient object
		def http = new HttpURLClient( )
		//request
		def resp = http.request(url: uRL)
		//return it
		//TODO: impl right way
		return resp.getData().toString()
	}
}
