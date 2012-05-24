package api

import api.Feature

class CarController {

    //def index() { }
    def scaffold = Car
    /*
    def searchCar(){
        def car = Car.get(params.id)
        car.feature = Feature.get(params["feature.id"])
        car.save()

        //redirect to a scaffolded action
        redirect(action:show)
    }
    
    def show() {
        def feature = Feature.get(params.id)
        log.error(feature)
        [featureInstance : feature]
    }
    
    def list(){}
    */
}
