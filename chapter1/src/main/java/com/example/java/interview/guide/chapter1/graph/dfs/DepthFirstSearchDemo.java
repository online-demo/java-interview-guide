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
        AdjacencyListGraph adjacencyListGraph = init();
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(adjacencyListGraph);
        depthFirstSearch.dfsPrint("0");
    }
    public static AdjacencyListGraph init() {
        String[] vertexArray = {"0", "1", "2", "3", "4", "5"};
        String[][] edges = new String[][]{
                {"0", "1"},
                {"0", "2"},
                {"0", "5"},
                {"1", "2"},
                {"2", "3"},
                {"2", "4"},
                {"3", "4"},
                {"3", "5"}
        };
        return new AdjacencyListGraph(vertexArray,edges);
    }
}
