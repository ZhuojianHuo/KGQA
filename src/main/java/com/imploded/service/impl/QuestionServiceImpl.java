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
        String name;

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

    public String getCompanyOfficeAddress(List<String> reStrings){
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

    public String getCompanyBusinessScope(List<String> reStrings){
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

    public String getCompanyIndustryName(List<String> reStrings){
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
}
