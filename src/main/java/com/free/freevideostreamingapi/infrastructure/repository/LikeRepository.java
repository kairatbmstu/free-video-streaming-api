package com.free.freevideostreamingapi.infrastructure.repository;

import com.free.freevideostreamingapi.domain.model.Like;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CassandraRepository<Like,String> {

    Like findFirstByUserIdAndVideoId(String userId, String videoId);

    Like findFirstByUserIdAndCommentId(String userId, String commentId);
}
