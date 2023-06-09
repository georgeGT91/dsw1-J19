
package com.example.consumingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.consumingwebservice.wsdl.GetCountryResponse;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Peru";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			System.err.println("===================================");
			System.err.println("===================================");
			System.err.println(response.getCountry().getCurrency());
			System.err.println(response.getCountry().getCapital());
			System.err.println(response.getCountry().getPopulation());
			System.err.println("===================================");
			System.err.println("===================================");
		};
	}

}
