package ru.sergeyyy.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sergeyyy.microservice.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


}
