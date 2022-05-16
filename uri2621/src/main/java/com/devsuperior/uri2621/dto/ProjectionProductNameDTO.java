package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProjectionProductName;

public class ProjectionProductNameDTO {
  private String name;

  public ProjectionProductNameDTO(){}

  public ProjectionProductNameDTO(String name) {
    this.name = name;
  }
  public ProjectionProductNameDTO(ProjectionProductName projectionProductName){
    name = projectionProductName.getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ProjectionProductNameDTO{" +
      "name='" + name + '\'' +
      '}';
  }
}
