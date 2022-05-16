package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProjectionProductNameDTO;
import com.devsuperior.uri2621.projections.ProjectionProductName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProjectionProductName> list1 = repository.search1(10, 20,"P");
		List<ProjectionProductNameDTO> resul1 = list1.stream().map(x -> new ProjectionProductNameDTO(x)).collect(Collectors.toList());

		System.out.println("\n*** RESULTADO SQL RAIZ");
		for(ProjectionProductNameDTO obj : resul1) {
			System.out.println(obj);
		}

		List<ProjectionProductNameDTO> resul2 = repository.search2(10, 20, "P");

		System.out.println("\n*** RESULTADO SQL JPQL");
		for(ProjectionProductNameDTO obj : resul2) {
			System.out.println(obj);

		}
	}
}
