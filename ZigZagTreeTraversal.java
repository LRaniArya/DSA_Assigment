/**

 * 
 * @Name Lata Rani
 * @RollNo 2018ht12140
 *

 */

/**
 * 
 * Stack implementation, which is internally used by 
 * BinaryTree while doing ZigZagTreeTraversal
* @param <T>
 */

class Stack<T extends Object> 

{


    private int stackSize;

    private T[] stackArr;

    private int top;

     

    /**

     * constructor to create stack with size

     * @param size

     */

    @SuppressWarnings("unchecked")

    public Stack(int size) 

    {

        this.stackSize = size;

        this.stackArr = (T[]) new Object[stackSize];

        this.top = -1;

    }

 

    /**

     * This method adds new entry to the top 

     * of the stack

     * @param entry

     * @throws Exception 

     */

    public void push(T entry)

    {

        if(this.isStackFull())

        {

            this.increaseStackCapacity();

        }

        this.stackArr[++top] = entry;

    }

 

    /**

     * This method removes an entry from the 

     * top of the stack.

     * @return

     * @throws Exception 

     */

    public T pop() throws Exception 

    {

        if(this.isEmpty())

        {

            throw new Exception("Stack is empty. Can not remove element.");

        }

        T entry = this.stackArr[top--];

        return entry;

    }

     

    /**

     * This method returns top of the stack

     * without removing it.

     * @return

     */

    public T peek() 

    {

        return stackArr[top];

    }

 

    private void increaseStackCapacity()

    {

        @SuppressWarnings("unchecked")

        T[] newStack = (T[]) new Object[this.stackSize*2];

        

        for(int i=0;i<stackSize;i++)

        {

            newStack[i] = this.stackArr[i];

        }

        this.stackArr = newStack;

        this.stackSize = this.stackSize*2;

    }

     

    /**

     * This method returns true if the stack is 

     * empty

     * @return

     */

    public boolean isEmpty() 

    {

        return (top == -1);

    }

 

    /**

     * This method returns true if the stack is full

     * @return

     */

    public boolean isStackFull() 

    {

        return (top == stackSize - 1);

    }


@Override

public String toString() {

try 

{

return "Stack [pop()=" + pop() + "]";

} 

catch (Exception e) 

{

e.printStackTrace();

return null;

}

}

}


/************************Node Class*************************/


/**

 * 

 * Binary Tree node definition with 

 * left and right child and data node

 *

 */


class Node 

{ 

int data; 

Node leftChild; 

Node rightChild;


Node(int data) 

{

this.data = data; 

} 

} 


/************************BinaryTree Class*************************/


class BinaryTree 

{ 

Node rootNode;


/**

* Initialize the stack with size 5, 

* you can initialize with any integer, 

* it will dynamically increase the size by 

* invoking increaseStackCapacity() once the stack is full

*/

Stack<Node> currentLevel = new Stack<>(5); 

Stack<Node> nextLevel = new Stack<>(5); 


/**

* 

* Logic to print the tree

* in ZigZag traversal

*/

void printZigZagTraversal() throws Exception 

{

currentLevel.push(rootNode); 

boolean leftToRight = true; 


if (rootNode == null) 

{

return; 

} 


while (!currentLevel.isEmpty()) 

{

Node node = currentLevel.pop(); 

System.out.print(node.data + " "); 


if (leftToRight) 

{

if (node.leftChild != null) { 

nextLevel.push(node.leftChild); 

} 


if (node.rightChild != null) { 

nextLevel.push(node.rightChild); 

} 

} 

else 

{

if (node.rightChild != null) 

{ 

nextLevel.push(node.rightChild); 

} 


if (node.leftChild != null) 

{ 

nextLevel.push(node.leftChild); 

} 

}


if (currentLevel.isEmpty()) 

{

leftToRight = !leftToRight; 

Stack<Node> temp = currentLevel; 

currentLevel = nextLevel; 

nextLevel = temp; 

} 

} 

} 

}



/**

 * 

 * Test case to print ZigZag 

 * Tree Traversal

 *

 */

public class ZigZagTreeTraversal 

{ 

public static void main(String...args) throws Exception 

{ 

BinaryTree tree = new BinaryTree(); 

tree.rootNode = new Node(1); 

tree.rootNode.leftChild = new Node(2); 

tree.rootNode.rightChild = new Node(3); 

tree.rootNode.leftChild.leftChild = new Node(4); 

tree.rootNode.leftChild.rightChild = new Node(5); 

tree.rootNode.rightChild.leftChild = new Node(6); 

tree.rootNode.rightChild.rightChild = new Node(7); 


System.out.print("ZigZag Order traversal of binary tree is >> "); 

tree.printZigZagTraversal(); 

} 

}
