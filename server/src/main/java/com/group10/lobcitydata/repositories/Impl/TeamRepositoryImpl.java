package com.group10.lobcitydata.repositories.Impl;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.group10.lobcitydata.models.rapidapi.Team;
import com.group10.lobcitydata.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

// 2.3.1  Team Repo for firestore
@Component
public class TeamRepositoryImpl implements GenericRepository<Team> {
    private final CollectionReference collection;

    @Autowired
    public TeamRepositoryImpl(Firestore db) {
        this.collection = db.collection("teams");
    }

    @Override
    public void saveItem(Team item) {
        this.collection.document(Integer.toString(item.getId())).set(item);
    }

    @Override
    public Optional<Team> findItemByID(String id) {
        var snapshotFuture = this.collection.document(id).get();
        try {
            var snapshot = snapshotFuture.get();
            if (snapshot.exists()) {
                return Optional.ofNullable(snapshot.toObject(Team.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public Team updateItem(Team item) {
        return item;
    }

    @Override
    public Optional<List<Team>> getAll() {
        var collectionFuture = this.collection.get();
        try {
            var queryDocumentSnapshots = collectionFuture.get().getDocuments();
            return Optional.of(queryDocumentSnapshots.stream()
                    .map(queryDocumentSnapshot -> queryDocumentSnapshot.toObject(Team.class))
                    .collect(Collectors.toList()));

        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        return null;
    }

    public void batch(List<Team> teams) {
        for(Team team : teams) {
            var resp = this.collection.document(Integer.toString(team.getId())).set(team);
            try {
                resp.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
                break;
            }
        }
    }
}
