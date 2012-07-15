package srvrepo.mobileApp

class NavigationController {

    def index = {
        render(text: "navigation")
    }
    
    def test = {
        render(text: "{\"server_code\":\"100\"}", contentType: "text/json", encoding: "UTF-8")
    }
    
    def route = {   
        //TODO: use google polyencoder to get the route
        render(text: "{\"server_code\":\"100\", \"route\":[{\"lat\":\"47.565945\",\"long\":\"-52.731953\"},{\"lat\":\"47.567948\",\"long\":\"-52.734804\"},{\"lat\":\"47.566566\",\"long\":\"-52.736607\"}]}", contentType: "text/json", encoding: "UTF-8")
    }
}

