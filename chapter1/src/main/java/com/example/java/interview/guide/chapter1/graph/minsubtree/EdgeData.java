package com.example.java.interview.guide.chapter1.graph.minsubtree;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-18 10:48
 * @Version : V1.0
 * @Description : 图的边的存储类
 */
public class EdgeData {
    /**
     * 边的起点
     */
    char start;
    /**
     * 边的终点
     */
    char end;
    /**
     * 边的权重
     */
    int weight;

    /**
     * 构造器
     *
     * @param start  边的起点
     * @param end    边的终点
     * @param weight 边的权重
     */
    public EdgeData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
