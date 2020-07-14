package com.migration.web.pcftoopenshiftmongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.migration.web.model.PcftoOpenshiftRecords;

@Repository
public interface ApplicationRepository extends MongoRepository<PcftoOpenshiftRecords, String> {
}