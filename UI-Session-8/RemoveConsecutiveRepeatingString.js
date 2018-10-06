function removeConsecutiveRepeatingString(inputString) {
	
	var index;
	var newString = inputString;
	
	var initialIndex, finalIndex = 0;
	for(index = 0; index < newString.length-1; index++) {
		initialIndex = index;
		while (newString.charAt(index) == newString.charAt(index+1)) {
			console.log(index);
			finalIndex = index+1;
			index++;
		}
	    newString = newString.substring(0, initialIndex) + newString.substring(finalIndex+1, inputString.length-1);
	}	
	console.log(newString);
}

removeConsecutiveRepeatingString("eeabcddcbfgf");