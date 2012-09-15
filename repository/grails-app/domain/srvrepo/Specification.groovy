package srvrepo

import de.cocktail.srvrepo.types.Datatype
import de.cocktail.srvrepo.predicates.Formula

class Specification {
	
	def scaffold = true
	
	static belongsTo = [service : Service]
	
	String name
	//Datatype
	String input
	String output
	String precondition
	String postcondition
	//Formula precondition
	//Formula postcondition
	String description
	
	/*
	static mapping = {
		description(type: 'text')
	}
	*/
	
	Specification(String tmpName){
		this.name = tmpName
	}
	
	/*
    static constraints = {
		name(unique: true)
	}
	*/
	
	/*	precondition(nullable: true)
		postcondition(nullable: true)
		input(nullable: true)
		output(nullable: true)
    }
	*/
}
