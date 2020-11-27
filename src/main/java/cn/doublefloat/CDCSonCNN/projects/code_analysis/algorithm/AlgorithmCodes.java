package cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.cnn.CNNAnalysis;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.utils.InputStreamUtil.InputStreamRunnable;
import cn.doublefloat.CDCSonCNN.projects.system.domain.vo.code_anlysis.SimilarityCodeList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 魏荣轩
 * @date 2020/11/5 16:56
 */
public class AlgorithmCodes implements CNNAnalysis {
    public AlgorithmCodes(){ }
    private String pythonPath = "code_analysis_py/cnn/CNNSimilarity.py",
        pythonExe = "D:\\pythonProject\\venv\\Scripts\\python.exe",
        modelPath = "code_analysis_py\\cnn";
    /**
     * 获取输出流
     *
     * @param arg 参数
     * @param model 模型参数
     * @return 输出流
     */
    public List<String> getPythonOut(String arg, String model) throws IOException {
        try {
            Resource resource = new ClassPathResource(pythonPath);
            String commandPath = resource.getFile().getAbsolutePath();
            model = new ClassPathResource(modelPath).getFile().getAbsoluteFile()+"\\"+model;
            String[] cmdArray = new String[] {pythonExe, commandPath, arg, model};
            return getStrings(cmdArray);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * 获取输出流
     *
     * @param args1 参数1
     * @param args2 参数2
     * @return 输出流
     */
    public List<String> getPythonOut(String args1,String args2, String model){
        try {
            Resource resource = new ClassPathResource(pythonPath);
            String commandPath = resource.getFile().getAbsolutePath();
            model = new ClassPathResource(modelPath).getFile().getAbsoluteFile()+"\\"+model;
            String[] cmdArray = new String[] {pythonExe, commandPath, args1, args2, model};
            return getStrings(cmdArray);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * 整合函数
     *
     * @param cmdArray 获取cmd输出
     * @return List
     * @throws IOException 错误
     */
    private List<String> getStrings(String[] cmdArray) throws IOException, InterruptedException {
        BufferedReader bReader = null;
        InputStreamReader sReader = null;
        Process process = Runtime.getRuntime().exec(cmdArray);

        /* 为"错误输出流"单独开一个线程读取之,否则会造成标准输出流的阻塞 */
        Thread t = new Thread(new InputStreamRunnable(process.getErrorStream(), "ErrorStream"));
        t.start();

        /* "标准输出流"就在当前方法中读取 */
        BufferedInputStream bis = new BufferedInputStream(process.getInputStream());
        sReader = new InputStreamReader(bis, "utf-8");
        bReader = new BufferedReader(sReader);
        StringBuilder sb = new StringBuilder();
        String line;
        List<String> returnedLine = new ArrayList<>();
        while ((line = bReader.readLine()) != null) {
            returnedLine.add(line);
        }
        bReader.close();
        process.destroy();
        return returnedLine;
    }

    /**
     * 获取CNN代码相似度
     *
     * @param code1 代码1
     * @param code2 代码2
     * @return 相似度
     */
    public double getSimilarityByPython(String code1, String code2, String model){
        code1 = code1.replaceAll(" ","~");
        code2 = code2.replaceAll(" ","~");
        List<String> outPutString = getPythonOut(code1,code2,model);
        for(String line : outPutString){
            if (line.contains("Similarity")){
                return Double.parseDouble(line.split(": ")[1].replaceAll("}",""));
            }
        }
        return -1;
    }
    /**
     * 获取所有其它代码的相似度 - 卷积神经网络查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getCNNCompareSimilarity(String codeFile){
        //遍历所有代码文件获取相似度文件集合
        //do something
        //预留cnn返回结果生成SimilarityCodeList对象并返回
        return new SimilarityCodeList();
    }

    /**
     * 获取超过阀值相似度的所有代码列表 - 卷积神经网络查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @param threshold 阀值
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getCNNOverThresholdCodeFile(String codeFile, double threshold){
        //do something
        return new SimilarityCodeList();
    }

    /**
     * 获取所有代码相似度 - 普通算法查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getDefaultCompareSimilarity(String codeFile){
        //do something
        return new SimilarityCodeList();
    }

    /**
     * 获取所有超过指定阀值的相似代码 - 普通算法查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @param threshold 阀值
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getDefaultOverThresholdCodeFile(String codeFile, double threshold){
        //do something
        return new SimilarityCodeList();
    }

    /**
     * 获取两个代码文件的相似度 - 卷积神经网络
     *
     * @param codeFile1 代码1
     * @param codeFile2 代码2
     * @return 相似度 0-1
     */
    public double getCNNSimilarity(String codeFile1, String codeFile2){

        return 0D;
    }

    /**
     * 获取两个代码文件的相似度 - 普通算法查重
     *
     * @param codeFile1 代码1
     * @param codeFile2 代码2
     * @return 相似度 0-1
     */
    public double getDefaultSimilarity(String codeFile1, String codeFile2){

        return 0D;
    }
}
