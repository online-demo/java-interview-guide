package com.example.interview.guide.chapter3.graph.adjmatrixgraph;

import java.util.Set;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-25 20:14
 * @Version : V1.0
 * @Description : 邻接矩阵实现有向图测试
 */
public class AdjacencyMatrixDirectGraphDemo {
    public static void main(String[] args) {
        // 描述有向图的有向边
        int[][] data = {
                {0, 3},
                {1, 0},
                {1, 2},
                {2, 0},
                {2, 1}
        };
        AdjacencyMatrixDirectGraph graph = new AdjacencyMatrixDirectGraph(data, 4);
        Set<Integer> set = graph.adjacency(1);
        System.out.printf("顶点1的邻接点为：%s%n", set);
    }
}
