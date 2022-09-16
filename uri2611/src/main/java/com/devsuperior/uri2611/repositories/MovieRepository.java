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
    value = "SELECT movies.id, movies.name " +
      "FROM movies " +
      "INNER JOIN genres  " +
      "ON movies.id_genres = genres.id " +
      "WHERE UPPER(genres.description) = UPPER(:genreName)"
  )
  List<MovieProjection> search1(String genreName);

  @Query("SELECT new com.devsuperior.uri2611.dto.MovieProjectionDTO(obj.id, obj.name) "
    + "FROM Movie obj "
    + "WHERE UPPER(obj.genre.description) = UPPER(:genreName)"
  )
  List<MovieProjectionDTO> search2(String genreName);
}
