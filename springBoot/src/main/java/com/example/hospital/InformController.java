package com.example.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8083")
@RequestMapping("/api/v1/hospital/")
@RestController
public class InformController {

    @Autowired
    InformService informService;

    @Autowired
    InformRepository informRepository;


    @RequestMapping("/hospital")
    public String Hospital (){
        return "This is a test for the first java class controller";
    }

    //CRUD: read

    @RequestMapping("/informs")
    public Iterable<Inform> getAllInforms (){ //arraylist o iterable


        return informRepository.findAll();

    }

    @RequestMapping("/populate")
    public String populateDB(){

        informService.populate();

        return "ok";
    }

}
