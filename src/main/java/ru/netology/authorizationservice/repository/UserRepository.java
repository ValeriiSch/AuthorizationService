package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.controller.Authorities;
import ru.netology.authorizationservice.exception.InvalidCredentials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;


@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();
        Map<String, String> usersList = new HashMap<>();

        usersList.put("Oleg", "123");
        usersList.put("Ivan", "555");
        usersList.put("Elena", "666");
        usersList.put("Nina", "0000");

        if (usersList.containsKey(user) && usersList.get(user).equals(password)) {
            if ("Oleg".equals(user)) {
                authoritiesList.add(Authorities.READ);
            }
            if ("Ivan".equals(user)) {
                authoritiesList.add(Authorities.READ);
                authoritiesList.add(Authorities.WRITE);
            }
            if ("Elena".equals(user)) {
                authoritiesList.add(Authorities.READ);
                authoritiesList.add(Authorities.WRITE);
                authoritiesList.add(Authorities.DELETE);
            }
        } else {
            throw new InvalidCredentials("Username or password invalid");
        }

        return authoritiesList;
    }
}