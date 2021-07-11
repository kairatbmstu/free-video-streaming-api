package com.free.freevideostreamingapi.comments;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CassandraRepository<Comment, String> {



}
