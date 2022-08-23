/**
 * Class to represent a stack using an array to store the stacked items.
 * Follows a LIFO (Last In First Out) order where new items are stacked on
 * top (back of array) and removed items are removed from the top / back.
 */
 class Stack {
    /**
     * The constructor is executed when instantiating a new Stack() to construct
     * a new instance.
     * @returns {Stack} This new Stack instance is returned without having to
     *    explicitly write 'return' (implicit return).
     */
    constructor() {
      this.items = [];
    }
  
    /**
     * TODO: implement this method
     * Adds a new given item to the top / back of this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @param {any} item The new item to be added to the top / back.
     * @returns {number} The new length of this stack.
     */
    push(item) {
        this.items.push(item)
        return this.size()
    }
  
    /**
     * TODO: implement this method
     * Removes the top / last item from this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The removed item or undefined if this stack was empty.
     */
    pop() {
        return this.items.pop()

    }
  
    /**
     * TODO: implement this method
     * Retrieves the top / last item from this stack without removing it.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The top / last item of this stack.
     */
    peek() {
        return this.items[this.size() -1]
    }
  
    /**
     * TODO: implement this method
     * Returns whether or not this stack is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean}
     */
    isEmpty() {
        return this.size() == 0
    }
  
    /**
     * TODO: implement this method
     * Returns the size of this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {number} The length.
     */
    size() {
        return this.items.length
    }
  }

  const stack1 = new Stack()
  console.log(stack1.isEmpty())
  console.log(stack1.push(3))
//   console.log(stack1.peek())

  console.log(stack1.push(9))
//   console.log(stack1.peek())

  console.log(stack1.push(6))
//   console.log(stack1.peek())
console.log(stack1.pop())
console.log(stack1.peek())

  console.log(stack1.push(89))
//   console.log(stack1.peek())
console.log(stack1.isEmpty())






  
  class StackNode {
    constructor(data) {
      this.data = data;
      this.next = null;
    }
  }
  
  class LinkedListStack {
    constructor() {
      this.head = null;
    }
  
    /**
     * TODO: implement this method
     * Adds a new given item to the top / back of this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @param {any} item The new item to be added to the top / back.
     * @returns {number} The new length of this stack.
     */
     push(item) {
        var currHead = this.head
        var newNode = new StackNode(item)
        this.head = newNode
        this.head.next = currHead
        return this.size()
     }
  
     /**
      * TODO: implement this method
      * Removes the top / last item from this stack.
      * - Time: O(1) constant.
      * - Space: O(1) constant.
      * @returns {any} The removed item or undefined if this stack was empty.
      */
     pop() {
        var currHead = this.head
        this.head = this.head.next
        currHead.next = null
        return currHead
     }
   
     /**
      * TODO: implement this method
      * Retrieves the top / last item from this stack without removing it.
      * - Time: O(1) constant.
      * - Space: O(1) constant.
      * @returns {any} The top / last item of this stack.
      */
     peek() {
        return this.head
     }
   
     /**
      * TODO: implement this method
      * Returns whether or not this stack is empty.
      * - Time: O(1) constant.
      * - Space: O(1) constant.
      * @returns {boolean}
      */
     isEmpty() {
        return this.head == null
     }
   
     /**
      * TODO: implement this method
      * Returns the size of this stack.
      * - Time: O(1) constant.
      * - Space: O(1) constant.
      * @returns {number} The length.
      */
     size() {
        var runner = this.head
        var counter = 0
        while (runner != null){
            runner = runner.next
            counter++
        }
        return counter 
     }
  }

  const linkedStack1 = new LinkedListStack()
  console.log(linkedStack1.isEmpty())
  console.log(linkedStack1.push(12))

  console.log(linkedStack1.push(68))
  console.log(linkedStack1.peek())


  console.log(linkedStack1.pop())
  console.log(linkedStack1.isEmpty())

  console.log(linkedStack1.push(1))
  console.log(linkedStack1.peek())





