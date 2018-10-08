
function removeConsecutiveRepeatingString(inputString) {
   var count=0;
   
   for (var index = 0; index < inputString.length-1; index++) {
      if (inputString[index]===inputString[index + 1]) {
         count++;
      } else {
         if (count>0) {
            inputString = inputString.substring(0,index-count).concat(inputString.substring(index+1,inputString.length));
            index=0;
         }
         count=0;
      }
   }
   console.log(inputString);
   return inputString;
}
