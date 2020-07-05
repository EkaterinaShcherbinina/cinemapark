package com.shcherbinina.cinemapark.init;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import com.shcherbinina.cinemapark.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
    }

}
