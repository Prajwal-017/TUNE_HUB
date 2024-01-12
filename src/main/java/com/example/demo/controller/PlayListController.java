package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entites.Playlist;
import com.example.demo.entites.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PlayListController {
	@Autowired
	PlaylistService playlistservice;
	@Autowired
	SongService songService;
	@GetMapping("/createPlaylist")
	public String createPlayList(Model model){
		
		List <Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlaylist";
	}

	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		
		playlistservice.addPlaylist(playlist);
		
		System.out.println(playlist);
		
		List <Song>songList = playlist.getSongs();
		
		for(Song s:songList) {
			s.getPlaylist().add(playlist);
			songService.updateSong(s);
		}
		return "adminHome";
		
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		
		List<Playlist> allplaylist = playlistservice.fetchAllplaylists();
		
		model.addAttribute("allplaylist", allplaylist);
		return "displayPlaylists";
	}	
}
