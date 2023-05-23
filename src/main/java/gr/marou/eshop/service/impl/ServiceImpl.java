package main.java.gr.marou.eshop.service.impl;

import main.java.gr.marou.eshop.domain.Entity;
import main.java.gr.marou.eshop.repository.Repository;
import main.java.gr.marou.eshop.repository.impl.RepositoryImpl;
import main.java.gr.marou.eshop.service.Service;

import java.util.List;


/**
 Abstract implementation of the Service interface.
 @param <T> the type of entity
 */
public abstract class ServiceImpl<T extends Entity> implements Service<T> {

    private final Repository<T> repository;

    public ServiceImpl(Repository<T> repository) {
        this.repository = repository;
    }

    /**
     Adds an entity to the repository.
     @param t the entity to be added
     @return true if the entity is successfully added, false otherwise
     */
    @Override
    public boolean add(T t) {
        return repository.add(t);
    }

    /**
     Retrieves all entities from the repository.
     @return a list of entities
     */
    @Override
    public List<T> read() {
        return repository.read();
    }

    /**
     Retrieves an entity with the specified ID from the repository.
     @param tId the ID of the entity to be retrieved
     @return the entity with the specified ID, or null if not found
     */
    @Override
    public T read(long tId) {
        return repository.read(tId);
    }

    /**
     Deletes an entity with the specified ID from the repository.
     @param tId the ID of the entity to be deleted
     @return true if the entity is successfully deleted, false otherwise
     */
    @Override
    public boolean delete(long tId) {
        return repository.delete(tId);
    }

    /**
     Retrieves the list of deleted entities from the repository.
     @return a list of deleted entities, or null if not supported by the repository implementation
     */
    @Override
    public List<T> getDeletedList() {
        if (repository instanceof RepositoryImpl) {
            return repository.getDeletedList();
        }
        return null;
    }
}
