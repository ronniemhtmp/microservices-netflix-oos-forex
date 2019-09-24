package dev.ronniemoncayo.currencyconversionservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.ronniemoncayo.currencyconversionservice.beans.CurrencyConversionBean;

/**
 * CurrencyExchangeServiceProxy
 */
@FeignClient(name = "forex-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
            @PathVariable("to") String to);
}