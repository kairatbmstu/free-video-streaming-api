package com.free.freevideostreamingapi.infrastructure.repository;

import com.free.freevideostreamingapi.recommendation.Recommendation;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecommendationRepository extends CassandraRepository<Recommendation,String> {



}
