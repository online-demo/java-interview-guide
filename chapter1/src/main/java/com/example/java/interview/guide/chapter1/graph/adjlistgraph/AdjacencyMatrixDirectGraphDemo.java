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
        // 顶点数组
        String[] vertexArray = {"A", "B", "C", "D", "E", "F", "G"};
        // 边关系
        String[][] edges = new String[][]{
                {"A", "C"},
                {"A", "D"},
                {"A", "F"},
                {"B", "C"},
                {"C", "D"},
                {"E", "G"},
                {"F", "G"}};
        AdjacencyListGraph adjDirectGraph = new AdjacencyListGraph(vertexArray, edges);
        // 获取每个顶点的邻接点
        for (String vertex : vertexArray) {
            for (String adjNode : adjDirectGraph.adj(vertex)) {
                System.out.println("顶点" + vertex + "的邻接点有：" + adjNode);
            }
        }
    }
}
