package com.happy.game.lostcity.domain.play;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameRepository extends PagingAndSortingRepository<GameEntity, Long>, JpaSpecificationExecutor<GameEntity>{

}
