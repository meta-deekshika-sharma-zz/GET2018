//This function defines the node of queue using linked list
function Node(data) {
	this.data = data;
	this.next = null;
}

//This function defines a queue object
function Queue() {
	this.front = null;
	this.rear = null;
}

//This function returns the peek value
Queue.prototype.peek = function() {
	console.log(this.rear.data);
} 

//This function return the true if queue is empty
Queue.prototype.isEmpty = function() {
	return (this.front == null);
}

//This function enqueue the data in queue 
Queue.prototype.enqueue = function(value) {
	var node = new Node(value);
 
	if (this.rear != null) {
		this.rear.next = node;
		this.rear = node;
	} else {
		this.front = node;
		this.rear = node;
	}
};

//This function will print the data in queue
Queue.prototype.printList = function() {
	var currentNode = this.front; 
	var str = ""; 
	while (currentNode) { 
		str += currentNode.data + " "; 
		currentNode = currentNode.next; 
	} 
	console.log(str);
}

//This function will remove the data from queue
Queue.prototype.dequeue = function() {
	var currentNode = this.front,
	    message = {failure: 'Failure: Underflow exception'},
	    deleteNode = null;
 
	if (this.isEmpty()) {
		throw new Error(message.failure);
	} else {
		if (this.front == this.rear) {
			this.rear = null;
		}
		deleteNode = this.front;
		this.front = this.front.next;
	}
};

var queue = new Queue();  
queue.enqueue(10); 

//print 10
queue.printList(); 
   
queue.enqueue(20); 
queue.enqueue(30); 
queue.enqueue(40); 
queue.enqueue(50); 

//print 10 20 30 40 50   
queue.printList(); 

queue.dequeue();

//print 50
queue.peek();
queue.dequeue();
queue.dequeue();
queue.dequeue();
queue.dequeue();
queue.dequeue(); // Underflow exception
queue.printList();
