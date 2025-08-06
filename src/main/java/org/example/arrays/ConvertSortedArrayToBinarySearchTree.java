package org.example.arrays;

import org.example.model.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        TreeNode root = convertToBST(arr, 0, arr.length - 1);
        printInOrder(root);
    }

    private static TreeNode convertToBST(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.setLeft(convertToBST(arr, left, mid - 1));
        root.setRight(convertToBST(arr, mid + 1, right));
        return root;
    }

    private static void printInOrder(TreeNode node){
        printInOrder(node.getLeft());
        System.out.println(node.getVal()+ " ");
        printInOrder(node.getRight());
    }
}
