    var firstNameValidate = false;
	var lastNameValidate = false;
	var emailValidate = false;
	var ageValidate = false;

	function addEmployee()
	{
		if(firstNameValidate && lastNameValidate &&  emailValidate && ageValidate)
		{	
		   document.addEmployeeForm.submit();
		}
		else{
			alert('Please fill all the fields');
		}
	}

	function validateFirstName()
	{
	
		var firstName = document.getElementById('firstName');
		if(isNameValid(firstName.value))
		{
			firstNameValidate = true;
			firstName.style.borderColor = "green";
			return true;
		}
		else{
			firstName.style.borderColor = "red";
			return false;
		}
	}

	function validateLastName()
	{
		var lastName = document.getElementById('lastName');
		if(isNameValid(lastName.value))
		{
			lastNameValidate = true;
			lastName.style.borderColor = "green";
			return true;
		}
		else{
			lastName.style.borderColor = "red";
			return false;
		}
	}

	function validateEmail()
	{
		var email = document.getElementById('email');
        
		emailValidate = true;
		email.style.borderColor = "green";
		return true;
	}

	function validateAge()
	{
		var age = document.getElementById('age');
		if(age.value >= '18' && age.value <= '70')
		{
			ageValidate = true;
			age.style.borderColor = "green";
			return true;
		}
		else{
			age.style.borderColor = "red";
			return false;
		}
	}	

	function isNameValid(name)
	{
		var i;
		var upperCaseName = name.toUpperCase();
		for(i = 0; i < upperCaseName.length; i++)
		{
			var instanceValue = upperCaseName.charCodeAt(i);
			if(instanceValue != 32 && instanceValue < 65 || instanceValue > 90)
			{
				return false;
			}			
		}
		return true;
	}
	
	function searchEmployee()
	{
		if(firstNameValidate)
		{
			 document.searchEmployeeForm.submit();
		}
	}