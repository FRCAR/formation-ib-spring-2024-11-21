package fr.formation.formation_ib_jpa;

import fr.formation.formation_ib_jpa.dao.ExampleDao;
import fr.formation.formation_ib_jpa.dao.ExamplePurJPADao;
import fr.formation.formation_ib_jpa.model.Example;
import fr.formation.formation_ib_jpa.service.RestaurantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class FormationIbJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(FormationIbJpaApplication.class, args);
		RestaurantService restaurantService = applicationContext.getBean(RestaurantService.class);
		restaurantService.sayHello();

		ExamplePurJPADao examplePurJPADao = applicationContext.getBean(ExamplePurJPADao.class);

		Example example = new Example();
		example.setName("Mon autre exemple");
		example.setValid(Boolean.FALSE);

		//Example savedExample = exampleDao.save(example);
		//System.out.println("J'ai sauvegardé un exemple, son id vaut : " + savedExample.getId());

		Example example1 = examplePurJPADao.read(1l);
		System.out.println("Avec le DAO pur JPA, j'ai récupéré " + example1);

		ExampleDao exampleDao = applicationContext.getBean(ExampleDao.class);
		Example example2 = new Example();
		example2.setName("Mon exemple qui va passer par le CrudRepository de Spring Data");
		example2.setValid(Boolean.TRUE);
		Example savedExample2 = exampleDao.save(example2);
		System.out.println("Avec le DAO Spring Data, j'ai sauvegardé " + savedExample2);

		Optional<Example> loadedExample2 = exampleDao.findById(savedExample2.getId());
		if(loadedExample2.isPresent()){
			System.out.println("J'ai trouvé example2 par son id : " + loadedExample2.get());
		}else{
			System.out.println("Je n'ai rien trouvé en base");
		}

	}

}
