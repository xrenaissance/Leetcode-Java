package com.inuker.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/19.
 */

public class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
