 package srvrepo.mobileapp

import srvrepo.*

class RestaurantController {

    def index() { 
        render(text: "restaurant")
    }
    
    def getName = {
        render(text: "{\"server_code\":\"100\", \"name\":\"myFirstRestaurant\"}", contentType: "text/json", encoding: "UTF-8")
    }
}
