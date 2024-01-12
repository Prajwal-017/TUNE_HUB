package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.Song;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SongController {
	
	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		{
			boolean songStatus = service.songExists(song.getName());
			if(songStatus == false) {
				service.addSong(song);
				System.out.println("Song Added");
			}
			else {
				System.out.println("Song Already Exists");
			}
			return "home";
			
		}
	}
	
	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		
		List<Song> songlist = service.fetchAllSongs();
		
		model.addAttribute("songs", songlist);
		
		return "displaySongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		
		
		boolean premiumUser = false;
		
		if(premiumUser == true) {
			List<Song> songlist = service.fetchAllSongs();
			model.addAttribute("songs", songlist);
			return "displaySongs";
		}else {
			return "makePayment";
		}
	}

}
