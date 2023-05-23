package main.java.gr.marou.eshop.repository.impl;

import main.java.gr.marou.eshop.domain.Entity;
import main.java.gr.marou.eshop.repository.Repository;
import java.util.ArrayList;
import java.util.List;

/**

 Abstract implementation of the Repository interface.
 Provides common functionality for managing entities in a list.
 @param <T> the type of the entity
 */
public abstract class RepositoryImpl<T extends Entity> implements Repository<T> {

    private final List<T> list ;
    private final List<T> deletedList;

    public RepositoryImpl(List<T> list) {
        this.list = list;
        this.deletedList = new ArrayList<>();
    }

    /**
     Adds an entity to the repository.
     @param t the entity to add
     @return true if the entity was added successfully, false otherwise
     */
    @Override
    public boolean add(T t) {
        if (t.isValid()){
            list.add(t);
            return true;
        }
        return false;
    }

    /**
     Retrieves all entities in the repository.
     @return a list of entities
     */
    @Override
    public List<T> read() {
        return list;
    }

    /**
     Retrieves the entity with the specified ID from the repository.
     @param tId the ID of the entity
     @return the entity with the specified ID, or null if not found
     */
    @Override
    public T read(long tId) {
        for (T t:list){
            if (t.getId() == tId){
                return t;
            }
        }
        return null;
    }

    /**
     Deletes the entity with the specified ID from the repository.
     @param tId the ID of the entity to delete
     @return true if the entity was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(long tId) {
        T t = read(tId);
        if( t == null) return false;
        deletedList.add(t);
        list.remove(t);
        return true;
    }

    /**
     Retrieves the list of deleted entities.
     @return a list of deleted entities
     */
    @Override
    public List<T> getDeletedList() {
        return deletedList;
    }
}
