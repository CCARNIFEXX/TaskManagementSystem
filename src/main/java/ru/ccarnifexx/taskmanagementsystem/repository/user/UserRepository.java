package ru.ccarnifexx.taskmanagementsystem.repository.user;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ccarnifexx.taskmanagementsystem.model.user.User;

import java.util.Optional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

public interface UserRepository extends Repository<User, Long> {
    @Transactional(propagation = REQUIRES_NEW)
    Optional<User> findUserByUserEmail(String userEmail);
}
