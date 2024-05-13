package com.example.hospital;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class InformService {

   // static ArrayList<Inform> informs = new ArrayList<>();
    @Autowired
    InformRepository informRepository;

    public List<Inform> createFakeInforms(){

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        Date date = new Date();
        List<Inform> informs = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <10 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            Inform inform = new Inform( uniqueID,
                    date.toString(),
                    faker.number().numberBetween(1, 7), faker.bool().bool()
            );
            informs.add(inform);

        }

        return informs;
    }

    public List<Inform> populate() {

        List<Inform> informs = createFakeInforms();

        for (int i = 0; i < 10; i++) {
            informRepository.save(informs.get(i));
            informs.add(informs.get(i));
        }

        return informs;
    }
}


