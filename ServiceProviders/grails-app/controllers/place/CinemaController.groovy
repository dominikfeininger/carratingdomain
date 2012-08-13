package place

class CinemaController {

    def index() { 
		render(text:"cinema index")	
	}
	
	def find(){
		//Cinema empire12 = new Cinema()
		//empire12.setName("empire 12")
		//empire12.name = "empire 12"
		//render(text:"{\"cinemas\":[{\"c_name\":\"empire_12\", \"m_name\":\"Batman\"}]}}",contentType: "text/json",encoding: "UTF-8")
		render(text:"find controller Cinema")//"{\"cinemas\":[{\"c_name\":\"empire_12\",\"lat\":\"47.561295\",\"long\":\"-52.748795\", \"movies\":[{\"m_name\":\"Batman\"},{\"m_name\":\"Spider Man\"}]},{\"c_name\":\"empire_13\",\"lat\":\"47.560977\",\"long\":\"-52.738431\", \"movies\":[{\"m_name\":\"Iron Man\"}]}]}",contentType: "text/json",encoding: "UTF-8")
	}
}
