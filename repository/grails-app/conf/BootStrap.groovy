import srvrepo.Configuration
import srvrepo.Attribute


import srvrepo.Basetype
import srvrepo.Configuration
import srvrepo.Keyword
import srvrepo.Predicate
import srvrepo.Quality
import srvrepo.Service
import srvrepo.Specification
import srvrepo.Vendor

import de.cocktail.srvrepo.types.Datatype

class BootStrap {

	def destroy = {
	}

	def init = { servletContext ->
		Vendor vendor1 = new Vendor(name:"exampleProviderONE").save(flush:true)
		Vendor vendor2 = new Vendor(name:"exampleProviderTWO").save(flush:true)
		
		Specification spec1 = new Specification("specForFindRestaurantInKmRange-Travel-Domain")
		Specification spec2 = new Specification("specForFindCulturePlaceInMinRange-Travel-Domain")
		
		Service service2 = new Service(activated: true, name: "findCinemaInKmRange-Travel-Domain", url: "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/cinema/findInKmRange")
		Service service3 = new Service("findCulturePlaceInKmRange-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/findInKmRange")
		Service service1 = new Service(name:"findRestaurantInKmRange-Travel-Domain", url: "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/restaurant/findInKmRange", specifications:spec1)
		
		Service service4 = new Service("routeWithGoogle-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/navigation/getRoute")

		Service service10 = new Service("findRestaurantInMinRange-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/restaurant/findInMinRange", vendor2)
		Service service11 = new Service("findCinemaInMinRange-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/cinema/findInMinRange", vendor2)
		Service service12 = new Service(name: "findCulturePlaceInMinRange-Travel-Domain", url:"http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/findInMinRange", specifications:spec2)
		
		Service service14 = new Service("findCinemaWithinDuration-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/cinema/findInDuration", vendor2)
		Service service13 = new Service("findCulturePlaceWithinDuration-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/findInDuration", vendor2)	
		
		Service service15 = new Service("getMoviesForCinema-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/cinema/getMoviesForCinema", vendor2)
		Service service16 = new Service("getEventsForMuseum-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/getEventsForMuseum", vendor2)
		
		Service service17 = new Service(name:"findRestaurantInKmRangeTWO-Travel-Domain", url:"http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/restaurant/findInKmRange", specifications:spec1)
		Service service18 = new Service(name:"findCulturePlaceInMinRangeTWO-Travel-Domain", url:"http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/findInMinRange", specifications:spec2)
	
		service18.setVendor(vendor1)
		service12.setVendor(vendor2)
		service17.setVendor(vendor2)
		service17.activated = true
		service10.save(flush:true)
		service11.save(flush:true)
		service12.save(flush:true)
		service13.save(flush:true)
		service14.save(flush:true)
		service15.save(flush:true)
		service16.save(flush:true)
		service1.activated = true
		service3.activated = true
		service4.activated = true
		service1.setVendor(vendor1)
		service2.setVendor(vendor1)
		service3.setVendor(vendor1)
		service4.setVendor(vendor1)
		service1.save(flush:true)
		service3.save(flush:true)
		service2.save(flush:true)
		service4.save(flush:true)
		service17.save(flush:true)
		service18.save(flush:true)
	}
}
