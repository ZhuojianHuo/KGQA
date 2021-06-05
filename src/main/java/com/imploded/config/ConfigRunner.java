package com.imploded.config;

import com.imploded.utils.CustomDictWordUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * 全局配启动 -- 初始化项目时，执行命令，将相关额外的自定义词典加载下
 *
 */
@Component
public class ConfigRunner implements CommandLineRunner {
    @Value("${HanLP.CustomDictionary.path.companyDict}")
    private String companyDictPath;


    @Value("${HanLP.CustomDictionary.path.positionDict}")
    private String positionDictPath;

    @Value("${HanLP.CustomDictionary.cache.path}")
    private String cacheDictPath;

    @Override
    public void run(String... args){

        //先删除缓存
        File file = new File(cacheDictPath);
        if(file.exists()){
            file.delete();
            System.out.println("CustomDictionary.txt.bin delete success .");
        }

        /**加载自定义的【公司】字典 == 设置词性 nc 0*/
        loadDict(companyDictPath,0);

        /**加载自定义的【职位】字典 == 设置词性 np 0*/
        loadDict(positionDictPath,1);


    }

    /**
     * 加载自定义词性字典
     * @param path 字典路径
     * @param type 类型
     */
    public void loadDict(String path,Integer type) {
        File file = new File(path);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            addCustomDictionary(br, type);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    /**
     * 添加自定义分词及其词性，注意数字0表示频率，不能没有
     *
     * @param br 字节流（读）
     * @param type 字典类型
     */
    public void addCustomDictionary(BufferedReader br, int type) {

        String word;
        try {
            while ((word = br.readLine()) != null) {
                switch (type) {
                    /**设置公司名词词性 == nc 0*/
                    case 0:
                        CustomDictWordUtils.setNatureAndFrequency(word,"nc 0",true);
                        break;
                    /**设置公司职位词性 == np 0*/
                    case 1:
                        CustomDictWordUtils.setNatureAndFrequency(word,"np 0",true);
                        break;
                    default:
                        break;
                }
            }
            br.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
