package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.common.exception.CustomException;

import java.io.*;

/**
 * @author 李广帅
 * @date 2020/10/30 2:16 下午
 */
public class FileUtils {

    /**
     * 保存文件
     *
     * @param fileInputStream 输入文件流
     * @param path            保存路径
     * @return 文件名
     */
    public static String saveFile(FileInputStream fileInputStream, String path, String fileName) {
        String fileId = IdUtils.randomUUID();
        if (StringUtils.isNull(path) || StringUtils.isEmpty(path)) {
            return null;
        }
        File file = new File(path);
        if (!file.exists()) {
            boolean mkdir = file.mkdirs();
            if (!mkdir) {
                throw new CustomException("系统保存文件失败!");
            }
        }
        OutputStream fileOutputStream = null;
        try {
            byte[] bs = new byte[1024];
            int len;
            fileOutputStream = new FileOutputStream(path + fileId + fileName);
            while ((len = fileInputStream.read(bs)) != -1) {
                fileOutputStream.write(bs, 0, len);
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        } finally {
            // 完毕，关闭所有链接
            try {
                fileOutputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileId + fileName;
    }
}
