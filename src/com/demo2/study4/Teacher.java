package com.demo2.study4;

public class Teacher {
    public void checkScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
//            throw new ScoreException();
            throw new ScoreException("你给的分数有误，请输入1-100之间");
        } else {
            System.out.println("分数正常");
        }
    }
}
