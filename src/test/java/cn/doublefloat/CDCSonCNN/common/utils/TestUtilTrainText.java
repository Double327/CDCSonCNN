package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.cnn.pretreatment.CodeVectorTools;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.utils.TxtFileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 魏荣轩
 * @date 2020/11/20 14:07
 */
public class TestUtilTrainText {
    @Test
    void createTrainTextByCodeFile() throws IOException {
        String codePath = "codes/JavaFile";
        Resource resource = new ClassPathResource(codePath);
        File baseFile = resource.getFile();
        File[] files = baseFile.listFiles();
        StringBuilder preCodes = new StringBuilder();
        for(File file : files){
            if(file.exists() && file.isFile()){
                preCodes.append(CodeVectorTools.getCodePretreatmentAsString(
                        TxtFileUtils.readTxtFile(codePath + "/" + file.getName()).toString()));
            }
        }
        FileWriter fileWriter = new FileWriter("D:\\代码\\语料\\语料.txt",false);
        fileWriter.write(preCodes.toString().replaceAll("\\?"," "));
        fileWriter.flush();
        fileWriter.close();
    }
}
