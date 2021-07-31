package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.Comment;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CassandraRepository<Comment, String> {



}
