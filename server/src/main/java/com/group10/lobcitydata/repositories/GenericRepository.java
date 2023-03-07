package com.group10.lobcitydata.repositories;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface GenericRepository<T> {
    public void saveItem(T item);
    public Optional<T> findItemByID(String id) throws ExecutionException, InterruptedException;
    public T updateItem(T item);
    public Optional<List<T>> getAll();
}
