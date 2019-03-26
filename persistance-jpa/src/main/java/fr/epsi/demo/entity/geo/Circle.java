package fr.epsi.demo.entity.geo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("circle")
public class Circle extends Shape{

  @Column
  private Integer radius;

  public Integer getRadius() {
    return radius;
  }

  public void setRadius(Integer radius) {
    this.radius = radius;
  }
  
  
}
