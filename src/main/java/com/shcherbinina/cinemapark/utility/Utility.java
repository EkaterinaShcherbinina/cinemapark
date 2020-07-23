package com.shcherbinina.cinemapark.utility;

import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Utility {

    public static List<Integer> getIntArrayFromString(String str) {
        return Arrays.stream(str.split(","))
                .map(String::trim).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }

    public static List<Integer> getDifferenceList(List<Integer> list1, List<Integer> list2) {
        if(list1 == null && list2 == null) throw new IllegalArgumentException();
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        List<Integer> list = new ArrayList<>();
        for(int val: list1) {
            if(list2.contains(val)) continue;

            list.add(val);
        }
        return  list;
    }

    public static String getCurrentUserName() {
        String res;
        try {
            UserDTO userDTO = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            res = userDTO.getFirstName();
        } catch (ClassCastException ex) {
            res = null;
        }
        return res;
    }

    public static String getFormattedDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(Constants.dateFormat);
        Date formattedDate = new Date();
        try {
            formattedDate= format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate.toString();
    }

    public static String getNowFormattedDate() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        return date.toString();
    }

    public static String getNowDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(Constants.dateFormat));
    }
}
