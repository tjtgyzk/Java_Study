package myStudy.Zuo.Graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    public int in;//有几个节点指向它
    public int out;//它指向几个节点
    public List<Node> nexts;//它指向的节点
    public List<Edge> edges;//由它出发的路径

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
