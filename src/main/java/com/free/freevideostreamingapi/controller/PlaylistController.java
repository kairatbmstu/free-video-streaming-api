package com.free.freevideostreamingapi.controller;

import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.service.PlaylistService;
import com.free.freevideostreamingapi.dto.PlaylistDto;
import com.free.freevideostreamingapi.entity.Playlist;
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
    public List<Playlist> getAllPlaylist() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
