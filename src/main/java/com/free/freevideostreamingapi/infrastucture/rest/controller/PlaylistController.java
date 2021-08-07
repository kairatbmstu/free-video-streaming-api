package com.free.freevideostreamingapi.infrastucture.rest.controller;


import com.free.freevideostreamingapi.infrastucture.entity.PlaylistEntity;
import com.free.freevideostreamingapi.infrastucture.entity.UserEntity;
import com.free.freevideostreamingapi.infrastucture.repository.PlaylistItemRepository;
import com.free.freevideostreamingapi.infrastucture.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
public class PlaylistController {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    PlaylistItemRepository playlistItemRepository;

    @GetMapping("/playlists")
    public void getAllPlaylist() {
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            List<PlaylistEntity> playlists =  playlistRepository.findByUserId(user.getId());
        }
    }

    @GetMapping("/playlists/{id}")
    public void getPlaylist() {

    }

    @PostMapping("/playlists")
    public void postPlayList() {

    }

    @PutMapping("/playlists")
    public void putPlaylist() {

    }

    @DeleteMapping("/playlists/{id}")
    public void deletePlaylist() {

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