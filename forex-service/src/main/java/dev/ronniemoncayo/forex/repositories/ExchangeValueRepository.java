package dev.ronniemoncayo.forex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ronniemoncayo.forex.entities.ExchangeValue;

/**
 * ExchangeValueRepository
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);

}