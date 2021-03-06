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
		Vendor vendor1 = new Vendor(name:"exampleProvider").save(flush:true)
		Vendor vendor2 = new Vendor(name:"exampleProviderTWO").save(flush:true)

		//Specification spec1 = new Specification(name:"specForFindRestaurantInKmRange-Travel-Domain")
		//Specification spec2 = new Specification(name:"specForFindCulturePlaceInMinRange-Travel-Domain")
		
		Service service2 = new Service("findCinemaInKmRange-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/cinema/findInKmRange", vendor1)
		Service service3 = new Service("findCulturePlaceInKmRange-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/findInKmRange", vendor1)
		Service service4 = new Service("routeWithGoogle-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/navigation/getRoute", vendor1)
		Service service10 = new Service("findRestaurantInMinRange-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/restaurant/findInMinRange", vendor1)
		Service service11 = new Service("findCinemaInMinRange-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/cinema/findInMinRange", vendor1)
		Service service14 = new Service("findCinemaWithinDuration-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/cinema/findInDuration", vendor1)
		Service service13 = new Service("findCulturePlaceWithinDuration-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/findInDuration", vendor1)
		Service service15 = new Service("getMoviesForCinema-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/cinema/getMoviesForCinema", vendor1)
		Service service16 = new Service("getEventsForMuseum-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/getEventsForMuseum", vendor1)

		Service service1 = new Service("findRestaurantInKmRange-Travel-Domain",  "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/restaurant/findInKmRange", vendor1)
		Service service17 = new Service("findRestaurantInKmRangeTWO-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/restaurant/findInKmRange", vendor2)
		Service service18 = new Service("findCulturePlaceInMinRangeTWO-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/findInMinRange", vendor2)
		Service service12 = new Service( "findCulturePlaceInMinRange-Travel-Domain", "http://feininger.dyndns.info:8090/ServiceProvider-Travel-Domain/culturePlace/findInMinRange", vendor1)
		/*
		spec1.service = service1
		spec1.service = service17
		spec2.service = service18
		spec2.service = service12
		
		spec1.save(flush:true)
		spec2.save(flush:true)
		*/
		service1.save(flush:true)
		service17.save(flush:true)
		service18.save(flush:true)
		service12.save(flush:true)
		
		service3.save(flush:true)
		service2.save(flush:true)
		service4.save(flush:true)
		service10.save(flush:true)
		service11.save(flush:true)
		service13.save(flush:true)
		service14.save(flush:true)
		service15.save(flush:true)
		service16.save(flush:true)
	}
}
