package com.imploded.service.impl;

import com.imploded.core.CoreProcessor;
import com.imploded.respository.QuestionRepository;
import com.imploded.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *<p>核心问答业务实现类</p>
 *
 * @author H
 * @version V.1.0.0
 * @date 2021/5/24
 */

@Component
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CoreProcessor queryProcess;

    @Override
    public String answer(String question) throws Exception{

        List<String> reStrings = queryProcess.analysis(question);
        Integer modelIndex = Integer.valueOf(reStrings.get(0));
        String answer =null;

        switch(modelIndex){
            case 0:
                answer = getCompanyBusinessScope(reStrings);
                break;
            case 1:
                answer = getCompanyOfficeAddress(reStrings);
                break;
            case 2:
                answer = getCompanyIndustryName(reStrings);
                break;
            case 3:
                answer = getCompanyShareholderName(reStrings);
                break;
            case 4:
                answer = getShareholderResume(reStrings);
                break;
            case 5:
                answer = getCompanyEstablishDate(reStrings);
                break;
            case 6:
                answer = getCompanyWebsite(reStrings);
                break;
            case 7:
                answer = getCompanyStockPrice(reStrings);
                break;
            case 8:
                answer = getCompanyStockName(reStrings);
                break;
            case 9:
                answer = getCompanyStockVol(reStrings);
                break;
            case 10:
                answer = getCompanySymbol(reStrings);
                break;
            default:
                break;
        }
        System.out.println(answer);
        if (answer != null && !"".equals(answer) && !("\\N").equals(answer)) {
            return answer;
        } else {
            return "对不起,没有找到你想要的答案";
        }
    }

    private String getCompanyOfficeAddress(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String address = questionRepository.getCompanyOfficeAddress(name);
        if (address != null) {
            answer = address;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getCompanyBusinessScope(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String scope = questionRepository.getCompanyBusinessScope(name);
        if (scope != null) {
            answer = scope;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getCompanyIndustryName(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String industryName = questionRepository.getCompanyIndustryName(name);
        if (industryName != null) {
            answer = industryName;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getCompanyShareholderName(List<String> reStrings){
        String name,ctb;
        String answer;
        name = reStrings.get(1);
        ctb = reStrings.get(2);
        List<String> shareholderName = questionRepository.getCompanyShareholderName(name,ctb);

        if (shareholderName.size() == 0) {
            answer = null;
        } else {
            answer = shareholderName.toString().replace("[", "").replace("]", "");
        }
        return answer;
    }

    private String getShareholderResume(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        List<String> resume = questionRepository.getShareholderResume(name);

        if (resume.size() == 0) {
            answer = null;
        } else {
            answer = resume.toString().replace("[", "").replace("]", "");
        }
        return answer;
    }

    private String getCompanyEstablishDate(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String establishDate = questionRepository.getCompanyEstablishDate(name);
        if (establishDate != null) {
            answer = establishDate;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getCompanyWebsite(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String website = questionRepository.getCompanyWebsite(name);
        if (website != null) {
            answer = website;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getCompanyStockName(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String symbol = questionRepository.getCompanySymbol(name);
        String stockName = questionRepository.getCompanyStockName(symbol);
        if (stockName != null) {
            answer = stockName;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getCompanyStockPrice(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String symbol = questionRepository.getCompanySymbol(name);
        String price = questionRepository.getCompanyStockPrice(symbol);
        if (price != null) {
            answer = price;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getCompanyStockVol(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String symbol = questionRepository.getCompanySymbol(name);
        String vol = questionRepository.getCompanyStockVol(symbol);
        if (vol != null) {
            answer = vol ;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getCompanySymbol(List<String> reStrings){
        String name;
        String answer;
        name = reStrings.get(1);
        String symbol = questionRepository.getCompanySymbol(name);
        if (symbol != null) {
            answer = symbol;
        } else {
            answer = null;
        }
        return answer;
    }
}
