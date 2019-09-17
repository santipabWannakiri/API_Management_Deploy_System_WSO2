package com.api.deploy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.deploy.model.ApiModelH2;
import com.api.deploy.model.ApiModelResponseH2;

@Repository("APIRepository")
public interface APIRepository extends CrudRepository<ApiModelH2, Integer> {

}
