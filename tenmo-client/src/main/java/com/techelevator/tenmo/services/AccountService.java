package com.techelevator.tenmo.services;

import com.techelevator.view.ConsoleService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {

    private final RestTemplate  restTemplate= new RestTemplate();
    private String BASE_URL;
    public static String AUTH_TOKEN= "";

    //private final ConsoleService consoleService = new ConsoleService();
    public AccountService(String url){
        this.BASE_URL=url;
    }

    //Method to get total account balance
    public BigDecimal getTotalAcctBalance(){
        ResponseEntity<BigDecimal> totalBalance = null;
        totalBalance = restTemplate.exchange(BASE_URL+ "/users/totalbalance", HttpMethod.GET, makeAuthEntity(), BigDecimal.class);
        return totalBalance.getBody();
    }

    //Creates new Http Entity with the Bearer Auth token header
    private HttpEntity makeAuthEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

}
