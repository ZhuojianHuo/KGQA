package com.imploded.respository;

import com.imploded.model.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends Neo4jRepository<Company,Long> {

    List<Company> findByName(@Param("name") String name);

    @Query("match(n:Person)-[:actedin]->(m:Company) where n.name='孙俊英' return m.name")
    List<String> getCompanyName();

}
