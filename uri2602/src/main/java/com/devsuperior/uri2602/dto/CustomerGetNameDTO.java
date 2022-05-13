package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.projections.CustomerGetName;

public class CustomerGetNameDTO {
  private String name;

  public CustomerGetNameDTO(){}

  public CustomerGetNameDTO(String name) {
    this.name = name;
  }

  public CustomerGetNameDTO(CustomerGetName customerGetName){
    name = customerGetName.getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "CustomerGetNameDTO{" +
      "name='" + name + '\'' +
      '}';
  }
}