package com.yutech.yutechvideostreamingapi.comments;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CassandraRepository<Comment, String> {



}
