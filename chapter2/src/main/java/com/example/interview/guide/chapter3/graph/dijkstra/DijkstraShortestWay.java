package com.example.interview.guide.chapter3.graph.dijkstra;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/24 20:04
 * @Version : V1.0
 * @Description : Dijkstra算法获取最短路径  邻接表存储图
 */
public class DijkstraShortestWay {
    /**
     * 两个顶点间没有边相连
     */
    private static int INF = Integer.MAX_VALUE;

    /**
     * 邻接表中的链表的结点
     */
    private class EdgeNode {
        /**
         * 该边所指向的顶点的位置
         */
        int vertexIndex;
        /**
         * 该边的权
         */
        int weight;
        /**
         * 指向下一条弧的指针
         */
        EdgeNode nextEdge;
    }

    /**
     * 邻接表中表的顶点
     */
    public class VertexNode {
        /**
         * 顶点信息
         */
        char data;
        /**
         * 指向第一条依附该顶点的边
         */
        EdgeNode firstEdge;
    }

    /**
     * 边的输入结构
     */
    public static class EdgeData {
        /**
         * 边的起点
         */
        char start;
        /**
         * 边的终点
         */
        char end;
        /**
         * 边的权重
         */
        int weight;

        /**
         * 构造器
         */
        public EdgeData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    /**
     * 顶点数组
     */
    public VertexNode[] vertexNodes;

    /**
     * 用已提供的矩阵创建带权图
     *
     * @param vertexNodes 顶点数组
     * @param edges       边数组
     */
    public DijkstraShortestWay(char[] vertexNodes, EdgeData[] edges) {

        // 初始化"顶点数"和"边数"
        int vertexLength = vertexNodes.length;
        int edgeLength = edges.length;

        // 初始化"顶点"
        this.vertexNodes = new VertexNode[vertexLength];
        for (int i = 0; i < this.vertexNodes.length; i++) {
            this.vertexNodes[i] = new VertexNode();
            this.vertexNodes[i].data = vertexNodes[i];
            this.vertexNodes[i].firstEdge = null;
        }
        for (int i = 0; i < edgeLength; i++) {
            // 读取边的起始顶点、结束顶点和权重
            char c1 = edges[i].start;
            char c2 = edges[i].end;
            int weight = edges[i].weight;

            // 读取边的起始顶点和结束顶点在顶点数组中的位置
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // 初始化node1
            EdgeNode node1 = new EdgeNode();
            node1.vertexIndex = p2;
            node1.weight = weight;
            // 将node1链接到"p1所在链表的末尾"
            if (this.vertexNodes[p1].firstEdge == null) {
                this.vertexNodes[p1].firstEdge = node1;
            } else {
                linkLast(this.vertexNodes[p1].firstEdge, node1);
            }
            // 初始化node2
            EdgeNode node2 = new EdgeNode();
            node2.vertexIndex = p1;
            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if (this.vertexNodes[p2].firstEdge == null) {
                this.vertexNodes[p2].firstEdge = node2;
            } else {
                linkLast(this.vertexNodes[p2].firstEdge, node2);
            }
        }
    }

    /**
     * 将node结点链接到list的最后
     */
    private void linkLast(EdgeNode list, EdgeNode node) {
        EdgeNode p = list;

        while (p.nextEdge != null) {
            p = p.nextEdge;
        }
        p.nextEdge = node;
    }

    /**
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexNodes.length; i++) {
            if (vertexNodes[i].data == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取边<start, end>的权值；若start和end不是连通的，则返回无穷大。
     */
    private int getWeight(int start, int end) {

        if (start == end) {
            return 0;
        }

        EdgeNode node = vertexNodes[start].firstEdge;
        while (node != null) {
            if (end == node.vertexIndex) {
                return node.weight;
            }
            node = node.nextEdge;
        }

        return INF;
    }

    /**
     * Dijkstra最短路径
     *
     * @param start 起始顶点，即计算起始顶点到其它顶点的最短路径
     * @param prev  前驱顶点数组。prev[i]的值是起始顶点到其它顶点的最短路径
     *              所经历的全部顶点中，位于"顶点i"之前的那个顶点
     * @param dist  长度数组。即，dist[i]是起始顶点到其它顶点的最短路径的长度
     */
    public void dijkstra(int start, int[] prev, int[] dist) {
        // flag[i]=true表示起始顶点到其他顶点的最短路径已成功获取。
        boolean[] flag = new boolean[vertexNodes.length];

        // 初始化
        for (int i = 0; i < vertexNodes.length; i++) {
            // 顶点i的最短路径尚未获取到
            flag[i] = false;
            // 顶点i的前驱顶点为0
            prev[i] = 0;
            // 顶点i的最短路径为权重最小的边的权总和
            dist[i] = getWeight(start, i);
        }

        // 对顶点自身进行初始化
        flag[start] = true;
        dist[start] = 0;

        // 每次找出一个顶点的最短路径。
        int k = 0;
        for (int i = 1; i < vertexNodes.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离start最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < vertexNodes.length; j++) {
                if (!flag[j] && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，
            // 更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < vertexNodes.length; j++) {
                int tmp = getWeight(k, j);
                // 防止溢出
                tmp = (tmp == INF ? INF : (min + tmp));
                if (flag[j] == false && (tmp < dist[j])) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra算法求解顶点%c到各个顶点的最短路径: \n",
                vertexNodes[start].data);
        for (int i = 0; i < vertexNodes.length; i++) {
            System.out.printf("  顶点(%c, %c)之间的最短路径=%d\n",
                    vertexNodes[start].data, vertexNodes[i].data, dist[i]);
        }
    }
}
