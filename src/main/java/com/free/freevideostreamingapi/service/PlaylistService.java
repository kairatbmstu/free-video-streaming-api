package com.free.freevideostreamingapi.service;

import java.util.List;

import com.free.freevideostreamingapi.entity.Playlist;
import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.repository.PlaylistItemRepository;
import com.free.freevideostreamingapi.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    PlaylistItemRepository playlistItemRepository;

    public void getAllPlaylist() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            List<Playlist> playlists =  playlistRepository.findByUserId(user.getId());
        }
    }

    public void getPlaylist() {

    }

    public void postPlayList() {

    }

    public void putPlaylist() {

    }

    public void deletePlaylist() {

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
