package com.free.freevideostreamingapi.controller;


import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.repository.PlaylistItemRepository;
import com.free.freevideostreamingapi.repository.PlaylistRepository;
import com.free.freevideostreamingapi.entity.Playlist;
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            List<Playlist> playlists =  playlistRepository.findByUserId(user.getId());
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