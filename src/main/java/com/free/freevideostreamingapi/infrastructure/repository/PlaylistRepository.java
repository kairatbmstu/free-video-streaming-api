package com.free.freevideostreamingapi.infrastructure.repository;


import com.free.freevideostreamingapi.playlist.Playlist;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends CassandraRepository<Playlist, String> {

    List<Playlist> findByUserId(String userId);

}
