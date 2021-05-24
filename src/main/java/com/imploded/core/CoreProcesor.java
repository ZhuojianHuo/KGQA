package com.imploded.core;

import org.apache.spark.mllib.classification.NaiveBayesModel;

import java.util.Map;

/**
 * Spark贝叶斯分类器 + HanLP分词器 + 实现问题语句的抽象+模板匹配+关键性语句还原
 *
 * @author H
 * @date 2021/05/24
 */
public class CoreProcesor {

    /**指定问题question及字典的txt模板所在的根目录*/
    private String rootDirPath;

    /**Spark贝叶斯分类器*/
    private NaiveBayesModel nbModel;

    /**分类标签号和问句模板对应表*/
    private Map<Double, String> questionsPattern;

    /**词语和下标的对应表   == 词汇表*/
    private Map<String, Integer> vocabulary;

    /**关键字与其词性的map键值对集合 == 句子抽象*/
    private Map<String, String> abstractMap;

    /** 分类模板索引*/
    int modelIndex = 0;

}
