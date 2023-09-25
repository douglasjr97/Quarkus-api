package io.github.douglasjr97.quarkusapi.domain.repository;

import io.github.douglasjr97.quarkusapi.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
