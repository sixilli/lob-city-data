package com.group10.lobcitydata.controllers;

import com.group10.lobcitydata.models.User;
import com.group10.lobcitydata.repositories.Impl.UserRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;

/*
    2.0.3 User Endpoint
 */
@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepositoryImpl userRepositoryImpl;

    public UserController(UserRepositoryImpl userRepo) {
        this.userRepositoryImpl = userRepo;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> postGetUser(@RequestBody User reqBody) {
        if (reqBody.uuid.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "malformed user " + reqBody);
        }

        var user = userRepositoryImpl.findItemByID(reqBody.uuid);
        if (user.isEmpty()) {
            userRepositoryImpl.saveItem(reqBody);
            user = userRepositoryImpl.findItemByID(reqBody.uuid);
            if (user.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "failed to persist new user");
            }
        }

        return ResponseEntity.ok(user.get());
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> patchUser(@RequestBody User reqBody) {
        if (reqBody.uuid.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "no id was provided");
        }

        var user = userRepositoryImpl.findItemByID(reqBody.uuid).orElseThrow(() ->
            new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                "could not find user with id: " + reqBody.uuid)
        );

        if (!Objects.equals(reqBody.favoriteTeam, user.getFavoriteTeam())) {
            user.setFavoriteTeam(reqBody.getFavoriteTeam());
            userRepositoryImpl.updateItem(user);
        }

        return ResponseEntity.ok(user);
    }
}
