package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{

	Song findByName(String name);

}