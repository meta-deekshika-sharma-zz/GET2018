//This function defines the node of linked list
function Node(data) {
    this.data = data;
    this.next = null;
	this.previous = null;
}

//This function defines a doubly linked list object
function DoublyList() {
    this.size = 0;
    this.head = null;
	this.tail = null;
}

//This add function add value at the starting of list
DoublyList.prototype.add = function(value) {
    var node = new Node(value);
 
    if (this.head) {
        this.tail.next = node;
		node.previous = this.tail;
		this.tail = node;
    } else {
		this.head = node;
		this.tail = node;
	}
	
    this.size++; 
    return node;
};

//This function search node at a specified position
DoublyList.prototype.searchNodeAt = function(position) {
    var currentNode = this.head,
    size = this.size,
    count = 1,
    message = {failure: 'Failure: non-existent node in this list.'};
 
    if (size == 0 || position < 1 || position > size) {
        throw new Error(message.failure);
    }
 
    while (count < position) {
        currentNode = currentNode.next;
        count++;
    }
    console.log(currentNode.data);
    return currentNode;
};

//This function will print the linked list data
DoublyList.prototype.printList = function() {
	var currentNode = this.head; 
    var str = ""; 
    while (currentNode) { 
        str += currentNode.data + " "; 
        currentNode = currentNode.next; 
    } 
    console.log(str);
}

//This function will remove the element at the specified position
DoublyList.prototype.remove = function(position) {
    var currentNode = this.head,
    size = this.size,
    count = 1,
    message = {failure: 'Failure: non-existent node in this list.'},
    beforeNodeToDelete = null,
	afterNodeToDelete = null,
    nodeToDelete = null;
 
    if (size === 0 || position < 0 || position > size) {
        throw new Error(message.failure);
    }

    if (position === 1) {
        this.head = currentNode.next;
		
		if(!this.head) {
			this.tail = null;
		} else {
			this.head.previous = null;
		}
    } else if (position == this.size) {
		this.tail = this.tail.previous;
		this.tail.next = null;
	} else {
		while (count < position) {
			currentNode = currentNode.next;
			count++;
		}
		
		beforeNodeToDelete = currentNode.previous;
		afterNodeToDelete = currentNode.next;
		
		beforeNodeToDelete.next = afterNodeToDelete;
		afterNodeToDelete.previous = beforeNodeToDelete;
		nodeToDelete = currentNode;
		currentNode = null;
	}
};

var doublyList = new DoublyList();
doublyList.add(10);

//print 10
doublyList.printList();

doublyList.add(20); 
doublyList.add(30); 
doublyList.add(40); 
doublyList.add(50); 

//print 10 20 30 40 50   
doublyList.printList();

//print 30
doublyList.searchNodeAt(3);
doublyList.remove(3);

//print 10 20 40 50
doublyList.printList();