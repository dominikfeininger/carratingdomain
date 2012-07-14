package srvrepo.mobileApp

class NavigationController {
    
static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        render(text: "navigation")
    }
    
    def test = {
        render(text: "{\"server_code\":\"100\"}", contentType: "text/json", encoding: "UTF-8")
    }
    
    def route = {
        render(text: "{\"server_code\":\"100\", \"route\":{\"lat\":\"47,565945\",\"long\":\"-50,731953\"}}", contentType: "text/json", encoding: "UTF-8")
    }
}
