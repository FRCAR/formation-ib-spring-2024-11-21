package fr.formation.formation_ib_jpa.service;

import fr.formation.formation_ib_jpa.model.Example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

@SpringBootTest
public class ExampleServiceTest {

    @Autowired
    ExampleService exampleService;

    @Test
    public void testSaveValid(){
        //Arrange
        Example example = new Example();
        example.setValid(Boolean.TRUE);
        example.setName("Exemple de l'après-midi");

        //Act
        Example exampleSaved = exampleService.save(example);

        //Assert
        Assertions.assertNotNull(exampleSaved);
        Assertions.assertNotNull(exampleSaved.getId());
    }

    @Test
    public void testSaveInvalid(){
        //Arrange
        Example example = new Example();
        example.setValid(Boolean.FALSE);
        example.setName("Exemple de l'après-midi");

        //Act assert
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> exampleService.save(example));

    }

    @Test
    public void testFindByNameStartingWith(){
        //Arrange
        Example example = new Example();
        example.setValid(Boolean.TRUE);
        example.setName("Un autre exemple");
        Example exampleSaved = exampleService.save(example);
        //Act
        Collection<Example> examples = exampleService.findByNameStartingWith("Un autre");

        //Assert
        Assertions.assertFalse(examples.isEmpty());
    }

}