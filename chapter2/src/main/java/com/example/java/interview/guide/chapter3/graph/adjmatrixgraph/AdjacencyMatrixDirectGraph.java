package com.example.java.interview.guide.chapter3.graph.adjmatrixgraph;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-25 18:22
 * @Version : V1.0
 * @Description : 邻接矩阵实现有向图
 */
public class AdjacencyMatrixDirectGraph {
    /**
     * 顶点数量
     */
    private int vertexCount;
    /**
     * 边数量
     */
    private int edgeCount;
    /**
     * 存放弧信息的二维数组
     */
    private int[][] arcArray;

    /**
     * 构造器
     *
     * @param data        元数据
     * @param vertexCount 顶点个数
     */
    public AdjacencyMatrixDirectGraph(int[][] data, int vertexCount) {
        this.vertexCount = vertexCount;
        this.edgeCount = data.length;
        arcArray = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                // 如果两个顶点之前没有边则用Integer.MAX_VALUE表示
                arcArray[i][j] = Integer.MAX_VALUE;
            }
        }
        // 根据初始化数组构建邻接矩阵
        for (int i = 0; i < data.length; i++) {
            // 边的起点
            int tail = data[i][0];
            // 边的终点
            int head = data[i][1];
            // 顶点间存在边的用1表示
            arcArray[tail][head] = 1;
        }
    }

    /**
     * 查询一个顶点的邻接点
     *
     * @param vertex 顶点
     * @return       邻接点
     */
    public Set<Integer> adjacency(int vertex) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < vertexCount; i++) {
            // 不等于Integer.MAX_VALUE说明有边存在
            if (arcArray[vertex][i] != Integer.MAX_VALUE) {
                set.add(i);
            }
        }
        return set;
    }

}
