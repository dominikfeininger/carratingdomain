package srvrepo.mobileapp

class LocationController {

    def index() { 
        render(text: "location")
    }
    
    def location = {
        render(text: "{\"server_code\":\"100\", \"location\":{\"lat\":\"47,565945\",\"long\":\"-50,731953\"}}", contentType: "text/json", encoding: "UTF-8")
    }
}
