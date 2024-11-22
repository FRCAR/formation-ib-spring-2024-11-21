package fr.formation.formation_ib_jpa.dao;

import fr.formation.formation_ib_jpa.model.Example;
import fr.formation.formation_ib_jpa.model.ExampleState;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ExampleDao extends CrudRepository<Example, Long> {

    List<Example> findByName(String name);

    Set<Example> findByNameAndValid(String name, Boolean valid);

    List<Example> findByNameStartingWith(String name);

    @Query("select e " +
            " from Example e " +
            " where e.state = :state " +
                " and (e.name = :name or e.valid is true) ")
    List<Example> rechercheCompliquee(@Param("state") ExampleState state,
                                      @Param("name") String name );
    @Modifying
    @Query("update Example e " +
            "set e.name = upper(name) " +
            "where e.name = :name ")
    int capitalizeName(@Param("name") String name);

    @Query("select e " +
            " from Example e " +
            " join fetch e.type t " +
            " where e.id = :id ")
    Example findByIdWithType(@Param("id") Long id );

}
