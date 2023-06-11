package interviewbit.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

Note: The test cases are generated in the following format (use the following format to use See Expected Output option):

First integer N is the number of nodes.

Then, N integers follow denoting the label (or hash) of the N nodes.

Then, N2 integers following denoting the adjacency matrix of a graph, where Adj[i][j] = 1
denotes presence of an undirected edge between the ith and jth node, O otherwise.

Problem Constraints
1 <= Number of nodes <= 105

Input Format
First and only argument is a node A denoting the root of the undirected graph.

Output Format
Return the node denoting the root of the new clone graph.

Example Input
Input 1:
      1
    / | \
   3  2  4
        / \
       5   6
Input 2:
      1
     / \
    3   4
   /   /|\
  2   5 7 6


Example Output
Output 1:
 Output will the same graph but with new pointers:
      1
    / | \
   3  2  4
        / \
       5   6
Output 2:
      1
     / \
    3   4
   /   /|\
  2   5 7 6


Example Explanation
Explanation 1:
 We need to return the same graph, but the pointers to the node should be different.
 */
public class CloneGraph {
    public static void main(String[] args) {
        UndirectedGraphNode root = new UndirectedGraphNode(1);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
        UndirectedGraphNode node7 = new UndirectedGraphNode(7);
        UndirectedGraphNode node6 = new UndirectedGraphNode(6);

        node3.neighbors.add(node2);

        node4.neighbors.add(node5);
        node4.neighbors.add(node6);
        node4.neighbors.add(node7);

        root.neighbors.add(node3);
        root.neighbors.add(node4);

        System.out.println(new CloneGraph().cloneGraph(root));
    }

    HashMap<UndirectedGraphNode, UndirectedGraphNode> map;


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map = new HashMap<>();
        return auxCloneGraph(node);
    }

    private UndirectedGraphNode auxCloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(auxCloneGraph(neighbor));
        }
        return clone;
    }

}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "UndirectedGraphNode{" +
                "label=" + label +
                ", neighbors=" + neighbors +
                '}';
    }
}
