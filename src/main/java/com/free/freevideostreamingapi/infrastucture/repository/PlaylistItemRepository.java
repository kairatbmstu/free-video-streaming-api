package com.free.freevideostreamingapi.infrastucture.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.free.freevideostreamingapi.infrastucture.entity.PlaylistItemEntity;

@Repository
public interface PlaylistItemRepository extends CassandraRepository<PlaylistItemEntity,String> {

    List<PlaylistItemEntity> findByPlaylistIdOrderByPriority(String playlistId);

}
