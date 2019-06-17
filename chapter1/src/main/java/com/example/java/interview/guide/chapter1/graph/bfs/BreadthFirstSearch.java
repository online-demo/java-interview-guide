package com.example.java.interview.guide.chapter1.graph.bfs;

import com.example.java.interview.guide.chapter1.graph.adjlistgraph.AdjacencyListGraph;

import java.util.*;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/17 15:45
 * @Version : V1.0
 * @Description : 图的广度优先遍历
 */
public class BreadthFirstSearch {
    private Map<String, Boolean> visited;
    AdjacencyListGraph graph;
    LinkedList<String> list;
    /**
     * 构造器
     */
    public BreadthFirstSearch(AdjacencyListGraph graph) {
        // 指定初始容量，此处使用默认容量。具体容量的估算参考HashMap章节
        visited = new HashMap<>(16);
        this.graph = graph;
        list = new LinkedList<>(Arrays.asList(graph.vertexArray));
    }

    public void bfsPrint(String value) {
        Queue<String> queue = new LinkedList<>();
        // 已遍历元素标记为true
        visited.put(value, true);
        System.out.print(value + "    ");
        // value入队
        queue.add(value);
        while (!queue.isEmpty()) {
            // 出队
            String vertex = queue.poll();
            for (String adj : graph.adj(vertex)) {
                if(visited.get(adj) == null || !visited.get(adj)) {
                    // 已遍历元素标记为true
                    visited.put(adj, true);
                    // 邻接点入队
                    queue.offer(adj);
                    System.out.print(adj + "    ");
                }
            }
        }
    }
}
