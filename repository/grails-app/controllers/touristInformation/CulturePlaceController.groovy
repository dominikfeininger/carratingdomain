package touristInformation

class CulturePlaceController {

    def index() { 
		render(text: "CulturePlace index")	
	}
	
	def findCulturePlaces(){
		render(text: "<?xml version=\"1.0\"?><rootnode><server_code>100</server_code><cultureplace><cu_name>Signal Hill</cu_name><cu_description>Hill to climb on !</cu_description></cultureplace></rootnode>", contentType: "text/xml", encoding: "UTF-8")
	}
}
