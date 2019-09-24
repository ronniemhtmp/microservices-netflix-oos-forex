package dev.ronniemoncayo.forex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.ronniemoncayo.forex.entities.ExchangeValue;
import dev.ronniemoncayo.forex.repositories.ExchangeValueRepository;

/**
 * ForexController
 */
@RestController
public class ForexController {

    @Autowired
    private Environment environment;
  
    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
      (@PathVariable String from, @PathVariable String to){
      
      ExchangeValue exchangeValue = 
          repository.findByFromAndTo(from, to);
      
      exchangeValue.setPort(
          Integer.parseInt(environment.getProperty("local.server.port")));
      
      return exchangeValue;
    }
}