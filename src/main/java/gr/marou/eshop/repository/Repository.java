package main.java.gr.marou.eshop.repository;

import java.util.List;

/**
 Generic repository interface for CRUD operations on entities.
 @param <T> the type of entity
 */
public interface Repository <T>{
    boolean add (T t);
    List<T> read();
    T read(long tId);
    boolean delete(long tId);
    List<T> getDeletedList();
}
