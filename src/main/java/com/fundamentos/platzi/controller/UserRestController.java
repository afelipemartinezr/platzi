package com.fundamentos.platzi.controller;

import com.fundamentos.platzi.caseuse.CreateUser;
import com.fundamentos.platzi.caseuse.DeleteUser;
import com.fundamentos.platzi.caseuse.GetUser;
import com.fundamentos.platzi.caseuse.UpdateUser;
import com.fundamentos.platzi.entity.User;
import com.fundamentos.platzi.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private UserRepository userRepository;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser, UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.userRepository = userRepository;
    }

    @GetMapping("status")
    String status(){
        return HttpStatus.ACCEPTED.toString();
    }


    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){

        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")

    ResponseEntity deleteUser(@PathVariable Long id){

        deleteUser.remove(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")

    ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id){

        return new ResponseEntity<User>(updateUser.update(newUser,id), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page, @RequestParam int size){

       return userRepository.findAll(PageRequest.of(page,size)).getContent();

    }

}
