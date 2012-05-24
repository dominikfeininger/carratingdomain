import api.Service
import api.Feature
import api.Car

class BootStrap {
    
    //default methods
    /*
    def init = { servletContext ->
    }
    def destroy = {
    }
    */
    
    def init = { servletContext ->
        // Check whether the test data already exists.
        if (!Service.count()) {
            new Service(provider: "Dominik Feininger", description: "This services does nothing").save(failOnError: true)
        }
        /*if (!Car.count()) {
            new Car(model: "A5", brand: "AUDI").save(failOnError: true)
            new Car(model: "A5").save(failOnError: true)
        }*/
        /*if (!Feature.count()) {
            new Feature(lacquer_color: "blue", seats: "4").save(failOnError: true)
        }*/
    }

    def destroy = {
    }
    
}
