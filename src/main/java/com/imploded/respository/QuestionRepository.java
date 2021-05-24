package com.imploded.respository;

import com.imploded.model.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * 基于金融领域智能问答系统的查询接口
 * @author H
 * @version V.1.0.0
 * @date 2021/05/24
 *
 */
public interface QuestionRepository extends Neo4jRepository<Company,Long> {

    /**
     * 0.对应问题模板0 == 公司业务范围
     *
     * @param name 公司名称
     * @return 返回公司主要业务
     */
    @Query("match(n:Company) where n.name={name} return n.businessScope")
    String getCompanyBusinessScope(@Param("name") String name);

}
