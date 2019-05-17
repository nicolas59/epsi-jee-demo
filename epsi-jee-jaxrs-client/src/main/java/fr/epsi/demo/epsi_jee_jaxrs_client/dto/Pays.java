package fr.epsi.demo.epsi_jee_jaxrs_client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pays {
  private String name;

  private String alpha2Code;

  private String alpha3Code;
  private String capital;

  private String region;

  private String subregion;

  private Long population;

  private String demonym;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAlpha2Code() {
    return alpha2Code;
  }

  public void setAlpha2Code(String alpha2Code) {
    this.alpha2Code = alpha2Code;
  }

  public String getAlpha3Code() {
    return alpha3Code;
  }

  public void setAlpha3Code(String alpha3Code) {
    this.alpha3Code = alpha3Code;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getSubregion() {
    return subregion;
  }

  public void setSubregion(String subregion) {
    this.subregion = subregion;
  }

  public Long getPopulation() {
    return population;
  }

  public void setPopulation(Long population) {
    this.population = population;
  }

  public String getDemonym() {
    return demonym;
  }

  public void setDemonym(String demonym) {
    this.demonym = demonym;
  }

  @Override
  public String toString() {
    return "Pays [name=" + name + ", alpha2Code=" + alpha2Code + ", alpha3Code=" + alpha3Code + ", capital=" + capital + ", region=" + region + ", subregion=" + subregion + ", population="
        + population + ", demonym=" + demonym + "]";
  }
  
  
}
