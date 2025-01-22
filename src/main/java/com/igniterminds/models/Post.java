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
	private User user;
	private LocalDate createdDate;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(Integer postId, String caption, String image, String video, User user, LocalDate createdDate) {
		super();
		this.postId = postId;
		this.caption = caption;
		this.image = image;
		this.video = video;
		this.user = user;
		this.createdDate = createdDate;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", caption=" + caption + ", image=" + image + ", video=" + video + ", user="
				+ user + ", createdDate=" + createdDate + "]";
	}
	
	
}
