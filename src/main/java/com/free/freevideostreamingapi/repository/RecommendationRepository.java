package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.Recommendation;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecommendationRepository extends CassandraRepository<Recommendation,String> {



}
