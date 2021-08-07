package com.free.freevideostreamingapi.infrastucture.repository;

import com.free.freevideostreamingapi.infrastucture.entity.RecommendationEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecommendationRepository extends CassandraRepository<RecommendationEntity,String> {



}
