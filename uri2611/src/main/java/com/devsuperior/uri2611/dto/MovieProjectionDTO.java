package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MovieProjection;

public class MovieProjectionDTO {

  private Long id;
  private String name;

  public MovieProjectionDTO(){}

  public MovieProjectionDTO(Long id, String name) {

    this.id = id;
    this.name = name;
  }

  public MovieProjectionDTO(MovieProjection movie) {

    id = movie.getId();
    name = movie.getName();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "MovieProjectionDTO{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }
}
