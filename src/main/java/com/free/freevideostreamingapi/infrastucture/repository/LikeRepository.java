package com.free.freevideostreamingapi.infrastucture.repository;

import com.free.freevideostreamingapi.infrastucture.entity.LikeEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CassandraRepository<LikeEntity,String> {

    LikeEntity findFirstByUserIdAndVideoId(String userId, String videoId);

    LikeEntity findFirstByUserIdAndCommentId(String userId, String commentId);
}
