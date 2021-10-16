package com.shalini.receipe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="receipe")
public class Receipe {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name="id")
	  private Integer id;
	  @Column(name="name")
	  private String name;
	  @Column(name="image")
	  private String image;
	  @Column(name="category")
	  private String category;
	  @Column(name="label")
	  private String label;
	  @Column(name="price")
	  private Double price;
	  @Column(name="description")
	  private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	  
	  
	  
	  

}
