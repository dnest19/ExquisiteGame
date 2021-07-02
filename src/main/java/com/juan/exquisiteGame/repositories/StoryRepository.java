package com.juan.exquisiteGame.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juan.exquisiteGame.models.Story;

@Repository
public interface StoryRepository extends CrudRepository <Story, Long> {
	List<Story> findAll();
	
}
