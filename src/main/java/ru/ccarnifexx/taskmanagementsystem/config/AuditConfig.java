package ru.ccarnifexx.taskmanagementsystem.config;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.ccarnifexx.taskmanagementsystem.model.user.User;
import ru.ccarnifexx.taskmanagementsystem.repository.user.UserRepository;

import java.security.Principal;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AuditConfig {

    UserRepository userRepository;

    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Principal::getName)
                .map(userRepository::findUserByUserEmail)
                .flatMap(user -> user.map(User::getUserId));
    }
}



