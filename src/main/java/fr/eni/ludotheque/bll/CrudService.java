package fr.eni.ludotheque.bll;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    void ajouter(T entity);

    public List<T> findAll();

    Optional<T> findById(int id);

    void update(T entity);



    void deleteById(int id);
}
