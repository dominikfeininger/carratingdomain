package place

class CinemaController {

    def index() { 
		render(text:"cinema index")	
	}
	
	def find(){
		Cinema empire12 = new Cinema()
		//empire12.setName("empire 12")
		//empire12.name = "empire 12"
		render(text:"{\"cinema\":\"empire_12\"}",contentType: "text/json",encoding: "UTF-8")
	}
}
