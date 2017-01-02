package org.mitoma.midorodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

@SpringBootApplication
public class MidorodbApplication {

  public static void main(String[] args) {
    SpringApplication.run(MidorodbApplication.class, args);
  }

  @Autowired
  public void register(ObjectMapper mapper) {
    mapper.registerModule(new JaxbAnnotationModule());
  }
}
