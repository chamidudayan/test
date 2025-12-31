package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Page<User> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir) {

        return service.listAll(page, size, sortField, sortDir);
    }

    @PostMapping
    public User create(@RequestBody User u) { return service.create(u); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User u) { return service.update(id, u); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
