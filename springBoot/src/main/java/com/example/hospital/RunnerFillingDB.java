package com.example.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerFillingDB implements ApplicationRunner {
    @Autowired
    InformService informService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        informService.populate();
    }
}
