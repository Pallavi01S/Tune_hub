package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repository.PlayListRepository;

@Service
public class PlayListServiceImpl implements PlayListService{

	@Autowired
	PlayListRepository playListRepository;
	@Override
	public void addPlaylist(Playlist playlist) {
		playListRepository.save(playlist);
		
		
	}
	@Override
	public List<Playlist> fetchAllPlaylists() {
		return playListRepository.findAll();
	}

}
