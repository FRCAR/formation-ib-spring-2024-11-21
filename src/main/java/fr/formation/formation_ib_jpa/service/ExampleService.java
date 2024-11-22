package fr.formation.formation_ib_jpa.service;

import fr.formation.formation_ib_jpa.dao.ExampleDao;
import fr.formation.formation_ib_jpa.model.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExampleService {

    @Autowired
    private ExampleDao exampleDao;

    @Transactional
    public Example save(Example example){
        if (!example.getValid()) {
            throw new IllegalArgumentException();
        }
        System.out.println("Example est valide !");
        return exampleDao.save(example);
    }

    @Transactional
    public void deleteById(Long exampleId){
        exampleDao.deleteById(exampleId);
    }

    public Example findById(Long id){
        Optional<Example> example = exampleDao.findById(id);
        if(example.isPresent()){
            return example.get();
        }
        return null;
    }

    public List<Example> findByNameStartingWith(String prefix) {
        return exampleDao.findByNameStartingWith(prefix);
    }
}
