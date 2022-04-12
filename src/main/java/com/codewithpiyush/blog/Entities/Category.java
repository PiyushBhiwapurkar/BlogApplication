package com.codewithpiyush.blog.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoryId")
	private Integer categoryId;
	
	@Column(name="categoryTitle")
	private String categoryTitle;
	
	@Column(name="categoryDescription")
	private String categoryDescription;
}
