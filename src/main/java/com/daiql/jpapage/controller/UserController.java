package com.daiql.jpapage.controller;

import com.daiql.jpapage.domain.User;
import com.daiql.jpapage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/userlist")
    public Page<User> getUserByUsername(@RequestParam(value = "username", defaultValue = "daiql") String username,
                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                        @RequestParam(value = "size", defaultValue = "15") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> pages = userRepository.findByUsername(username, pageable);
        return pages;

    }
}
