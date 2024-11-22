package fr.formation.formation_ib_jpa.dao;

import fr.formation.formation_ib_jpa.model.Example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExamplePurJPADao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Example save(Example example){
        //Code de récupération de l'entityManager
        //entityManager.persist(example);//Insere une ligne
        return entityManager.merge(example);//met à jour une ligne, mais peut aussi insérer
    }

    public void delete(Example example){
        entityManager.remove(example);
    }

    public Example read(Long id){
       return entityManager.find(Example.class, id);
    }
}
