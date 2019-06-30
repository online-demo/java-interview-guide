package com.example.java.interview.guide.chapter1.graph.minsubtree;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-19 16:45
 * @Version : V1.0
 * @Description :  普里姆(Prim)算法最小生成树测试
 */
public class PrimMinSubTree {
    private static int INF = Integer.MAX_VALUE;

    /**
     * prim最小生成树
     *
     * @param start     从图中的第start个元素开始，生成最小树
     * @param graph     图
     */
    public void minSubTree(int start, AdjacencyListWeightGraph graph) {
        int min, i, j, k, m, n, tmp, sum;
        // 顶点数组长度
        int num = graph.vertexNodes.length;
        // prim最小生成树的索引，即resultArray数组的索引
        int index = 0;
        // prim最小生成树的结果数组
        char[] resultArray = new char[num];
        // 顶点间边的权值
        int[] weights = new int[num];

        // prim最小生成树中第一个元素是"图中第start个顶点"，因为是从start开始的。
        resultArray[index++] = graph.vertexNodes[start].data;

        // 初始化"顶点的权值数组"，
        // 将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值。
        for (i = 0; i < num; i++) {
            weights[i] = getWeight(start, i, graph);
        }

        for (i = 0; i < num; i++) {
            // 由于从start开始的，因此不需要再对第start个顶点进行处理
            if (start == i) {
                continue;
            }

            j = 0;
            k = 0;
            min = INF;
            // 在未被加入到最小生成树的顶点中，找出权值最小的顶点。
            while (j < num) {
                // 若weights[j]=0，意味着"第j个结点已经被排序过"(或者说已经加入了最小生成树中)。
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
            // 将第k个顶点加入到最小生成树的结果数组中
            resultArray[index++] = graph.vertexNodes[k].data;
            // 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
            weights[k] = 0;
            // 当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值
            for (j = 0; j < num; j++) {
                // 获取第k个顶点到第j个顶点的权值
                tmp = getWeight(k, j, graph);
                // 更新第k个顶点到各个顶点的权重，重新赋值weights数组
                // 当第j个结点没有被处理，并且需要更新时才被更新
                if (weights[j] != 0 && tmp < weights[j]) {
                    weights[j] = tmp;
                }
            }
        }

        // 计算最小生成树的权值
        sum = 0;
        for (i = 1; i < index; i++) {
            min = INF;
            // 获取resultArray[i]在矩阵表中的位置
            n = getPosition(resultArray[i], graph);
            // 在顶点数组中，找出到j的权值最小的顶点
            for (j = 0; j < i; j++) {
                m = getPosition(resultArray[j], graph);
                tmp = getWeight(m, n, graph);
                if (tmp < min) {
                    min = tmp;
                }
            }
            sum += min;
        }
        // 打印最小生成树
        System.out.printf("PRIM最小生成树=%d: ", sum);
        for (i = 0; i < index; i++) {
            System.out.printf("%c ", resultArray[i]);
        }
        System.out.printf("\n");
    }

    /**
     * 获取边<start, end>的权值；若start和end不是连通的，则返回无穷大。
     *
     * @param start 起始结点
     * @param end   结束结点
     * @param graph 带权图
     * @return 权重
     */
    private int getWeight(int start, int end, AdjacencyListWeightGraph graph) {

        if (start == end) {
            return 0;
        }

        AdjacencyListWeightGraph.EdgeNode node = graph.vertexNodes[start].firstEdge;
        while (node != null) {
            if (end == node.vertexIndex) {
                return node.weight;
            }
            node = node.nextEdge;
        }

        return INF;
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
}
