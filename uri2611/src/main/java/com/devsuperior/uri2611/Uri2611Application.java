package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieProjectionDTO;
import com.devsuperior.uri2611.projections.MovieProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieProjection> list1 = movieRepository.search1("Action");
		List<MovieProjectionDTO> resul1 = list1.stream().map(x -> new MovieProjectionDTO(x)).collect(Collectors.toList());

		System.out.println("\n*** RESULTADO SQL RAIZ");
		for(MovieProjectionDTO obj : resul1) {
			System.out.println(obj);

		}

		List<MovieProjectionDTO> resul2 = movieRepository.search2("Action");

		System.out.println("\n*** RESULTADO SQL JPQL");
		for(MovieProjectionDTO obj : resul2) {
			System.out.println(obj);

		}
	}
}
