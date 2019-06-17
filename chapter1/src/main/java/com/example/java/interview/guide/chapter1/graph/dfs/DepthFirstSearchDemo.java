package com.example.java.interview.guide.chapter1.graph.dfs;

import com.example.java.interview.guide.chapter1.graph.adjlistgraph.AdjacencyListGraph;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/17 11:15
 * @Version : V1.0
 * @Description : 图的深度优先遍历测试
 */
public class DepthFirstSearchDemo {
    public static void main(String[] args) {
        String[] vertexArray = {"A", "B", "C", "D", "E", "F", "G"};
        String[][] edges = new String[][]{
                {"A", "C"},
                {"A", "D"},
                {"A", "F"},
                {"B", "C"},
                {"C", "D"},
                {"E", "G"},
                {"F", "G"}};
        AdjacencyListGraph adjDirectGraph = new AdjacencyListGraph(vertexArray,edges);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(adjDirectGraph);
        depthFirstSearch.dfsPrint(adjDirectGraph, "D");
    }
}
