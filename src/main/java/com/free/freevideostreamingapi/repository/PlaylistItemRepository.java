package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.PlaylistItem;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistItemRepository extends CassandraRepository<PlaylistItem,String> {

    List<PlaylistItem> findByPlaylistIdOrderByPriority(String playlistId);

}
