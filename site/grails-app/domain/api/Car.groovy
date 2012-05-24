package api

import api.Feature

class Car {

    //static constraints = { }
    
    String model
    String brand
    
    Feature feature
    
    
    //not to specify in one to one relations, just spec the belongsTo side
    //static hasOne = [feature: Feature]
    

    static constraints = {
        model(blank: true)
        brand(blank: true)
        //feature(blank: false)
    }
}
