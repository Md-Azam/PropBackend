package com.arshaa;

import com.arshaa.common.Bed;
import com.arshaa.entity.Guest;
import com.arshaa.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
//@EnableScheduling
@EnableEurekaClient
public class GuestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GuestApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(GuestApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    

    @Autowired
    private GuestRepository repo;

//    @Scheduled(cron = "*/10 * * * * *")
//    void addDue() {
//        ResponseEntity<Bed[]> responseEntity = restTemplate().getForEntity("http://bedService/bed/getAllBeds", Bed[].class);
//        Bed[] array = responseEntity.getBody();
//        List<String> ids = Arrays.stream(array).map(Bed::getGuestId).collect(Collectors.toList());
//        for (String id : ids ){
//            System.out.println(id);
//        }
//    }
}
