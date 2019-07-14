package com.example.java.interview.guide.chapter1.graph.dijkstra;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/24 20:04
 * @Version : V1.0
 * @Description : Dijkstra算法获取最短路径  邻接表存储图
 */
public class DijkstraShortestWay {
    private static int INF = Integer.MAX_VALUE;

    /**
     * 邻接表中表对应的链表的结点
     */
    private class ENode {
        /**
         * 该边所指向的顶点的位置
         */
        int ivex;
        /**
         * 该边的权
         */
        int weight;
        /**
         * 指向下一条弧的指针
         */
        ENode nextEdge;
    }

    /**
     * 邻接表中表的顶点
     */
    private class VNode {
        /**
         * 顶点信息
         */
        char data;
        /**
         * 指向第一条依附该顶点的边
         */
        ENode firstEdge;
    }

    /**
     * 边的输入结构
     */
    private static class EData {
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
        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    /**
     * 顶点数组
     */
    private VNode[] mVexs;

    /**
     * 用已提供的矩阵创建图
     *
     * @param vexs      顶点数组
     * @param edges     边数组
     */
    public DijkstraShortestWay(char[] vexs, EData[] edges) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            char c1 = edges[i].start;
            char c2 = edges[i].end;
            int weight = edges[i].weight;

            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // 初始化node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            node1.weight = weight;
            // 将node1链接到"p1所在链表的末尾"
            if(mVexs[p1].firstEdge == null) {
                mVexs[p1].firstEdge = node1;
            } else {
                linkLast(mVexs[p1].firstEdge, node1);
            }
            // 初始化node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if(mVexs[p2].firstEdge == null) {
                mVexs[p2].firstEdge = node2;
            } else {
                linkLast(mVexs[p2].firstEdge, node2);
            }
        }
    }
    /**
     * 将node结点链接到list的最后
     */
    private void linkLast(ENode list, ENode node) {
        ENode p = list;

        while(p.nextEdge!=null) {
            p = p.nextEdge;
        }
        p.nextEdge = node;
    }

    /**
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++) {
            if(mVexs[i].data==ch)
                return i;
        }
        return -1;
    }
    /**
     * 获取边<start, end>的权值；若start和end不是连通的，则返回无穷大。
     */
    private int getWeight(int start, int end) {

        if (start==end) {
            return 0;
        }

        ENode node = mVexs[start].firstEdge;
        while (node!=null) {
            if (end==node.ivex) {
                return node.weight;
            }
            node = node.nextEdge;
        }

        return INF;
    }

    /**
     * Dijkstra最短路径
     *
     * @param vs        起始顶点，即计算"顶点v"到其它顶点的最短路径
     * @param prev      前驱顶点数组。即，prev[i]的值是"顶点v"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点
     * @param dist      长度数组。即，dist[i]是"顶点v"到"顶点i"的最短路径的长度
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        // flag[i]=true表示"顶点v"到"顶点i"的最短路径已成功获取。
        boolean[] flag = new boolean[mVexs.length];

        // 初始化
        for (int i = 0; i < mVexs.length; i++) {
            // 顶点i的最短路径尚未获取到
            flag[i] = false;
            // 顶点i的前驱顶点为0
            prev[i] = 0;
            // 顶点i的最短路径为"顶点v"到"顶点i"的权
            dist[i] = getWeight(vs, i);
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
        int k = 0;
        for (int i = 1; i < mVexs.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < mVexs.length; j++) {
                int tmp = getWeight(k, j);
                tmp = (tmp==INF ? INF : (min + tmp)); // 防止溢出
                if (flag[j]==false && (tmp<dist[j]) )
                {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%c): \n", mVexs[vs].data);
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs].data, mVexs[i].data, dist[i]);
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        EData[] edges = {
                // 起点 终点 权
                new EData('A', 'B', 12),
                new EData('A', 'F', 16),
                new EData('A', 'G', 14),
                new EData('B', 'C', 10),
                new EData('B', 'F',  7),
                new EData('C', 'D',  3),
                new EData('C', 'E',  5),
                new EData('C', 'F',  6),
                new EData('D', 'E',  4),
                new EData('E', 'F',  2),
                new EData('E', 'G',  8),
                new EData('F', 'G',  9),
        };
        DijkstraShortestWay pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new ListUDG();
        // 采用已有的"图"
        pG = new DijkstraShortestWay(vexs, edges);
        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        pG.dijkstra(3, prev, dist);
    }
}
