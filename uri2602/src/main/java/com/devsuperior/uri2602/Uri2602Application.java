package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerGetNameDTO;
import com.devsuperior.uri2602.projections.CustomerGetName;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CustomerGetName> list1 = customerRepository.customerGetName("RS");
		List<CustomerGetNameDTO> resul1 = list1.stream().map(x -> new CustomerGetNameDTO(x)).collect(Collectors.toList());

		System.out.println("\n*** RESULTADO SQL RAIZ");

		for(CustomerGetNameDTO obj : resul1) {
			System.out.println(obj);

		}

		List<CustomerGetNameDTO> resul2 = customerRepository.customerGetNameDto("RS");

		System.out.println("\n*** RESULTADO SQL JPQL");
		for(CustomerGetNameDTO obj : resul2) {
			System.out.println(obj);

		}	}
}
