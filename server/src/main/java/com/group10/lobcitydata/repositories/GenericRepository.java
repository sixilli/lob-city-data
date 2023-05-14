package com.group10.lobcitydata.repositories;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface GenericRepository<T> {
    void saveItem(T item);
    Optional<T> findItemByID(String id) throws ExecutionException, InterruptedException;
    T updateItem(T item);
    Optional<List<T>> getAll();
}
