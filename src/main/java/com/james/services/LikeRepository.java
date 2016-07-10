package com.james.services;

import com.james.entities.Like;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jamesyburr on 7/10/16.
 */
public interface LikeRepository extends CrudRepository<Like, Integer> {
}
