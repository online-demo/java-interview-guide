package com.example.java.interview.guide.chapter1.graph.minsubtree;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-18 16:18
 * @Version : V1.0
 * @Description :  克鲁斯卡尔（Kruskal)最小生成树
 */
public class KruskalMinSubTree {
    /**
     * 打印最小生成树
     */
    public void minSubTree(AdjacencyListWeightGraph graph) {
        // 结果数组，保存kruskal最小生成树的边
        EdgeData[] resultArray = new EdgeData[graph.edgNum];
        // resultArray数组的索引
        int index = 0;
        // 用于保存"已有最小生成树"中每个顶点在该最小树中的终点
        int[] vertexEndArray = new int[graph.edgNum];
        // 图中所有的边
        EdgeData[] edges = getEdges(graph);
        // 将边按照"权"的大小进行排序(从小到大)
        sortEdges(edges, graph.edgNum);
        // 遍历带权边（从权重最小的边开始遍历）
        for (int i = 0; i< graph.edgNum; i++) {
            // 获取第i条边的"起点"的序号
            int startPosition = getPosition(edges[i].start, graph);
            // 获取第i条边的"终点"的序号
            int endPosition = getPosition(edges[i].end, graph);
            // 获取startPosition在"已有的最小生成树"中的终点
            int startDestination = getEnd(vertexEndArray, startPosition);
            // 获取endPosition在"已有的最小生成树"中的终点
            int endDestination = getEnd(vertexEndArray, endPosition);
            // 如果startDestination!=endDestination，意味着"边i"与"已经添加到最小生成树中的顶点"没有形成环路
            if (startDestination != endDestination) {
                // 设置startDestination在"已有的最小生成树"中的终点为endDestination
                vertexEndArray[startDestination] = endDestination;
                // 保存"最小生成树"一条边
                resultArray[index++] = edges[i];
            }
        }

        // 统计并打印"kruskal最小生成树"的信息
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += resultArray[i].weight;
        }
        System.out.printf("Kruskal最小生成树=%d: ", sum);
        for (int i = 0; i < index; i++) {
            System.out.printf("(%c,%c) ", resultArray[i].start, resultArray[i].end);
        }
        System.out.println();
    }

    /**
     * 根据连接表获取图中的带权边
     *
     * @param graph     邻接表表示带权图
     * @return          边数组
     */
    private EdgeData[] getEdges(AdjacencyListWeightGraph graph) {
        int index=0;
        EdgeData[] edges = new EdgeData[graph.edgNum];
        for (int i = 0; i < graph.vertexNodes.length; i++) {
            AdjacencyListWeightGraph.EdgeNode node = graph.vertexNodes[i].firstEdge;
            while (node != null) {
                if (node.vertexIndex > i) {
                    edges[index++] = new EdgeData(graph.vertexNodes[i].data, graph.vertexNodes[node.vertexIndex].data, node.weight);
                }
                node = node.nextEdge;
            }
        }
        return edges;
    }

    /**
     * 对边按照权值大小进行排序(由小到大)
     */
    private void sortEdges(EdgeData[] edges, int elen) {

        for (int i = 0; i < elen; i++) {
            for (int j = i + 1; j < elen; j++) {

                if (edges[i].weight > edges[j].weight) {
                    // 交换"边i"和"边j"
                    EdgeData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    /**
     * 返回顶点的位置
     * @param ch    顶点
     * @param graph 图
     * @return      位置
     */
    private int getPosition(char ch, AdjacencyListWeightGraph graph) {
        for(int i = 0; i<graph.vertexNodes.length; i++) {
            if(graph.vertexNodes[i].data==ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 递归获取position的终点
     * @param vertexEndArray    用于保存"已有最小生成树"中每个顶点在该最小树中的终点
     * @param position          顶点位置
     * @return                  最终的终点位置
     */
    private int getEnd(int[] vertexEndArray, int position) {
        while (vertexEndArray[position] != 0) {
            // position节点所在的边的终点的position
            position = vertexEndArray[position];
        }
        return position;
    }
}
