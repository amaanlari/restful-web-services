package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Chris Evans", LocalDate.now().minusYears(45).minusMonths(9).minusDays(10)));
        users.add(new User(2, "Fattycuot", LocalDate.of(2003, Month.JUNE, 24)));
        users.add(new User(3, "Mohit", LocalDate.of(2002, 12, 23)));
    }

    List<User> findAll() {
        return users;
    }

    User find(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
