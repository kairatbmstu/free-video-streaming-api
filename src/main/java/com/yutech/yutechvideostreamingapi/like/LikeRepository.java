package com.yutech.yutechvideostreamingapi.like;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends CassandraRepository<Like,String> {

    Like findFirstByUserIdAndVideoId(String userId, String videoId);

    Like findFirstByUserIdAndCommentId(String userId, String commentId);
}
