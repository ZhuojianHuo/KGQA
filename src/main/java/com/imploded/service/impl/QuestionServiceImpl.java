package com.imploded.service.impl;

import com.imploded.core.CoreProcesor;
import com.imploded.respository.QuestionRepository;
import com.imploded.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *<p>核心问答业务实现类</p>
 *
 * @author H
 * @version V.1.0.0
 * @date 2021/5/24
 */
@Service
@Primary
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CoreProcesor coreProcesor;

    @Override
    public String answer(String question) throws Exception{

        return null;
    }
}
