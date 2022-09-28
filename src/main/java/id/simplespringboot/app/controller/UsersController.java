package id.simplespringboot.app.controller;

import id.simplespringboot.app.model.Users;
import id.simplespringboot.app.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired protected UsersServices usersService;

    @PostMapping("/")
    public ResponseEntity<Users> insertUsers(@RequestBody Users users) {
        usersService.insertUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users users) {
        usersService.updateUsers(id, users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        Users user = usersService.getUsersById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<Users>> getUsersList() {
        List<Users> users = usersService.getList();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
