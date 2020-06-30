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

    private UserDAO userDAO;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DataInit(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = userDAO.count();

        /*if (count == 0) {
            Person p1 = new Person();

            p1.setFullName("Tiggy");

            Date d1 = df.parse("2017-12-01");
            p1.setDateOfBirth(d1);
            //
            Person p2 = new Person();

            p2.setFullName("Mikky");
            Date d2 = df.parse("2016-04-11");
            p2.setDateOfBirth(d2);

            personDAO.save(p1);
            personDAO.save(p2);
        }*/

    }

}
