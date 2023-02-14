package com.deb.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment enviroment;
	
	@Autowired
	private CurrencyExchangeRepository reop;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValues(@PathVariable String from, @PathVariable String to) {
		
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = reop.findByFromAndTo(from, to);
		
		if(currencyExchange==null)
			throw new RuntimeException("Unable to find data for" + from + "to"+ to);
		
		String port = enviroment.getProperty("local.server.port");
		currencyExchange.setEnviroment(port);
		return currencyExchange;
	}

}
