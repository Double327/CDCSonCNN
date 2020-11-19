package cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.cnn.pretreatment;

import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.utils.DelComments;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.utils.DelVariables;
import com.sun.org.apache.regexp.internal.RE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 魏荣轩
 * @date 2020/11/17 17:12
 */
public class CodeVectorTools {
    /**
     * 获取当前代码段的向量值
     *
     * @param code 代码
     * @return 向量参数
     */
    public static String getCodeVector(String code){
        //do something
        return "";
    }

    /**
     * 对代码进行预处理
     *
     * @param code 代码原文本
     * @return 处理后的分词文本
     */
    public static String getCodePretreatmentAsString(String code){
        //删除注释
        code = DelComments.delComments(code);
        //将所有变量替换为指定字符
        code = DelVariables.delVariables(code,"VARS","VARS");
        //删除所有符号并分词
        code = code.replaceAll( "[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , " ");
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(code);
        return m.replaceAll(" ");
    }
}
