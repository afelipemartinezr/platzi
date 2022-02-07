package com.fundamentos.platzi.service;

import com.fundamentos.platzi.PlatziApplication;
import com.fundamentos.platzi.entity.User;
import com.fundamentos.platzi.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    Log LOGGER = LogFactory.getLog(PlatziApplication.class);
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOGGER.info(user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User newUser) {
     return   userRepository.save(newUser);
    }

    public void delete(Long id) {

        userRepository.delete(new User(id));
    }

    public User update(User newUser, long id) {

        return
                userRepository.findById(id)
                .map(
                        user -> {
                            user.setEmail(newUser.getEmail());
                            user.setBirthDate(newUser.getBirthDate());
                            user.setName(newUser.getName());
                            return userRepository.save(user);

                        }

                ).get();
    }
}
