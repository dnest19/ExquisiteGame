package com.juan.exquisiteGame.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stories")
public class Story {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int max_length;
	private String genre;
	private boolean storyComplete;
	public Story() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMax_length() {
		return max_length;
	}
	public void setMax_length(int max_length) {
		this.max_length = max_length;
	}
	public boolean isStoryComplete() {
		return storyComplete;
	}
	public void setStoryComplete(boolean storyComplete) {
		this.storyComplete = storyComplete;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
