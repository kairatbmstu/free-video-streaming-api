package com.free.freevideostreamingapi.infrastucture.rest.controller;


import com.free.freevideostreamingapi.application.dto.PlaylistDto;
import com.free.freevideostreamingapi.domain.model.Playlist;
import com.free.freevideostreamingapi.infrastucture.entity.PlaylistEntity;
import com.free.freevideostreamingapi.infrastucture.entity.UserEntity;
import com.free.freevideostreamingapi.infrastucture.repository.PlaylistItemRepository;
import com.free.freevideostreamingapi.infrastucture.repository.PlaylistRepository;
import com.free.freevideostreamingapi.service.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("/api/v1")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/playlists")
    public List<PlaylistEntity> getAllPlaylist() {
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            return playlistService.findPlaylistsByUserId(user.getId());
        }

        return Collections.emptyList();
    }

    @GetMapping("/playlists/{id}")
    public void getPlaylistById(@PathVariable String id) {
        
    }

    @PostMapping("/playlists")
    public void postPlayList(@RequestBody PlaylistDto playlistDto) {
        playlistService.postPlayList(playlistDto);
    }

    @PutMapping("/playlists")
    public void putPlaylist(@RequestBody PlaylistDto playlistDto) {
        playlistService.putPlaylist(playlistDto);
    }

    @DeleteMapping("/playlists/{id}")
    public void deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylistId(id);
    }


    @GetMapping("/playlists/{id}/items")
    public void getPlaylistItems() {

    }

    @PostMapping("/playlists/{id}/items")
    public void addPlaylistItem() {

    }

    @DeleteMapping("/playlists/{id}/items/{itemId}")
    public void deletePlaylistItem() {

    }

    @PutMapping("/playlists/{id}/items/{itemId}")
    public void updatePlaylistItem() {

    }

}
