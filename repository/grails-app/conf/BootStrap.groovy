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

    def init = { servletContext ->
        /*
        // Check whether the test data already exists.
        if (!Attribute.count()) {
        Attribute att3 =  new Attribute(name: "Attr3").save(failOnError: true)
        att3.addToBasetype(new Basetype(name: "Base4"))
        }
        if (!Basetype.count()) {
        Basetype base3 = new Basetype(name: "Base3").save(failOnError: true)
        base3.addToAttributes(new Attribute(name: "Attr4"))
        bas3.addToSubtypes(new Basetype(name: "Base4"))
        base3.addToSupertype(new Basetype(name: "Base4"))
        }
        if (!Configuration.count()) {
        Configuration conf3 =  new Configuration(name: "Conf3", value: "Conf3").save(failOnError: true)
        }
        if (!Keyword.count()) {
        Keyword key3 = new Keyword(name: "Keyw3", comparator: "Keyw3").save(failOnError: true)
        }
        if (!Predicate.count()) {
        Predicate pred3 = new Predicate(name: "Pre3", input: "Pre3", description: "Pre3").save(failOnError: true)
        }
        if (!Quality.count()) {
        Quality qual3 = new Quality(value: "Qual3").save(failOnError: true)
        qual3.addToService(new Service(name: "Serv4"))
        }
        if (!Service.count()) {
        Service serv3 =  new Service(name: "Serv3", addToVendor(new Vendor(name: "Vend4"))).save(failOnError: true)
        serv3.addQualities(new Quality(value: "qual4"))
        serv3.addSpecifications(new Specification(name: "spec4"))
        }
         */
    }
    
    def destroy = {
        
    }
    

}
