[TOC]

### 数组

#### 二维数组中的查找

```java
public class Solution {
    public boolean Find(int [][] array,int target) {
				int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[row].length) {
            if (array[row][col] > target) {
                row--;
            } else if (array[row][col] < target)
                col++;
            else
                return true;
        }
        return false;
    }
}
```

#### 调整数组顺序使奇数位于偶数前面

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

```java
import java.util.ArrayList;
public class Solution {
    public void reOrderArray(int [] array) {
     	ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                even.add(array[i]);
            else
                odd.add(array[i]);
        }
        int i = 0;
        while (i < array.length) {
            if (i < odd.size()) {
                array[i] = odd.get(i);
            } else {
                array[i] = even.get(i - odd.size());
            }
            i++;
        }   
    }
}
```

#### 顺时针打印矩阵

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       	ArrayList<Integer> matrixList = new ArrayList<>();
        int count = 0;
        int left = 0, right = matrix[0].length - 1;
        int up = 0, bottom = matrix.length - 1;
        while (count < matrix.length * matrix[0].length) {
            for (int i = left; i <= right; i++, count++) {
                matrixList.add(matrix[up][i]);
            }
            up++;
            if (up > bottom) break;
            for (int i = up; i <= bottom; i++, count++) {
                matrixList.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--, count++) {
                matrixList.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= up; i--, count++) {
                matrixList.add(matrix[i][left]);
            }
            left++;
        }
        return matrixList;
    }
}
```

#### 数组中出现次数超过一半的数字

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

```java
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null||array.length==0) return 0;
        int val = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                val = array[i];
                count = 1;
            }else if (val != array[i]) {
                count--;
            } else {
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                count++;
            }
        }
        return count > array.length / 2 ? val : 0;
    }
}
```

#### 最小的 K 个数

输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

```java
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        if (k > input.length) return array;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            tree.add(input[i]);
        }
        for (int i = 0; i < k; i++) {
            array.add(tree.pollFirst());
        }
        return array;
    }
}
```

#### 把数组排成最小的数

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

```java
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    public int compare(String n, String m) {
        String nm = n + m;
        String mn = m + n;
        return nm.compareTo(mn);
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        Arrays.sort(numbers);
        String str = numbers[0] + "";
        for (int i = 1; i < numbers.length; i++) {
            if (this.compare(str, numbers[i] + "") < 0) {
                str = str + numbers[i];
            } else {
                str = numbers[i] + str;
            }
        }
        return str;
    }
}
```

### 链表

#### 从尾到头打印链表

输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

```java
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> array = new ArrayList<>();
        while (!stack.isEmpty()) {
            array.add(stack.pop());
        }
        return array;
    }
}
```

#### 倒数第 K 个结点

输入一个链表，输出该链表中倒数第k个结点。

```java
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (k > count) {
            return null;
        }
        int number = 0;
        while (number++ < count - k) {
            head = head.next;
        }
        return head;
    }
}
```

#### 反转链表

输入一个链表，反转链表后，输出新链表的表头。

```java
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
		if (head == null) return null;
        ListNode temp1 = head.next;
        head.next = null;
        while (temp1 != null) {
            ListNode temp2 = temp1.next;
            temp1.next = head;
            head = temp1;
            temp1 = temp2;
        }
        return head;
    }
}
```

#### 合并两个排序的链表

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

```java
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode merged;
        if (list1.val <= list2.val) {
            merged = list1;
            merged.next = Merge(list1.next, list2);
        } else {
            merged = list2;
            merged.next = Merge(list1, list2.next);
        }
        return merged;
    }
}
```

#### 复杂链表的复制

输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

```java
import java.util.HashMap;

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {	if (pHead == null) return null;
        RandomListNode newHead = new RandomListNode(pHead.label);
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        RandomListNode temp = pHead;
        RandomListNode newTemp = newHead;
        while (temp != null) {
            hashMap.put(temp, newTemp);
            temp = temp.next;
            if (temp != null) {
                RandomListNode newNode = new RandomListNode(temp.label);
                newTemp.next = newNode;
                newTemp = newTemp.next;
            }
        }
        temp = pHead;
        newTemp = newHead;
        while (temp != null) {
            newTemp.random = hashMap.get(temp.random);
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead;
        
    }
}
```

### 栈

#### 两个栈实现队列

用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

```java
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
      	if(stack1.empty()&&stack2.empty()){	
          	throw new RuntimeException("Queue is empty!");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
```

#### 包含 min 函数的栈

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

```java
import java.util.Stack;

public class Solution {

    
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    
    public void push(int node) {
        stack.push(node - min);
        if (node < min) min = node;
    }
    
    public void pop() {
        int i = stack.pop();
        if (i < 0) min = min - i;
    }
    
    public int top() {
        return stack.peek() < 0 ? min : min + stack.peek();
    }
    
    public int min() {
        return min;
    }
}
```

#### 栈的压入弹出序列

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。

```java
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
      	Stack<Integer> stack = new Stack<>();
        int aIndex = 0;
        for (int i = 0; i < popA.length; i++) {
            int dst = popA[i];
            while (stack.isEmpty() || stack.peek() != dst) {
                if (aIndex >= pushA.length) return false;
                stack.push(pushA[aIndex++]);
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
```

### 二叉树

#### 重建二叉树

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

```java
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int rootIndex = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                rootIndex = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + rootIndex),
                Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + rootIndex, pre.length),
                Arrays.copyOfRange(in, rootIndex + 1, in.length));
        return root;    
    }
}
```

#### 是否是子树

输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

```java
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                result = HasSameTree(root1, root2);
            if (!result)
                result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean HasSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
		if (root1.val != root2.val) return false;
        return HasSameTree(root1.left, root2.left) && HasSameTree(root1.right, root2.right);
    }
}
```

#### 二叉树的镜像

操作给定的二叉树，将其变换为源二叉树的镜像。

```java
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode tree = root.left;
        root.left = root.right;
        root.right = tree;
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
    }
}
```

#### 二叉树的遍历

##### 先序遍历

- 递归方式

```java
 /**
     * 内容：前序遍历
     * 方式：递归
     */
     public void preOrder(Node root){
        // 1. 判断二叉树结点是否为空；若是，则返回空操作
        if(root ==null)
            return;

        // 2. 访问根节点（显示根结点）
        printNode(root);

        // 3. 遍历左子树
        preOrder(root.getLeftNode());

        // 4. 遍历右子树
        preOrder(root.getRightNode());

    }
