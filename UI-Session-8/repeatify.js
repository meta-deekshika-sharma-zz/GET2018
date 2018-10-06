function repeatify(inputString, occurance) {
	var resultString = "";
	
	while(occurance) {
		resultString += inputString;
		occurance--;
	}
	console.log(resultString);
}

repeatify("hello",5);