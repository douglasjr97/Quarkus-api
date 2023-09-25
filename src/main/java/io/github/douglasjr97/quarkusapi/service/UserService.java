package io.github.douglasjr97.quarkusapi.service;

import io.github.douglasjr97.quarkusapi.domain.model.User;
import io.github.douglasjr97.quarkusapi.domain.repository.UserRepository;
import io.github.douglasjr97.quarkusapi.rest.dto.CreateUserRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.inject.Inject;

import java.util.List;


@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public User createUser(CreateUserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        user.persist();
        return user;
    }

    public List<User> listAllUsers(){
        return userRepository.findAll().list();
    }

    @Transactional
    public User updateUser(Long id, CreateUserRequest userData){
        User changedUser = User.findById(id);
        if (changedUser != null) {
            changedUser.setName(userData.getName());
            changedUser.setAge(userData.getAge());
        }
        return changedUser;
    }

    @Transactional
    public void deleteUser(Long id){
        User user = User.findById(id);
        if(user != null){
            user.delete();
        }
    }
}
