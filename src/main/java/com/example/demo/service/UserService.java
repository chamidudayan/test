package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Page<User> listAll(int page, int size, String sortField, String sortDir) {
        Sort sort = sortDir.equals("asc") ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findAll(pageable);
    }

    public User create(User u) { return repo.save(u); }

    public User update(Long id, User newUser) {
        User u = repo.findById(id).orElseThrow();
        u.setName(newUser.getName());
        return repo.save(u);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
