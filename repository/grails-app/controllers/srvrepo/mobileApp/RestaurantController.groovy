package srvrepo.mobileApp

class RestaurantController {

    def index() {
		render (text:"restaurant index")	
	}
	
	def find(){
		//TODO: return restaurant
		render(text: "<?xml version=\"1.0\"?><rootnode><server_code>100</server_code><restaurant><name>El Diabolo</name><description>Hot Sauce</description></restaurant></rootnode>", contentType: "text/xml", encoding: "UTF-8")
	}
}
