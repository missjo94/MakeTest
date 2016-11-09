package com.maketest.controller;

import com.maketest.dto.TestDTO;
import com.maketest.model.Test;
import com.maketest.model.User;
import com.maketest.service.TestService;
import com.maketest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Jovana Micic on 08-Nov-16.
 */
@RestController
@RequestMapping(value = "/api/tests")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    UserService userService;

    /* Creating new test. */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TestDTO> addNewTest(@RequestBody TestDTO t, @RequestHeader("mtt") String token){
        User user = userService.getUserProfile(token);
        Test test = new Test();
        test.setTestName(t.getTestName());
        test.setDescription(t.getDescription());
        test.setCategory(t.getCategory());
        test.setUserTests(user);
        test.setCreatingDate(new Date());  //TODO dodati cuvanje pitanja
        test = testService.save(test);
        return new ResponseEntity<>(new TestDTO(test), HttpStatus.OK);
    }

    /* Updating test info.*/
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<TestDTO> updateTest(@RequestBody TestDTO t, @RequestHeader("mtt") String token){
        Test test = testService.findOne(t.getId());
        if(test == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        test.setTestName(t.getTestName());
        test.setDescription(t.getDescription());
        test.setCategory(t.getCategory());  //TODO dodati cuvanje pitanja
        testService.save(test);
        return new ResponseEntity<>(new TestDTO(test), HttpStatus.OK);
    }
















}