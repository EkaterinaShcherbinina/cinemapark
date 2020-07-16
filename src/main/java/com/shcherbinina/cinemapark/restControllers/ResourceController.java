package com.shcherbinina.cinemapark.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/image-{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageById(@PathVariable String id) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        String name = "images/" + id;
        InputStream in = getClass().getClassLoader().getResourceAsStream(name);
        byte[] media = IOUtils.toByteArray(in);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;
    }

}
