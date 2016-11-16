package com.inuker.solution;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        Codec code = new Codec();
        String data = code.serialize(root);
        System.out.println(data);
        TreeNode node = code.deserialize(data);
        System.out.println(String.format("%d, %s, %s", node.val, node.left, node.right));
    }
}
