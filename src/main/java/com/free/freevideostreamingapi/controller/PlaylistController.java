package com.free.freevideostreamingapi.controller;

import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.service.PlaylistService;
import com.free.freevideostreamingapi.dto.PlaylistDto;
import com.free.freevideostreamingapi.dto.PlaylistItemDto;
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
    public List<PlaylistDto> getAllPlaylist() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            return playlistService.findPlaylistsByUserId(user.getId());
        }
        return Collections.emptyList();
    }

    @GetMapping("/playlists/{id}")
    public PlaylistDto getPlaylistById(@PathVariable String id) {
        return playlistService.getPlaylistById(id);
    }

    @PostMapping("/playlists")
    public PlaylistDto postPlayList(@RequestBody PlaylistDto playlistDto) {
        playlistService.postPlayList(playlistDto);
        return playlistService.getPlaylistById(playlistDto.getId());
    }

    @PutMapping("/playlists")
    public PlaylistDto putPlaylist(@RequestBody PlaylistDto playlistDto) {
        playlistService.putPlaylist(playlistDto);
        return playlistService.getPlaylistById(playlistDto.getId());
    }

    @DeleteMapping("/playlists/{id}")
    public void deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylistId(id);
    }


    @GetMapping("/playlists/{id}/items")
    public List<PlaylistItemDto> getPlaylistItems(@PathVariable String id) {
        return playlistService.getPlaylistById(id).getItems();
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
