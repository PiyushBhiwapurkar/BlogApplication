package com.codewithpiyush.blog.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="category")
@NoArgsConstructor
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoryId")
	private Integer categoryId;
	
	@Column(name="categoryTitle", nullable = false,length = 100)
	private String categoryTitle;
	
	@Column(name="categoryDescription")
	private String categoryDescription;
}
