package com.free.freevideostreamingapi.recommendation;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecommendationRepository extends CassandraRepository<Recommendation,String> {



}