```

- 非递归方式

  主要采用栈实现

```java
/**
  * 方式：非递归（栈实现）
  */
    public static void preOrder_stack(Node root){

        Stack<Node> stack = new Stack<Node>();

        // 步骤1：直到当前结点为空 & 栈空时，循环结束
        while(root != null || stack.size()>0){

            // 步骤2：判断当前结点是否为空
              // a. 若不为空，执行3
              // b. 若为空，执行5
              if(root != null){

                // 步骤3：输出当前节点，并将其入栈
                printNode(root);
                stack.push(root);

                // 步骤4：置当前结点的左孩子为当前节点
                // 返回步骤1
                root = root.getLeftNode();

            }else{

                // 步骤5：出栈栈顶结点
                root = stack.pop();
                // 步骤6：置当前结点的右孩子为当前节点
                root = root.getRightNode();
                  // 返回步骤1
            }
        }
    }
```

##### 中序遍历

- 递归实现

```java
/**
  * 方式：递归
  */
    public void InOrder(Node root){
    
        // 1. 判断二叉树结点是否为空；若是，则返回空操作
        if(root ==null)
            return;

        // 2. 遍历左子树
        InOrder(root.getLeftNode());

        // 3. 访问根节点（显示根结点）
        printNode(root);

        // 4. 遍历右子树
        InOrder(root.getRightNode());

    }
