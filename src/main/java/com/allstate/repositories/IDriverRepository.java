package com.allstate.repositories;

import com.allstate.entities.Driver;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by localadmin on 01/02/17.
 */
public interface IDriverRepository extends CrudRepository<Driver,Integer> {
}
