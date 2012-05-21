import api.Service

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
            //new Book(author: "James Patterson", title: "Along Came a Spider").save(failOnError: true)
        }
    }

    def destroy = {
    }
    
}
