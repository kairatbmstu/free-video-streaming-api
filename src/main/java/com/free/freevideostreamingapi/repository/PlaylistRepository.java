package com.free.freevideostreamingapi.repository;


import com.free.freevideostreamingapi.entity.Playlist;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends CassandraRepository<Playlist, String> {

    List<Playlist> findByUserId(String userId);

}
