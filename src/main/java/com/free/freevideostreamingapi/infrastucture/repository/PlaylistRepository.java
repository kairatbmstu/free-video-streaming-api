package com.free.freevideostreamingapi.infrastucture.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.free.freevideostreamingapi.infrastucture.entity.PlaylistEntity;

@Repository
public interface PlaylistRepository extends CassandraRepository<PlaylistEntity, String> {

    List<PlaylistEntity> findByUserId(String userId);

}
