package fr.formation.formation_ib_jpa.service;

import org.springframework.stereotype.Component;

@Component
public class RestaurantService {

    public RestaurantService(){
        System.out.println("Je suis RestaurantService, et je viens d'être instancié !");
    }

    public void sayHello(){
        System.out.println("Salut du RestaurantService !!!");
    }

}
