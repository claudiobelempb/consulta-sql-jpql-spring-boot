package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieProjectionDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  @Query(
    nativeQuery = true,
    value = "SELECT m.id, m.name " +
      "FROM movies AS m " +
      "INNER JOIN genres AS g " +
      "ON m.id_genres = g.id " +
      "WHERE UPPER(g.description) = UPPER(:genreName)"
  )
  List<MovieProjection> search1(String genreName);

  @Query("SELECT new com.devsuperior.uri2611.dto.MovieProjectionDTO(m.id, m.name) "
    + "FROM Movie AS m "
    + "WHERE UPPER(m.genre.description) = UPPER(:genreName)"
  )
  List<MovieProjectionDTO> search2(String genreName);
}
