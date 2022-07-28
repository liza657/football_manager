package com.example.football_manager_web.repository;

import com.example.football_manager_web.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface TeamRepository extends CrudRepository<Team, Integer> {


}
