package com.group10.lobcitydata.repositories.Impl;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteBatch;
import com.group10.lobcitydata.models.nba.NbaTeamStatistic;
import com.group10.lobcitydata.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

// 2.3.2 Team Statistic Repo for firestore
@Component
public class TeamStatisticRepoImpl implements GenericRepository<NbaTeamStatistic> {
    private final Firestore db;
    private final CollectionReference collection;

    @Autowired
    public TeamStatisticRepoImpl(Firestore db) {
        this.db = db;
        this.collection = db.collection("team_statistics");
    }

    @Override
    public void saveItem(NbaTeamStatistic item) {
        this.collection.document(item.getId()).set(item);
    }

    @Override
    public Optional<NbaTeamStatistic> findItemByID(String id) {
        var snapshotFuture = this.collection.document(id).get();
        try {
            var snapshot = snapshotFuture.get();
            if (snapshot.exists()) {
                return Optional.ofNullable(snapshot.toObject(NbaTeamStatistic.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public NbaTeamStatistic updateItem(NbaTeamStatistic item) {
        return null;
    }

    @Override
    public Optional<List<NbaTeamStatistic>> getAll() {
        var collectionFuture = this.collection.get();
        try {
            var queryDocumentSnapshots = collectionFuture.get().getDocuments();
            return Optional.of(queryDocumentSnapshots.stream()
                    .map(queryDocumentSnapshot -> queryDocumentSnapshot.toObject(NbaTeamStatistic.class))
                    .collect(Collectors.toList()));

        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    public void batchSet(List<NbaTeamStatistic> teamStatistics) throws ExecutionException, InterruptedException {
        // Get a new write batch
        WriteBatch batch = db.batch();

        for (var teamStatistic : teamStatistics) {
            var teamStatRef = this.collection.document(teamStatistic.id);
            batch.set(teamStatRef, teamStatistic);
        }

        // asynchronously commit the batch
        batch.commit();
    }
}
