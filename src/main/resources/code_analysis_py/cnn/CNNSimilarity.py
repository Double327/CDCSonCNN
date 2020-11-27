# python file
# -*- coding: utf-8 -*-
# @Time : 2020/11/20 23:49
# @Author : 魏荣轩
# @Desc: 基于Word2Vec训练词向量,通过cnn实现查重
# @File : CNNSimilarity.py
# @Software: PyCharm
import sys
import gensim.models.word2vec as w2v


# cnn池化层，采用max-pooling方式实现池化，参数表示输入矩阵
def cnn_pooling(dict_pooling):
    rows = len(dict_pooling[1])
    columns = len(dict_pooling)
    result = [[0 for col in range(rows - 1)] for row in range(columns - 1)]  # python构造的二维列表
    for i in range(columns - 1):
        for j in range(rows - 1):
            re = max(dict_pooling[i][j], dict_pooling[i][j + 1], dict_pooling[i + 1][j],
                     dict_pooling[i + 1][j + 1])  # max-pooling方法实现池化
            result[i][j] = re
    return result


# CNN卷积层,卷积核的感受野为2*2，参数表示一个输入词向量矩阵
def cnn_folding(dict_word_vec):
    rows = len(dict_word_vec[1])  # 获取输入矩阵的横向长度
    columns = len(dict_word_vec)  # 获取输入矩阵的纵向长度
    result = [[0 for col in range(rows - 1)] for row in range(columns - 1)]  # 返回结果集
    for i in range(columns - 1):  # 通过循环实现整个矩阵的运算
        for j in range(rows - 1):
            re = (dict_word_vec[i][j] + dict_word_vec[i][j + 1] + dict_word_vec[i + 1][j] +
                  dict_word_vec[i + 1][j + 1]) / 4  # 实现卷积层的运算，这里卷积核默认是[[1,1],[1,1]]
            result[i][j] = re
    dict_word_vec = result
    return result


# CNN获取输入层数据，其中三个参数分别表示输入短文本，进行比较的对象短文本，所使用的word2vec所构建的模型。
def get_input_data(input_sen, compare_sen, word_vec_model):
    score = []  # 记分器
    word_vec_table = []  # 将要返回词向量矩阵
    key_word = input_sen.split(" ")  # 不去除重复值
    # key_word = analyse.extract_tags(input_sen)  # 获取关键词 去除重复值
    # print(key_word)
    test_word = compare_sen.split(" ")  # 不去除重复值
    #  test_word = analyse.extract_tags(compare_sen)
    # print(test_word)
    for i in key_word:
        for j in test_word:
            try:
                sim = word_vec_model.similarity(i, j)  # 获取词之间的相似度
                score.append(sim)
            except Exception as err:
                pass
        if len(score) == 0:
            pass
        else:
            word_vec_table.append(score)  # 构建词向量矩阵
        score = []
    return word_vec_table  # 返回词向量矩阵


# 实现卷积层和池化层的连接层
def pooling_folding(matrix):
    res = []
    data_list = matrix
    while 1:  # 交替实现卷积层和池化层
        r = len(data_list[0])
        c = len(data_list)
        if r == 1 or c == 1:  # 判定池化层跳出循环条件
            for i in range(len(data_list)):
                for j in data_list[i]:
                    res.append(j)
            break
        pool = cnn_pooling(data_list)  # 实现池化层
        if len(pool) == 1 or len(pool[1]) == 1:  # 判定卷积层跳出循环的条件
            data_list = pool
            for i in range(len(data_list)):
                for j in data_list[i]:
                    res.append(j)
            break
        else:
            fold = cnn_folding(pool)  # 实现卷积层
            data_list = fold
            pool = [[0 for col in range(r - 1)] for row in range(c - 1)]
            fold = [[0 for col in range(r - 1)] for row in range(c - 1)]
    return res


def main(arg):
    sim_dict = {}
    code1 = arg[0].replace('~', ' ')
    code2 = arg[1].replace('~', ' ')
    model = w2v.Word2Vec.load(arg[2])
    matrix = get_input_data(code1, code2, model)
    sim_res = pooling_folding(matrix)
    sim_score = sum(sim_res) / len(sim_res)
    sim_dict.update({'Similarity': sim_score})
    print(sim_dict)


if __name__ == '__main__':
    args = []
    print('成功执行!')
    for i in range(1, len(sys.argv)):
        args.append(sys.argv[i])
    main(args)
    # code1 = 'vars int vars if vars 0 else vars max return vars M920 D25 java2 windows GDIWindowSurfaceData util Arrays public vars class vars 66 public vars'
    # code2 = 'class vars 53 public vars static vars void vars int vars new vars int vars 2 1 3 4 1 2 1 5 4 out println public vars static vars int vars int'
