package com.kipa.kipa.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService service;


    // Data sent back and forth is converted to JSON by default

    // Get objs
    @GetMapping("/test")
    public List<TestObj> Test() {
        return service.getObjects();
    }

    // Get obj by ID
    @GetMapping("/test/{testID}")
    public TestObj getByID(@PathVariable int testID) {
        return service.getID(testID);
    }

    // Add obj
    @PostMapping("/testing")
    public void addObj(@RequestBody TestObj obj) {
        service.addNewObj(obj);
    }

    // Update obj
    @PutMapping("/upd")
    public void updateObj(@RequestBody TestObj obj) {
        service.updateObj(obj);
    }

    // Delete obj
    @DeleteMapping("/del/{objID}")
    public void delObj(@PathVariable int objID) {
        service.delObj(objID);
    }
}
