package com.igniterminds.models;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@RestController
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	private String caption;
	private String image;
	private String video;
	private String user;
	private LocalDate createdDate;
	
	
}
