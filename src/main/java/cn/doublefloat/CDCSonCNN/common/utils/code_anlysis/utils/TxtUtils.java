package cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.utils;

import cn.doublefloat.CDCSonCNN.common.exception.CustomException;
import com.sun.deploy.util.SyncFileAccess;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author 魏荣轩
 * @date 2020/10/16 22:32
 */
public class TxtUtils {
    /**
     * 读取TXT文件内容
     *
     * @param filePath 文件地址
     */
    public static StringBuffer readTxtFile(String filePath)  {
        InputStream readFileStream = null;
        Reader reader = null;
        try {
            Resource resource = new ClassPathResource(filePath);
            if(resource.isFile() && resource.exists()){
                //ClassPathResource classPathResource = new ClassPathResource(filePath);
                readFileStream =resource.getInputStream();
                reader = new InputStreamReader(readFileStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(reader);
                StringBuffer returnString = new StringBuffer();
                while(bufferedReader.readLine() != null){
                    returnString.append(bufferedReader.readLine());
                }
                readFileStream.close();
                reader.close();
                bufferedReader.close();
                return returnString;
            }else{
                throw new CustomException("找不到指定的文件:"+filePath);
            }
        } catch (IOException e) {
            throw new CustomException("读取文件内容出错:"+e.toString());
        }
    }
}
