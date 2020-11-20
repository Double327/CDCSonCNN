

import sys

import gensim.models.word2vec as w2v


def train_model(model_file_name, train_word):
    # 模型训练，生成词向量
    sentences = w2v.LineSentence(train_word)
    model = w2v.Word2Vec(sentences, sg=1, size=100, window=5, min_count=5, negative=3, sample=0.001, hs=1,
                         workers=4, seed=0)
    model.save(model_file_name)
    print('True')


if __name__ == '__main__':
    model_file = sys.argv[1].split(":")[0]
    sentences_file = sys.argv[1].split(":")[1]
    train_model(model_file, sentences_file)
