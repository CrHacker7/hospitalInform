package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Inform;
import com.example.repository.InformRepository;
import com.example.service.InformService;

import org.springframework.http.HttpHeaders; //another
import org.springframework.http.ResponseEntity; // another
import java.util.Optional; // another



@CrossOrigin(origins = "http://localhost:8083")

@RestController
@RequestMapping("/api/v1/hospital/")
public class InformController {

    @Autowired
    InformService informService;

    @Autowired
    InformRepository informRepository;

    //CRUD: create
    @PostMapping(path="create", consumes = "application/JSON")
    public Inform createInform(@RequestBody Inform inform){
        return informRepository.save(inform);
    } // another


    /*@RequestMapping("/hospital")
    public String Hospital (){
        return "This is a test for the first java class controller";
    } */

    //CRUD: read

    @RequestMapping("/informs")
    public Iterable<Inform> getAllInforms (){ //arraylist o iterable


        return informRepository.findAll();

    }

    //CRUD: update
    @PutMapping("/update/{id}")
    public ResponseEntity<Inform> updateInform (@PathVariable String id, @RequestBody Inform inform) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("operation", "updateInform");
        headers.add("version", "api 1.0");

        Optional<Inform> informFound = informRepository.findById(id);

        //If id is not found we will return 404 (not found) status code
        if (informFound.isPresent()) {
            Inform informToUpdate = informFound.get();
            Inform informUpdated = informRepository.save(informToUpdate);
            //return informUpdated;
            return ResponseEntity.accepted().headers(headers).body(informUpdated);
        } else{
            //return null;
            return ResponseEntity.notFound().headers(headers).build();
        }

    }
// lo sgte no está en el otro repo*********
    @RequestMapping("/populate")
    public String populateDB(){

        informService.populate();

        return "ok";
    }

}
