package com.group10.lobcitydata.repositories.Impl;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.group10.lobcitydata.models.User;
import com.group10.lobcitydata.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

// 2.3.3 User Repo for firestore
@Component
public class UserRepositoryImpl implements GenericRepository<User> {
    private final Firestore db;
    private final CollectionReference collection;

    @Autowired
    public UserRepositoryImpl(Firestore db) {
        this.db = db;
        this.collection = db.collection("users");
    }

    @Override
    public void saveItem(User item) {
        this.collection.document(item.getUuid()).set(item);
    }

    @Override
    public Optional<User> findItemByID(String id) {
        var snapshotFuture = this.collection.document(id).get();
        try {
            var snapshot = snapshotFuture.get();
            if (snapshot.exists()) {
                return Optional.ofNullable(snapshot.toObject(User.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public User updateItem(User item) {
                                    return null;
                                                }

    @Override
    public Optional<List<User>> getAll() {
        var collectionFuture = this.collection.get();
        try {
            var queryDocumentSnapshots = collectionFuture.get().getDocuments();
            return Optional.of(queryDocumentSnapshots.stream()
                    .map(queryDocumentSnapshot -> queryDocumentSnapshot.toObject(User.class))
                    .collect(Collectors.toList()));

        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        return Optional.empty();
    }
}
