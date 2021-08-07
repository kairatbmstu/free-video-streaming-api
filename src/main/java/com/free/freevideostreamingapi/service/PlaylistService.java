package com.free.freevideostreamingapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import com.free.freevideostreamingapi.dto.PlaylistDto;
import com.free.freevideostreamingapi.dto.PlaylistItemDto;
import com.free.freevideostreamingapi.entity.Playlist;
import com.free.freevideostreamingapi.repository.PlaylistItemRepository;
import com.free.freevideostreamingapi.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    PlaylistItemRepository playlistItemRepository;

    public List<PlaylistDto> findPlaylistsByUserId(String userId){
        List<Playlist> pls = playlistRepository.findByUserId(userId);
        List<PlaylistDto> dtoList = new ArrayList();
        for (Playlist pl : pls){
            PlaylistDto dto = new PlaylistDto();
            dto.setId(pl.getId());
            dto.setUserId(pl.getUserId());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public PlaylistDto getPlaylistById(String id) {
        Playlist pl = playlistRepository.findById(id).get();
        PlaylistDto playlistDto = new PlaylistDto();
        playlistDto.setId(pl.getId());
        playlistDto.setUserId(pl.getUserId());
        List<PlaylistItemDto> items = new ArrayList();
        playlistDto.setItems(items);
        return playlistDto;
    }

    public void postPlayList(PlaylistDto playlistDto) {
        Playlist playlist = new Playlist();
        playlist.setId(UUID.randomUUID().toString());
        List<String> playlistItems = new ArrayList<>();
        for (PlaylistItemDto itemDto : playlistDto.getItems()){
            playlistItems.add(itemDto.getId());
        }        
        playlist.setPlaylistItems(playlistItems);
        playlistRepository.save(playlist);
    }

    public void putPlaylist(PlaylistDto playlistDto) {
        Playlist playlist = new Playlist();
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
