package srvrepo

import java.util.Collections.SelfComparable;

import org.springframework.aop.aspectj.RuntimeTestWalker.ThisInstanceOfResidueTestVisitor;

import srvrepo.Vendor

class Service {
	
	def scaffold = true 
	
	static belongsTo = [vendor: Vendor]
	//static hasMany = [qualities: Quality, specifications: Specification]
	static hasMnay = [specifications: Specification]
	
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
	
	Service(String tmpName, String tmpUrl, Vendor tmpVendor){
		this.activated = true
		this.vendor = tmpVendor
		this.name = tmpName
		this.url = new URL(tmpUrl)
		this.calls = 0
	}
}
