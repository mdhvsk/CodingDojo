/* 
TODO: Create the DLLNode class and implement the DoublyLinkedList constructor
and the empty methods below the constructor.
*/

/**
 * A class to represent a doubly linked list and contain all of it's methods.
 * A doubly linked list is a singly linked list that can be traversed in both
 * directions.
 */


class ListNode {

    constructor(data){
        this.head = data

        this.next = null

        this.prev = null
    }
}
 class DoublyLinkedList {
    /**
     * Executed when the new keyword is used to construct a new DoublyLInkedList
     * instance that inherits these methods and properties.
     */
    constructor() {
        this.head = null
        this.tail = null
      // TODO: implement the constructor.
    }
  
    /**
     * TODO: Implement this method
     * Creates a new node and adds it at the front of this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} data The data for the new node.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtFront(data) {
        var node = new ListNode(data)
        var currHead = this.head
        this.head = node
        if(currHead != null){
          currHead.prev = node
          node.next = currHead
        }
        else{
          this.tail = node
          this.head = this.tail
        }
        return


    }
  
    /**
     * TODO: Implement this method
     * Creates a new node and adds it at the back of this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} data The data for the new node.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtBack(data) {
      var node = new ListNode(data)
      var currTail = this.tail
      this.tail = node
      if(currTail != null) {
        currTail.next = node
        node.prev = currTail
      }
      else {
        this.tail.prev = this.head
      }

    }
  // EXTRA
  /**
   * TODO: Implement this method
   * Removes the middle node in this list.
   * NOTE: If length of DLL is even, then there is no middle node. Need to check for this somehow...
   * - Time: O(?).
   * - Space: O(?).
   * @returns {any} The data of the removed node.
   */
   removeMiddleNode() {
    var vals = this.toArray;
    var listLength = vals.length;
    if(listLength % 2 == 0 || listLength == 1){
      return "No Middle Node!"
    }
    var index = Math.floor(listLength/2)
    var runner = this.head;
    for(var i = 0; i < index + 1; i++){
      runner = runner.next;
    }
    return vals[index];
  } 
  
    /**
     * Determines if this list is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean} Indicates if this list is empty.
     */
    isEmpty() {
      return this.head === null;
    }
  
    /**
     * Converts this list to an array of the node's data.
     * - Time: O(n) linear, n = list length.
     * - Space: O(n) linear, array grows as list length increases.
     * @returns {Array<any>} All the data of the nodes.
     */
    toArray() {
      const vals = [];
      let runner = this.head;
  
      while (runner) {
        vals.push(runner.data);
        runner = runner.next;
      }
      return vals;
    }
  
    /**
     * Adds all the given items to the back of this list.
     * @param {Array<any>} items Items to be added to the back of this list.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtBackMany(items = []) {
      items.forEach((item) => this.insertAtBack(item));
      return this;
    }
  }
  
  const emptyList = new DoublyLinkedList();
  
  /**************** Uncomment these test lists after insertAtBack is created. ****************/
  // const singleNodeList = new DoublyLinkedList().insertAtBack(1);
  // const biNodeList = new DoublyLinkedList().insertAtBack(1).insertAtBack(2);
  // const firstThreeList = new DoublyLinkedList().insertAtBackMany([1, 2, 3]);
  // const secondThreeList = new DoublyLinkedList().insertAtBackMany([4, 5, 6]);
//   const unorderedList = new DoublyLinkedList().insertAtBackMany([
//     -5,
//     -10,
//     4,
//     -3,
//     6,
//     1,
//     -7,
//     -2,
//   ]);

//   console.log(unorderedList.toArray())


  const list = new DoublyLinkedList();
  list.insertAtFront(1)
  list.insertAtFront(2)  
  list.insertAtFront(3)
  list.insertAtFront(4)
  list.insertAtFront(5)
  list.insertAtFront(6)
  list.insertAtFront(7)
  list.insertAtFront(8)
  console.log(list.toArray())