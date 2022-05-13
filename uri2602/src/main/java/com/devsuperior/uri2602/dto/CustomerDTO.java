package com.devsuperior.uri2602.dto;

public class CustomerDTO {
  private Long id;
  private String name;
  private String street;
  private String city;
  private String state;
  private Double creditLimit;

  public CustomerDTO() {
  }

  public CustomerDTO(Long id, String name, String street, String city, String state, Double creditLimit) {
    this.id = id;
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
    this.creditLimit = creditLimit;
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

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Double getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(Double creditLimit) {
    this.creditLimit = creditLimit;
  }
}
