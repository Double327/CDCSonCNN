package cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.other_old_analysis.winnowing;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 魏荣轩
 * @date 2020/11/17 23:39
 */
public class PyWinnowing {
    public static String getPythonWinnowingResult(String code){
        try {
            String exe = "python";
            Resource resource = new ClassPathResource("code_anlysis_py/Winnowing.py");
            String command = resource.getFile().getAbsolutePath();
            String[] cmdArr = new String[] { exe, command , code };
            Process process = Runtime.getRuntime().exec(cmdArr);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line,returnedLine = "";
            while( ( line = in.readLine() ) != null ) {
                returnedLine+=line;
            }
            in.close();
            return returnedLine;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
