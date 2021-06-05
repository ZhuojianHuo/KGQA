package com.imploded.respository;

import com.imploded.model.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * 基于金融领域智能问答系统的查询接口
 * @author H
 * @version V.1.0.0
 * @date 2021/05/24
 *
 */
@Repository
public interface QuestionRepository extends Neo4jRepository<Company,Long> {

    /**
     * 0.对应问题模板0 == nc(公司)公司业务范围
     *
     * @param name 公司名称
     * @return 返回公司主要业务
     */
    @Query("match(n:Corporation) where n.name=$name return n.businessScope")
    String getCompanyBusinessScope(@Param("name") String name);


    /**
     *
     *  1 对应问题模板1 == nc(公司) 公司地址
     *  @param name 公司名称
     *  @return 返回公司地址
     */
    @Query("match(n:Corporation) where n.name=$name return n.officeAddress")
    String getCompanyOfficeAddress(@Param("name") String name);

    /**
     *
     *  2 对应问题模板2 == nc(公司) 公司类型
     *  @param name 公司名
     *  @return 返回公司类型
     */
    @Query("match(n:Corporation) where n.name=$name return n.industryName")
    String getCompanyIndustryName(@Param("name") String name);


    /**
     *  3 对应问题模板3 == nc(公司) 公司股东分布
     *   @param name 公司名
     *   @param ctb 职位
     *   @return 返回公司股东
     */
    @Query("match(n:Person)-[r]-(b:Corporation) where b.name=$name and type(r)=$ctb return distinct n.name")
    List<String> getCompanyShareholderName(@Param("name") String name,@Param("ctb") String ctb);

    /**
     * 4 对应问题模板4 == nr(person) 股东信息
     * @param name 股东名
     * @return 返回信息
     */
    @Query("match(n:Person) where n.name=$name return n.resume")
    List<String> getShareholderResume(@Param("name") String name);

    /**
     * 5 对应问题模板5 == nc(公司) 公司成立时间
     * @param name 公司名
     * @return 返回公司成立时间
     */
    @Query("match(n:Corporation) where n.name=$name return n.establishDate")
    String getCompanyEstablishDate(@Param("name") String name);

    /**
     * 6 对应问题模板6 == nc(公司) 公司网址
     * @param name 公司名
     * @return 返回公司网址
     */

    @Query("match(n:Corporation) where n.name=$name return n.website")
    String getCompanyWebsite(@Param("name") String name);

    /**
     * 7 对应问题模板7 == nc(公司) 公司股票价格
     * @param name 公司名
     * @return 返回公司股票价格
     */


}
