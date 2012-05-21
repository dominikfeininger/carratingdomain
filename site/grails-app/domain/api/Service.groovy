package api

class Service {
    
    
    String provider
    String description

    static constraints = {
        provider(blank: false)
        description(blank: false)
    }
    
}
