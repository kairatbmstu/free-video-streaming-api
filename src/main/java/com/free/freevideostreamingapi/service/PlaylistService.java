package com.free.freevideostreamingapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.free.freevideostreamingapi.application.dto.PlaylistDto;
import com.free.freevideostreamingapi.application.dto.PlaylistItemDto;
import com.free.freevideostreamingapi.infrastucture.entity.PlaylistEntity;
import com.free.freevideostreamingapi.infrastucture.repository.PlaylistItemRepository;
import com.free.freevideostreamingapi.infrastucture.repository.PlaylistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    PlaylistItemRepository playlistItemRepository;

    public List<PlaylistEntity> findPlaylistsByUserId(String userId){
        return playlistRepository.findByUserId(userId);
    }

    public PlaylistEntity getPlaylistById(String id) {
        return playlistRepository.findById(id).get();
    }

    public void postPlayList(com.free.freevideostreamingapi.application.dto.PlaylistDto playlistDto) {
        PlaylistEntity playlist = new PlaylistEntity();
        playlist.setId(UUID.randomUUID().toString());
        List<String> playlistItems = new ArrayList<>();
        for (PlaylistItemDto itemDto : playlistDto.getItems()){
            playlistItems.add(itemDto.getId());
        }        
        playlist.setPlaylistItems(playlistItems);
        playlistRepository.save(playlist);
    }

    public void putPlaylist(PlaylistDto playlistDto) {
        PlaylistEntity playlist = new PlaylistEntity();
        playlist.setId(UUID.randomUUID().toString());
        List<String> playlistItems = new ArrayList<>();
        for (PlaylistItemDto itemDto : playlistDto.getItems()){
            playlistItems.add(itemDto.getId());
        }        
        playlist.setPlaylistItems(playlistItems);
        playlistRepository.save(playlist);
    }

    public void deletePlaylistId(String id) {
        playlistRepository.deleteById(id);
    }


    public void getPlaylistItems() {
        
    }

    public void addPlaylistItem() {

    }

    public void deletePlaylistItem() {

    }

    public void updatePlaylistItem() {

    }

}
