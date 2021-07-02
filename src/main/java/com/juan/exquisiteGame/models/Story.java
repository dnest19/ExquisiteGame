package com.juan.exquisiteGame.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="stories")
public class Story {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Min(value=1500)
	private int max_length;
	@NotBlank
	private String genre;
	@NotBlank
	private String title;
	@NotBlank
	private String text;
	private String sentence;
	private boolean storyComplete;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}


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
	
	public void concatSentence() {
		if(this.sentence.length() > 1) {
		this.text = this.text + this.sentence;
		if(this.text.length() >= this.max_length) {
			this.storyComplete = true;
		}
		this.sentence = null;
		}
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "users_stories", 
        joinColumns = @JoinColumn(name = "story_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	List<User> users;
}
