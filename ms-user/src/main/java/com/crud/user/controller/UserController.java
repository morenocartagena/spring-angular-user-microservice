package com.crud.user.controller;

import com.crud.user.model.User;
import com.crud.user.service.InterfaceUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private InterfaceUserService iUserService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list() {
        var result = iUserService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody User user) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iUserService.save(user);
        if (result == 1) {
            serviceResponse.setMessage("User saved with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody User user) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iUserService.update(user);
        if (result == 1) {
            serviceResponse.setMessage("User updated with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iUserService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("User removed with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

}
