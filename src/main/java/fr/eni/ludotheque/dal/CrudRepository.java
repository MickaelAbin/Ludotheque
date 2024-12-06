package fr.eni.ludotheque.dal;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T>{
     void ajouter(T entity, int jeuId);

    public List<T> findAll();

    Optional<T> findById(int id);

    void update(T entity);



    void deleteById(int id);
}

