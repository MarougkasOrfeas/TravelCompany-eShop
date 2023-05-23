package main.java.gr.marou.eshop.service;

import java.util.List;

/**
 Service interface for basic CRUD operations.
 @param <T> the type of entity
 */
public interface Service<T> {

    boolean add(T t);
    List<T> read();
    T read(long tId);
    boolean delete(long tId);
    List<T> getDeletedList();
}
