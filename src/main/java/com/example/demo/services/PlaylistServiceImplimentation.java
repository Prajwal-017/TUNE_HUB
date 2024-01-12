package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Playlist;
import com.example.demo.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImplimentation implements PlaylistService{
	@Autowired
	PlaylistRepository repo;
	


	@Override
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Playlist> fetchAllplaylists() {
		
		
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
