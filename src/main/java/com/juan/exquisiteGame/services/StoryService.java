package com.juan.exquisiteGame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.exquisiteGame.models.Story;
import com.juan.exquisiteGame.repositories.StoryRepository;

@Service
public class StoryService {
	@Autowired
	private StoryRepository sRepo;
	
	//findall
	public List<Story> getStories(){
		return this.sRepo.findAll();
	}
	
	
	//get
	public Story getById(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	//create
	public Story create(Story Story) {
		return this.sRepo.save(Story);
	}
	
	//delete
	public void delete(Long id) {
		this.sRepo.deleteById(id);
	}
	
	//update
	public Story updateStory(Story Story) {
		return this.sRepo.save(Story);
	}
	
	//save
	public Story saveStory(Story Story) {
		return this.sRepo.save(Story);
	}
	
}
