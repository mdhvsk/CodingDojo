/**
 * Class to represent a MinHeap which is a Priority Queue optimized for fast
 * retrieval of the minimum value. It is implemented using an array but it is
 * best visualized as a tree structure where each 'node' has left and right
 * children except the 'node' may only have a left child.
 * - parent is located at: Math.floor(i / 2);
 * - left child is located at: i * 2
 * - right child is located at: i * 2 + 1
 *
 * USING 0 index
 * - parent is located at: Math.floor((i - 1) / 2);
 * - left child is located at: (i * 2) + 1
 * - right child is located at: (i * 2) + 2
 */
 class MinHeap {
    constructor() {
      /**
       * 0th index not used, so null is a placeholder. Not using 0th index makes
       * calculating the left and right children's index cleaner.
       * This also effectively makes our array start at index 1.
       */
      this.heap = [null];
    }
  
    /**
     * Retrieves the top (minimum number) in the heap without removing it.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {?number} Null if empty.
     */
    top() {
      return this.heap.length > 1 ? this.heap[1] : null;
    }
  
    /**
     * Inserts a new number into the heap and reorders heap to maintain order.
     * 1. Push new num to back.
     * 2. Iteratively swap the new num with it's parent while it is smaller than
     *    it's parent.
     * - Time: O(log n) logarithmic due to shiftUp.
     * - Space: O(1) constant.
     * @param {number} num The num to add.
     */
    // insert(num) {
    //   this.heap.push(num);
    //   this.shiftUp();
    //   // .push on array returns the new length
    //   return this.size();
    // }

    insert(num) {
        this.heap.push(num)
        var lastIndex = this.heap.length-1;
        var parentIndex = Math.floor((lastIndex)/2)
        var tempParent;
        var tempLast
        var counter=0;
        while (parentIndex != 0){
            counter ++;
            if(this.heap[lastIndex] < this.heap[parentIndex]){
                tempParent = this.heap[parentIndex]
                tempLast = this.heap[lastIndex]
                this.heap[lastIndex] = tempParent
                this.heap[parentIndex] = tempLast
            }
            else break;
            lastIndex = parentIndex
            parentIndex = Math.floor((lastIndex-1)/2)
        }
        console.log(counter)
    }
  
    // AKA: siftUp, heapifyUp, bubbleUp to restore order after insert
    shiftUp() {
      let idxOfNodeToShiftUp = this.heap.length - 1;
  
      while (idxOfNodeToShiftUp > 1) {
        const idxOfParent = this.idxOfParent(idxOfNodeToShiftUp);
  
        const isParentSmallerOrEqual =
          this.heap[idxOfParent] <= this.heap[idxOfNodeToShiftUp];
  
        // Parent is supposed to be smaller so ordering is complete.
        if (isParentSmallerOrEqual) {
          break;
        }
  
        this.swap(idxOfNodeToShiftUp, idxOfParent);
        // after swapping the node is at idxOfParent now.
        idxOfNodeToShiftUp = idxOfParent;
      }
    }
  
    // ======================================================
    // DAY 2
    // ======================================================
    
    /**
     * Extracts the min num from the heap and then re-orders the heap to
     * maintain order so the next min is ready to be extracted.
     * 1. Save the first node to a temp var.
     * 2. Pop last node off and set idx1 equal to the popped value.
     * 3. Iteratively swap the old last node that is now at idx1 with it's
     *    smallest child IF the smallest child is smaller than it.
     * - Time: O(log n) logarithmic due to shiftDown.
     * - Space: O(1) constant.
     * @returns {?number} The min number or null if empty.
     */
     extract() {
        // var temp = 

        var temp = this.heap[1]
        this.heap[1] = this.heap.pop()
        var parentIndex = 1
        var leftChild = parentIndex * 2
        var rightChild = (parentIndex * 2) + 1
        while((this.heap[parentIndex] > this.heap[leftChild] ||  this.heap[parentIndex] > this.heap[rightChild]) && (this.heap[leftChild] || this.heap[rightChild])){
            if (this.heap[leftChild] < this.heap[rightChild]){
                var tempParent = this.heap[parentIndex]
                var tempChild = this.heap[leftChild]
                this.heap[leftChild] = tempParent
                this.heap[parentIndex] = tempChild
                parentIndex = leftChild

            }
            else {
                var tempParent = this.heap[parentIndex]
                var tempChild = this.heap[rightChild]
                this.heap[rightChild] = tempParent
                this.heap[parentIndex] = tempChild
                parentIndex = rightChild

            }
            leftChild = parentIndex * 2
            rightChild = (parentIndex * 2) + 1
        }


        return temp 
     }
  
    /**
     * Logs the tree horizontally with the root on the left and the index in
     * parenthesis using reverse inorder traversal.
     */
    printHorizontalTree(parentIdx = 1, spaceCnt = 0, spaceIncr = 10) {
      if (parentIdx > this.heap.length - 1) {
        return;
      }
  
      spaceCnt += spaceIncr;
      this.printHorizontalTree(parentIdx * 2 + 1, spaceCnt);
  
      console.log(
        " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
          `${this.heap[parentIdx]} (${parentIdx})`
      );
  
      this.printHorizontalTree(parentIdx * 2, spaceCnt);
    }
  }

  const heap = new MinHeap()

  heap.insert(2)
  heap.insert(7)
  heap.insert(3)
  heap.insert(15)
  heap.insert(8)
  heap.insert(6)
//   heap.insert(21)
  heap.printHorizontalTree()
  heap.extract()
  console.log("--------------------------------")
  heap.printHorizontalTree()