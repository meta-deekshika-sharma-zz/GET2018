//This function defines the node of stack using linked list
function Node(data) {
	this.data = data;
	this.link = null;
}

//This function defines a stack object
function Stack() {
	this.top = null;
}

//This function returns the peek value
Stack.prototype.peek = function() {
	console.log(this.top.data);
} 

//This function return the true if stack is empty
Stack.prototype.isEmpty = function() {
	return (this.top == null);
} 

//This function push the data in stack 
Stack.prototype.push = function(value) {
	var node = new Node(value);
	
	if (this.top != null) {
		node.link = this.top;
	}
	this.top = node;
};

//This function will print the data in stack
Stack.prototype.printList = function() {
	var currentNode = this.top; 
	var str = ""; 
	
	while (currentNode) {
		str += currentNode.data + " "; 
		currentNode = currentNode.link;
	} 
	console.log(str);
}

//This function will remove the data from stack
Stack.prototype.pop = function() {
	var currentNode = this.top,
	    message = {failure: 'Failure: Underflow exception'},
	    deleteNode = null;
 
	if (this.isEmpty()) {
		throw new Error(message.failure);
	} else {
		deleteNode = this.top;
		this.top = deleteNode.link;
		deleteNode.link = null;
	}
};

var stack = new Stack();  
stack.push(10); 

//print 10
stack.printList(); 
   
stack.push(20); 
stack.push(30); 
stack.push(40); 
stack.push(50); 

//print 10 20 30 40 50   
stack.printList(); 

stack.pop();
stack.pop();

//print 30 20 10
stack.printList();
stack.pop();
stack.pop();

//print 10
stack.peek();

stack.pop();
stack.pop(); // Underflow exception
