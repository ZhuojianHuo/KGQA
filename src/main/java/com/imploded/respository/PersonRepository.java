package com.imploded.respository;

import com.imploded.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person,Long> {
    List<Person> findByName(@Param("name") String name);
}
