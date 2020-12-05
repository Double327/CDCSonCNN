package cn.doublefloat.CDCSonCNN.common.exception.file;


import cn.doublefloat.CDCSonCNN.common.exception.BaseException;

/**
 * @className: FileException
 * @description: file exception class
 * @author: Dimple
 * @date: 10/22/19
 */
public class FileException extends BaseException {

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
