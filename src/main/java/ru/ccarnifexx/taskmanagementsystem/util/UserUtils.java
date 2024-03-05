package ru.ccarnifexx.taskmanagementsystem.util;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.ccarnifexx.taskmanagementsystem.model.user.User;
import ru.ccarnifexx.taskmanagementsystem.repository.user.UserRepository;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserUtils {

    UserRepository userRepository;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return userRepository
                .findUserByUserEmail(authentication.getName())
                .orElse(null);
    }
}

