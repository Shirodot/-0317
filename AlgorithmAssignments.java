import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Data Structures and Algorithms Assignments
 * Based on Lecture 2 (Tree, Stack, Queue, Recursion, Divide & Conquer, Graph Search)
 */
public class AlgorithmAssignments {

    // ==========================================
    // Assignment 1: Stack Operations
    // ==========================================
    public static class DynamicStack {
        private int[] array;
        private int top;

        public DynamicStack() {
            array = new int[1]; // Start with 1 to match slide's 1->2->4->8 strategy
            top = 0;
        }

        // Amortized O(1)
        public void push(int value) {
            if (top == array.length) {
                resize();
            }
            array[top++] = value;
        }

        // O(1)
        public int pop() {
            if (isEmpty()) throw new IllegalStateException("Stack is empty");
            return array[--top];
        }

        // O(1)
        public int peek() {
            if (isEmpty()) throw new IllegalStateException("Stack is empty");
            return array[top - 1];
        }

        public boolean isEmpty() {
            return top == 0;
        }

        // O(n) operation, but happens rarely (Amortized analysis)
        private void resize() {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    // ==========================================
    // Assignment 2: Rooted / Binary Tree Structure
    // ==========================================
    public static class TreeNode {
        String value;
        TreeNode left;
        TreeNode right;

        public TreeNode(String value) {
            this.value = value;
        }
    }

    // ==========================================
    // Assignment 3: Tree Traversals
    // ==========================================
    public static class TreeTraversals {
        
        // Preorder: Root -> Left -> Right
        public static void preorder(TreeNode node) {
            if (node == null) return;
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }

        // Inorder: Left -> Root -> Right
        public static void inorder(TreeNode node) {
            if (node == null) return;
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }

        // Postorder: Left -> Right -> Root
        public static void postorder(TreeNode node) {
            if (node == null) return;
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }

    // ==========================================
    // Assignment 4: Divide and Conquer
    // ==========================================
    public static class DivideAndConquer {
        
        // 1. Merge Sort: T(n) = 2T(n/2) + n
        public static void mergeSort(int[] arr, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;
                mergeSort(arr, left, mid);
                mergeSort(arr, mid + 1, right);
                merge(arr, left, mid, right);
            }
        }

        private static void merge(int[] arr, int left, int mid, int right) {
            int[] L = Arrays.copyOfRange(arr, left, mid + 1);
            int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);
            int i = 0, j = 0, k = left;
            while (i < L.length && j < R.length) {
                arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
            }
            while (i < L.length) arr[k++] = L[i++];
            while (j < R.length) arr[k++] = R[j++];
        }

        // 2. Binary Search: T(n) = T(n/2) + 1
        public static int binarySearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) return mid;
                if (arr[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            return -1; // Not found
        }
    }

    // ==========================================
    // Assignment 5: DFS vs BFS
    // ==========================================
    public static class GraphSearch {
        
        // Depth First Search (O(V+E))
        public static void dfs(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            
            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                System.out.print(current.value + " ");
                
                // Push right first so left is processed first (LIFO)
                if (current.right != null) stack.push(current.right);
                if (current.left != null) stack.push(current.left);
            }
        }

        // Breadth First Search (O(V+E))
        public static void bfs(TreeNode root) {
            if (root == null) return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                System.out.print(current.value + " ");
                
                // Enqueue left then right (FIFO)
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }

    // ==========================================
    // Main Method to Run All Assignments
    // ==========================================
    public static void main(String[] args) {
        System.out.println("--- ASSIGNMENT 1: Stack Operations ---");
        DynamicStack stack = new DynamicStack();
        stack.push(1); stack.push(2); stack.push(3); stack.push(4);
        System.out.println("Popped: " + stack.pop()); 
        System.out.println("Current Top: " + stack.peek() + "\n"); 

        System.out.println("--- ASSIGNMENT 2: Rooted Tree & Binary Tree Structure ---");
        System.out.println("Building the tree A -> (B, C) -> (D, E), (F, G)...");
        TreeNode root = new TreeNode("A");
        root.left = new TreeNode("B"); root.right = new TreeNode("C");
        root.left.left = new TreeNode("D"); root.left.right = new TreeNode("E");
        root.right.left = new TreeNode("F"); root.right.right = new TreeNode("G");
        System.out.println("Tree built successfully.\n");

        System.out.println("--- ASSIGNMENT 3: Tree Traversals ---");
        System.out.print("Preorder:  "); TreeTraversals.preorder(root); System.out.println();
        System.out.print("Inorder:   "); TreeTraversals.inorder(root); System.out.println();
        System.out.print("Postorder: "); TreeTraversals.postorder(root); System.out.println("\n");

        System.out.println("--- ASSIGNMENT 4: Divide and Conquer ---");
        int[] arr = {8, 3, 5, 2, 9, 1};
        DivideAndConquer.mergeSort(arr, 0, arr.length - 1);
        System.out.println("Merge Sorted Array: " + Arrays.toString(arr));
        int target = 5;
        System.out.println("Binary Search for " + target + ": Found at index " + DivideAndConquer.binarySearch(arr, target) + "\n");

        System.out.println("--- ASSIGNMENT 5: DFS vs BFS ---");
        System.out.print("DFS (using Stack): "); GraphSearch.dfs(root); System.out.println();
        System.out.print("BFS (using Queue): "); GraphSearch.bfs(root); System.out.println();
    }
}