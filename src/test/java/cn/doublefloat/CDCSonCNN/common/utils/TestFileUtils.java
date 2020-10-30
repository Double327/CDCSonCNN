package cn.doublefloat.CDCSonCNN.common.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author 李广帅
 * @date 2020/10/30 2:24 下午
 */
@SpringBootTest
public class TestFileUtils {

    @Value("${project.path}")
    private String filePath;

    @Test
    public void testSaveFile() {
        File file = new File("/Users/liguangshuai/Desktop/SpringBoot经典学习笔记.md");
        try {
            System.out.println(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            String fileId = FileUtils.saveFile(fileInputStream, filePath, file.getName());
            System.out.println(fileId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
