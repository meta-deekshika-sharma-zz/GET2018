//This function defines the node of linked list
function Node(data) {
    this.data = data;
    this.next = null;
}

//This function defines a singly linked list object
function SinglyList() {
    this.size = 0;
    this.head = null;
}

//This add function add value at the starting of list
SinglyList.prototype.add = function(value) {
    var node = new Node(value),
        currentNode = this.head;
 
    if (!currentNode) {
        this.head = node;
        this.size++;
        return node;
    }
 
    while (currentNode.next) {
        currentNode = currentNode.next;
    }
 
    currentNode.next = node;
    this.size++;
    return node;
};

//This function search node at a specified position
SinglyList.prototype.searchNodeAt = function(position) {
    var currentNode = this.head,
    size = this.size,
    count = 1,
    message = {failure: 'Failure: non-existent node in this list.'};

    if (size === 0 || position < 1 || position > size) {
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
SinglyList.prototype.printList = function() {
	var currentNode = this.head; 
    var str = ""; 
    while (currentNode) { 
        str += currentNode.data + " "; 
        currentNode = currentNode.next; 
    } 
    console.log(str);
}

//This function will remove the element at the specified position
SinglyList.prototype.remove = function(position) {
    var currentNode = this.head,
    size = this.size,
    count = 1,
    message = {failure: 'Failure: non-existent node in this list.'},
    beforeNodeToDelete = null,
    nodeToDelete = null;
 
    if (position < 0 || position > size) {
        throw new Error(message.failure);
    }

    if (position === 1) {
        this.head = currentNode.next;
        deletedNode = currentNode;
        currentNode = null;
        this.size--;
    }
 
    while (count < position) {
        beforeNodeToDelete = currentNode;
        nodeToDelete = currentNode.next;
		currentNode = currentNode.next;
        count++;
    }
 
    beforeNodeToDelete.next = nodeToDelete.next;
    deletedNode = nodeToDelete;
    nodeToDelete = null;
    this.size--;
};

var singlyList = new SinglyList();  
singlyList.add(10); 

//print 10
singlyList.printList(); 
   
singlyList.add(20); 
singlyList.add(30); 
singlyList.add(40); 
singlyList.add(50); 

//print 10 20 30 40 50   
singlyList.printList(); 

//print 40
singlyList.searchNodeAt(4); 
singlyList.remove(4);

//print 10 20 30 50
singlyList.printList();