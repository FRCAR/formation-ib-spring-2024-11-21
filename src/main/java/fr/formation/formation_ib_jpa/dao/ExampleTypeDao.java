package fr.formation.formation_ib_jpa.dao;

import fr.formation.formation_ib_jpa.model.Example;
import fr.formation.formation_ib_jpa.model.ExampleState;
import fr.formation.formation_ib_jpa.model.ExampleType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ExampleTypeDao extends CrudRepository<ExampleType, Long> {
}