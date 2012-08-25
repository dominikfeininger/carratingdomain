package srvrepo

import org.codehaus.groovy.grails.web.json.*

class Service {
	
	def scaffold = true 
	
	static belongsTo = [vendor: Vendor]
	//static hasMany = [qualities: Quality, specifications: Specification]
	static hasMany = [ specifications: Specification]
	
	String name
	URL url
	Boolean activated
	int calls

    static constraints = {
		name(unique: true)
    }
	
	Service(){
		
	}
	
	Service(String tmpName, String tmpUrl){		
		this.name = tmpName
		this.url = new URL(tmpUrl)
		this.calls = 0
	}
}
