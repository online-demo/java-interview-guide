package com.example.interview.guide.chapter3.graph.dfs;

import com.example.interview.guide.chapter3.graph.adjlistgraph.AdjacencyListGraph;

import java.util.*;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/17 10:55
 * @Version : V1.0
 * @Description : 图的深度优先遍历
 */
public class DepthFirstSearch {
    private Map<String, Boolean> visited;
    AdjacencyListGraph graph;
    LinkedList<String> list;

    /**
     * 构造器
     */
    public DepthFirstSearch(AdjacencyListGraph graph) {
        // 指定初始容量，此处使用默认容量。具体容量的估算参考HashMap章节
        visited = new HashMap<>(16);
        this.graph = graph;
        list = new LinkedList<>(Arrays.asList(graph.vertexArray));
    }

    /**
     * 深度优先遍历
     *
     * @param value 深度优先遍历的起点
     */
    public void dfsPrint(String value) {
        // 已遍历元素标记为true
        visited.put(value, true);
        System.out.print(value + "    ");
        // 查找value的邻接点并开始迭代每个邻接点
        for (String adj : graph.adj(value)) {
            if (visited.get(adj) == null || !visited.get(adj)) {
                // value的每个邻接点递归深度优先遍历
                dfsPrint(adj);
            }
        }
    }
}
