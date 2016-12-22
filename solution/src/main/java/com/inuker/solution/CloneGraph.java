package com.inuker.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by dingjikerbo on 2016/12/21.
 */

public class CloneGraph {

    /**
     * DFS方法
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap) {
        if (node == null) return null;
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        cloneMap.put(node, cloned); // visited = true;
        for(UndirectedGraphNode neighbor: node.neighbors){
            if (cloneMap.containsKey(neighbor)) { // if we have already explored this vertex grab its clone from map
                cloned.neighbors.add(cloneMap.get(neighbor));
            } else { // explore unvisited vertex
                cloned.neighbors.add(cloneGraph(neighbor, cloneMap));
            }
        }
        return cloned;
    }

    /**
     * BFS方法
     */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); //new node for return
        HashMap<Integer, UndirectedGraphNode> map = new HashMap(); //store visited nodes

        map.put(newNode.label, newNode); //add first node to HashMap

        LinkedList<UndirectedGraphNode> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue

        while (!queue.isEmpty()) { //if more nodes need to be visited
            UndirectedGraphNode n = queue.pop(); //search first node in the queue
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label)); //add neighbor to new created nodes
            }
        }

        return newNode;
    }
}
