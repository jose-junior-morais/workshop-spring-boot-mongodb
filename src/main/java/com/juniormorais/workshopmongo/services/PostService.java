package com.juniormorais.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniormorais.workshopmongo.domain.Post;
import com.juniormorais.workshopmongo.repository.PostRepository;
import com.juniormorais.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Optional<Post> findById(String id) {

	Optional<Post> user = repo.findById(id);

	if(user == null) {

	throw new ObjectNotFoundException("Objeto não encontrado");

	}

	return user;

	   }
	
	public List<Post> findByTitle(String txt){
		return repo.searchTitle(txt);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime()+24*60*60*1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
