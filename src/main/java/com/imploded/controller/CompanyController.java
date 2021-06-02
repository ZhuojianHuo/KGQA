package com.imploded.controller;

import com.imploded.model.Company;
import com.imploded.respository.CompanyRepository;
import com.imploded.result.ResponseMessage;
import com.imploded.result.ResponseResult;
import com.imploded.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/rest/imploded/company")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    /**
     * 根据公司查询公司实体
     * @param name
     * @return
     */
    @RequestMapping("/get")
    public List<Company> getCompany(@RequestParam(value="name") String name){
        return companyRepository.findByName(name);
    }

    /**
     * 创建一个公司节点
     * @param company
     * @return
     */
    @PostMapping("/save")
    public ResponseResult saveCompany(@RequestBody Company company){
        companyRepository.save(company);
        return new ResponseResult(ResponseMessage.OK);
    }


    @RequestMapping("/query")
    public ResponseResult queryCompanyTiles(){
        List<String> companyTiles = companyRepository.getCompanyName();
        ResultData<String> result = new ResultData<String>(ResponseMessage.OK, companyTiles);
        return new ResponseResult(result);
    }
}
