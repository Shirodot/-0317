# Data Structures & Algorithms Fundamentals

This repository contains Java implementations of core computer science algorithms and data structures, serving as the code base for Assignments 1 through 5. Topics cover linear structures (Stacks, Queues), non-linear structures (Trees), algorithmic paradigms (Divide and Conquer), and Graph Traversal.

## 📚 Assignments Overview

### Assignment 1: Stack Operations
[cite_start]Implemented a Stack using a **dynamic array** approach to handle capacity limits[cite: 82, 87, 89].
* [cite_start]**Concepts:** Last-In-First-Out (LIFO)[cite: 73].
* [cite_start]**Time Complexity Analysis:** * `push()`: **Amortized $O(1)$**[cite: 80, 81]. [cite_start]The dynamic array resizes by doubling its capacity ($1 \rightarrow 2 \rightarrow 4 \rightarrow 8 \rightarrow \dots \rightarrow n$)[cite: 96]. [cite_start]While copying elements takes $O(n)$ time [cite: 90][cite_start], it happens rarely, so the average cost remains $O(1)$[cite: 101, 102].
  * [cite_start]`pop()`: $O(1)$[cite: 52].
  * [cite_start]`peek()`: $O(1)$[cite: 126].

### Assignment 2: Tree Structure
[cite_start]Constructed a fundamental Binary Tree structure[cite: 219, 438].
* [cite_start]**Concepts:** Root nodes, depth, height, and parent-child relationships[cite: 180, 186, 187, 189, 193]. A tree graph $T=(V,E)$ is connected and strictly contains $|E| = |V| - [cite_start]1$ edges[cite: 159, 160, 161]. 
* [cite_start]**Binary Tree Constraints:** Each node has at most two child nodes ($deg(v) \le 2$)[cite: 221, 223]. 

### Assignment 3: Tree Traversals
[cite_start]Implemented classic recursive depth-first traversals on the binary tree[cite: 443].
* [cite_start]**Preorder Traversal:** $root \rightarrow left \rightarrow right$[cite: 273]. [cite_start]Example output: `A B D E C F G`[cite: 280].
* [cite_start]**Inorder Traversal:** $left \rightarrow root \rightarrow right$[cite: 284]. [cite_start]Example output: `D B E A F C G`[cite: 291].
* [cite_start]**Postorder Traversal:** $left \rightarrow right \rightarrow root$[cite: 296]. [cite_start]Example output: `D E B F G C A`[cite: 302].

### Assignment 4: Divide and Conquer
[cite_start]Implemented recursive algorithms based on dividing the problem into smaller sub-problems[cite: 450, 451].
* **Merge Sort:** Slices the array in half, sorts, and merges. [cite_start]The recurrence relation is $T(n) = 2T(n/2) + n$ [cite: 336, 453][cite_start], resolving to a time complexity of $O(n \log n)$[cite: 371].
* **Binary Search:** Searches a sorted array by halving the search space. [cite_start]The recurrence relation is $T(n) = T(n/2) + 1$ [cite: 336, 453][cite_start], resolving to a time complexity of $O(\log n)$[cite: 357].

### Assignment 5: DFS vs BFS
[cite_start]Explored different methods to search through a graph/tree $G=(V,E)$[cite: 390, 427, 457].
* [cite_start]**Depth First Search (DFS):** Implemented using a **Stack**[cite: 397]. [cite_start]Explores as deep as possible before turning back[cite: 391]. [cite_start]Time Complexity: $O(V+E)$[cite: 429, 461, 462].
* [cite_start]**Breadth First Search (BFS):** Implemented using a **Queue**[cite: 412]. [cite_start]Searches by distance level, ensuring nodes added first are processed first[cite: 404, 416]. [cite_start]Time Complexity: $O(V+E)$[cite: 430, 463].

---

## 🚀 How to Run

1. Ensure the Java Development Kit (JDK) is installed.
2. Clone this repository to your local machine.
3. Open a terminal and navigate to the project directory.
4. Compile the code:
   ```bash
   javac AlgorithmAssignments.java