package com.example.hospitaldata.parser;

import com.example.hospitaldata.domain.dto.HospitalDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactory {
    @Bean
    public ReadLineContext<HospitalDTO> hospitalReadLineContext() {
        return new ReadLineContext<HospitalDTO>(new HospitalParser());
    }
}
