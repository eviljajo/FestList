package com.festlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "festival")
public class Festival {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mainGenre")
	private String mainGenre;
	
	@Column(name = "link")
	private String link;
	
	
	
	
	

}
