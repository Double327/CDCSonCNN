package cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.duplicateRemovalAnlysis;

import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.duplicateRemovalAnlysis.abstractCompare.AbstractCompare;
import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.duplicateRemovalAnlysis.algorithmUtils.DelComments;
import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.duplicateRemovalAnlysis.algorithmUtils.LD;
import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.utils.TxtUtils;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author 魏荣轩
 * @date 2020/10/27 23:54
 */
public class CodesCompare extends AbstractCompare {
    private HashSet<String> keyWordSet = new HashSet<String>();
    private LD ld = new LD();
    public CodesCompare(){
        /**
         * C++关键字
         */
        String keyWords = "and|asm|auto|bad_cast|bad_typeid|bool|break|case|catch|char|class|const|const_cast" +
                "|continue|default|delete|do|double|dynamic_cast|else|enum|except|explicit|extern|false|finally|float|for" +
                "|friend|goto|if|inline|int|long|mutable|namespace|new|operator|or|private|protected|public|register|reinterpret_cast" +
                "|return|short|signed|sizeof|static|static_cast|struct|switch|template|this|throw|true|try|type_info|typedef" +
                "|typeid|typename|union|unsigned|using|virtual|void|volatile|wchar_t|while";
        String[] list = keyWords.split("\\|");
        Collections.addAll(keyWordSet, list);
    }
    private String delVariables(String code){
        code = "   "+code+"  ";
        int pos1 = 0,pos2=0;
        int len = code.length();
        boolean isVariables=false;
        StringBuilder ret = new StringBuilder();
        while(pos1<len){
            pos2++;
            if(isVariables){
                if("".equals(code.substring(pos2,pos2+2).replaceAll("[0-9a-zA-Z_][^a-zA-Z_]", ""))){
                    isVariables = false;
                    String vv = code.substring(pos1,pos2+1);
                    if(this.keyWordSet.contains(vv)){
                        ret.append(vv);
                    }
                    pos1 = pos2+1;
                }
            }else{
                if("".equals(code.substring(pos2,pos2+2).replaceAll("[^._a-zA-Z][_a-zA-Z]", ""))){
                    isVariables = true;
                    ret.append(code, pos1, pos2+1);
                    pos1 = pos2+1;
                }
            }
            if(pos2 == len-2){
                break;
            }
        }
        return ret.toString().trim();
    }

    /**
     * 重写获取预处理代码段方法
     * @param filePath 文件路径
     * @return 代码
     */
    @Override
    public String getPreProcessedCode(String filePath) {
        String code="";
        try{
            StringBuffer buf = TxtUtils.readTxtFile(filePath);
            //删除所有注释
            code = DelComments.delComments(buf.toString());
            int pos1 = 0,pos2 = 0;
            int len = code.length();
            boolean isString = false;
            StringBuilder ret = new StringBuilder();
            while(pos1<len){
                pos2++;
                if(isString){
                    if(pos2<len-1){
                        if("\"".equals(code.substring(pos2, pos2+1)) && !"\\".contentEquals(code.subSequence(pos2-1, pos2))){
                            isString  = false;
                            ret.append(delVariables(code.substring(pos1, pos2+1)));
                            pos1 = pos2+1;
                        }
                    }else{
                        break;
                    }
                }else{
                    if(pos2<len-1){
                        if("\"".equals(code.substring(pos2, pos2+1))){
                            isString  = true;
                            ret.append(delVariables(code.substring(pos1, pos2)));
                            pos1 = pos2;
                        }
                    }else{
                        ret.append(delVariables(code.substring(pos1, code.length())));
                        break;
                    }
                }
            }
            code = ret.toString();
            //删除所有空格和换行
            code=code.replaceAll("\\s", "");
        }catch(Exception e){
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 重新相速度提取方法
     *
     * @param code1 代码1
     * @param code2 代码2
     * @return 相似度
     */
    @Override
    public double getSimilarity(String code1, String code2) {
        return 1-ld.ld(code1, code2)*1.0 / Math.max(code1.length(), code2.length());
    }

    /**
     * 获取两个代码文本相似度
     *
     * @param codeFile1Path 代码文本1地址
     * @param codeFile2Path 代码文本2地址
     * @return 相似度百分
     */
    public static double getCodesSimilarity(String codeFile1Path, String codeFile2Path){
        CodesCompare cmp = new CodesCompare();
        return cmp.getSimilarity(cmp.getPreProcessedCode(codeFile1Path),cmp.getPreProcessedCode(codeFile2Path));
    }
}
