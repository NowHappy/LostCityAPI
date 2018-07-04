package com.happy.game.lostcity.common;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AppRepository extends PagingAndSortingRepository<AppEntity, Long>, JpaSpecificationExecutor<AppEntity> {
    AppEntity findByClientId(String client_id);
    
    AppEntity findBySidAndUsersSid(Long sid, Long usersSid);
    
    boolean existsByUsersSidAndName(Long usersSid, String name);
    
    boolean existsByUsersSid(Long usersSid);
}
