package com.example.java.interview.guide.chapter1.graph.directgraph;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-25 18:22
 * @Version : V1.0
 * @Description :   邻接矩阵实现有向图
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
     * @param data      元数据
     * @param vertexCount   顶点个数
     */
    public AdjacencyMatrixDirectGraph(int[][] data, int vertexCount) {
        this.vertexCount = vertexCount;
        this.edgeCount = data.length;
        arcArray = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                arcArray[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < data.length; i++) {
            int tail = data[i][0];
            int head = data[i][1];
            arcArray[tail][head] = 1;
        }
    }

    /**
     * 查询一个顶点的邻接点
     * @param vertex
     * @return
     */
    public Set<Integer> adjacency(int vertex) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < vertexCount; i++) {
            if (arcArray[vertex][i] != Integer.MAX_VALUE) {
                set.add(i);
            }
        }
        return set;
    }

}
