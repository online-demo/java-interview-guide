package com.example.java.interview.guide.chapter1.graph.adjlistgraph;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/12 11:26
 * @Version : V1.0
 * @Description : 有向图的邻接表实现测试
 */
public class AdjacencyMatrixDirectGraphDemo {
    public static void main(String[] args) {
        int[][] data = {
                {0,3},
                {1,0},
                {1,2},
                {2,0},
                {2,1},
        };
        AdjacencyMatrixDirectGraph adjDirectGraph = new AdjacencyMatrixDirectGraph(data,4);
        int vertex = 2;
        // 获取顶点2的邻接点
        for(int adjNode : adjDirectGraph.adj(vertex)) {
            System.out.println("顶点" + vertex + "的邻接点有：" + adjNode);
        }
    }
}
