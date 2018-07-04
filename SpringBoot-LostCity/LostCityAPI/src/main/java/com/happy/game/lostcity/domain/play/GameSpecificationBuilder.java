package com.happy.game.lostcity.domain.play;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.happy.game.lostcity.common.SearchBean;

public class GameSpecificationBuilder {
	
private final List<SearchBean> params;
	
	public GameSpecificationBuilder() {
		params = new ArrayList<SearchBean>();
	}

	public GameSpecificationBuilder with(String key, String operation, Object value) {
		params.add(new SearchBean(key, operation, value));
		return this;
	}

	public Specification<GameEntity> build() {
		if (params.size() == 0) {
			return null;
		}

		Specification<GameEntity> result = null;
		boolean isFirst = true;
		for (SearchBean param : params) {
			if(isFirst) {
				result = new GameSpecification(param);
				isFirst = false;
			}else {
				if(param.getKey().equals("datasSid")) {
					result = Specification.where(result).or(new GameSpecification(param));
				}else {
					result = Specification.where(result).and(new GameSpecification(param));
				}
			}
		}

		return result;
	}

}
