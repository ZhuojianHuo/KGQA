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
     * 0.对应问题模板0 == nm(公司)公司业务范围
     *
     * @param name 公司名称
     * @return 返回公司主要业务
     */
    @Query("match(n:Company) where n.name={name} return n.businessScope")
    String getCompanyBusinessScope(@Param("name") String name);


    /**
     *
     *  1 对应问题模板1 == nm(公司) 公司地址
     *  @param name 公司名称
     *  @return 返回公司地址
     */
    @Query("match(n:Company) where n.name={name} return n.officeAddress")
    String getCompanyOfficeAddress(@Param("name") String name);

    /**
     *
     *  2 对应问题模板2 == nm(公司) 公司类型
     *  @param name 公司类型
     *  @return 返回公司类型
     */
    @Query("match(n:Company) where n.name={name} return n.industryName")
    String getCompanyIndustryName(@Param("name") String name);


    /**
     *  公司股东分布
     *
     */

    /**
     * 股票实时价格
     *
     */

    /**
     *  股票一周内的变化
     */

    /**
     *  某个人控股的公司
     */



}
