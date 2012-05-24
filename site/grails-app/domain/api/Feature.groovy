package api

import api.Car

class Feature {

    String lacquer_color
    String interior_color
    Integer horsepower
    Double acceleration
    Integer seats
    Integer doors
    Double  cubic_capacity
    Integer trunk_volume
    
    static belongsTo = [car: Car]
    

    static constraints = {
        lacquer_color(blank: true)
        seats(blank: true)
        //car(blank: false)
    }
}
