package srvrepo.mobileapp
//import lib.MapsDecoder

import org.apache.http.HttpClientConnection
import org.apache.http.client.ResponseHandler
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.DefaultHttpClient

import static groovyx.net.http.ContentType.JSON  
import static groovyx.net.http.Method.POST  
import groovyx.net.http.HTTPBuilder  

class NavigationController {

    def index = {
        render(text: "navigation index")
    }
    
    def test = {
        render(text: "{\"server_code\":\"100\"}", contentType: "text/json", encoding: "UTF-8")
    }
    
    def route = {   
        String url = "http://maps.google.com/maps?saddr=47.565726,-52.732058&daddr=47.573457,-52.732100&output=dragdir"
        def http = new HTTPBuilder(url)
        
        // response handler for a success response code:
        response.success = {  resp, json -> render(resp)}//render(text: "{\"server_code\":\"100\", \"route\":\"ceiaHhfz`II|I??}CG??GxBMbAWfAeAhC??}HyI??uKtP??g@y@oA?g@Sy@cA_MwR??xBcE\"}", contentType: "text/json", encoding: "UTF-8")}

        // handler for any failure status code:
        response.failure = { resp ->render(text: "{\"server_code\":\"151\"}", contentType: "text/json", encoding: "UTF-8")}
        
        //TODO: use google polyencoder to get the route
        //ceiaHhfz`II|I??}CG??GxBMbAWfAeAhC??}HyI??uKtP??g@y@oA?g@Sy@cA_MwR??xBcE
        //[{\"lat\":\"47.565945\",\"long\":\"-52.731953\"},{\"lat\":\"47.567948\",\"long\":\"-52.734804\"},{\"lat\":\"47.566566\",\"long\":\"-52.736607\"}]
    }
}