```

- 非递归实现

  采用栈实现

```java
/**
  * 方式：非递归（栈实现）
  */
    public static void InOrder_stack(Node root){

        Stack<Node> stack = new Stack<Node>();

        // 1. 直到当前结点为空 & 栈空时，循环结束
        while(root != null || stack.size()>0){

            // 2. 判断当前结点是否为空
            // a. 若不为空，执行3、4
            // b. 若为空，执行5、6
            if(root != null){

                // 3. 入栈当前结点
                stack.push(root);

                // 4. 置当前结点的左孩子为当前节点
                // 返回步骤1
                root = root.getLeftNode();

            }else{

                // 5. 出栈栈顶结点
                root = stack.pop();
                // 6. 输出当前节点
                printNode(root);
                // 7. 置当前结点的右孩子为当前节点
                root = root.getRightNode();
                // 返回步骤1
            }
        }
```

##### 后序遍历

- 递归实现

```java
/**
  * 方式：递归
  */
    public void PostOrder(Node root){
        // 1. 判断二叉树结点是否为空；若是，则返回空操作
        if(root ==null)
            return;

        // 2. 遍历左子树
        PostOrder(root.getLeftNode());

        // 3. 遍历右子树
        PostOrder(root.getRightNode());

        // 4. 访问根节点（显示根结点）
        printNode(root);

    }
```

- 非递归实现

  采用栈实现

```java
/**
  * 方式：非递归（栈实现）
  */
    public void PostOrder_stack(Node root){

        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();

        // 步骤1：直到当前结点为空 & 栈空时，循环结束——> 步骤8
        while(root != null || stack.size()>0){

            // 步骤2：判断当前结点是否为空
            // a. 若不为空，执行3、4
            // b. 若为空，执行5、6
            if(root != null){

                // 步骤3：入栈当前结点到中间栈
                output.push(root);

                // 步骤4：入栈当前结点到普通栈
                stack.push(root);

                // 步骤4：置当前结点的右孩子为当前节点
                // 返回步骤1
                root = root.getRightNode();

            }else{

                // 步骤5：出栈栈顶结点
                root = stack.pop();
                // 步骤6：置当前结点的右孩子为当前节点
                root = root.getLeftNode();
                // 返回步骤1
            }
        }

        // 步骤8：输出中间栈的结点
        while(output.size()>0){
            printNode(output.pop());
        }
    }
```

##### 层次遍历

非递归实现，采用队列

```java
/**
  * 方式：非递归（采用队列）
  */
    public void levelTravel(Node root){
        // 创建队列
        Queue<Node> q=new LinkedList<Node>();

        // 1. 判断当前结点是否为空；若是，则返回空操作
        if(root==null)
            return;
        // 2. 入队当前结点
        q.add(root);

        // 3. 判断当前队列是否为空，若为空则跳出循环
        while(!q.isEmpty()){

            // 4. 出队队首元素
            root =  q.poll();

            // 5. 输出 出队元素
            printNode(root);

            // 6. 若出队元素有左孩子，则入队其左孩子
            if(root.getLeftNode()!=null) q.add(root.getLeftNode());

            // 7. 若出队元素有右孩子，则入队其右孩子
            if(root.getRightNode()!=null) q.add(root.getRightNode());
        }
    }

```

#### 二叉搜索树的后序遍历序列

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

```java
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }
    
    public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (sequence == null || sequence.length == 0) return false;
        if (end - start <= 1) return true;
        int root = sequence[end];
        int index = 0;
        while (sequence[index] < root) {
            index++;
        }
        for (int i = index; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return VerifySquenceOfBST(sequence, 0, index - 1) && VerifySquenceOfBST(sequence, index, end - 1);
    }
}
```

二叉树中和为某一值的路径

输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

```java
import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root != null) {
            findPath(root, target, new ArrayList<Integer>());
        }
        return paths;
    }
    
    public void findPath(TreeNode root, int target, ArrayList<Integer> path) {
        path.add(root.val);
        int rest = target - root.val;
        if (rest > 0) {
            if (root.left != null) {
                findPath(root.left, rest, path);
            }
            if (root.right != null) {
                findPath(root.right, rest, path);
            }
        } else if (rest == 0 && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        }
        path.remove(path.size() - 1);
    }
}
```

### 算法

#### 斐波那契数列

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。

n<=39

```java
public class Solution {
    public int Fibonacci(int n) {
		int a = 0, b = 1;
        if (n==0) return a;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
```

#### 跳台阶

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

```java
public class Solution {
    public int JumpFloor(int target) {
		if (target == 1) return 1;
        if (target == 2) return 2;
        int n1 = 1, n2 = 2;
        for (int i = 3; i <= target; i++) {
            int temp = n2 + n1;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}
```

#### 变态跳台阶

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

```java
public class Solution {
    public int JumpFloorII(int target) {
     	if (target == 1) return 1;
        else return 2 * JumpFloorII(target - 1);   
    }
}
```

#### 矩形覆盖

我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

```java
public class Solution {
    public int RectCover(int target) {
		if (target == 0) return 1;
        if (target == 1) return 1;
        int n0 = 1, n1 = 1;
        for (int i = 2; i <= target; i++) {
            int temp = n0 + n1;
            n0 = n1;
            n1 = temp;
        }
        return n1;
    }
}
```

#### 整数中 1 出现的次数

求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。

```java
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
    	int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                if (num % 10 == 1)
                    count++;
                num /= 10;
            }
        }
        return count;
    }
}
```

