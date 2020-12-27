package com.example.sbex;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;


@RestController
public class Print {
    @RequestMapping(value = "/employe", method = RequestMethod.GET)

        public String call () throws JsonProcessingException {
            com.example.demo.Employe employee = new com.example.demo.Employe();
            employee.setId(1);
            employee.setName("Ayyappa");
            ObjectMapper objectMapper = new ObjectMapper();
            String empString = objectMapper.writeValueAsString(employee);
            System.out.println(empString);
            com.example.demo.Employe employee1 = objectMapper.readValue(empString, com.example.demo.Employe.class);
            System.out.println(employee1);
            return empString;
        }
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        return mapper;
    }

}

