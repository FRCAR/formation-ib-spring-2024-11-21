package fr.formation.formation_ib_jpa.dao;

import fr.formation.formation_ib_jpa.model.Example;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ExampleDao extends CrudRepository<Example, Long> {

    List<Example> findByName(String name);

    Set<Example> findByNameAndValid(String name, Boolean valid);

    List<Example> findByNameStartingWith(String name);


}
