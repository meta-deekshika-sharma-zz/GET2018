function registerationValid()
{
	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById('lastName').value;
	var email = document.getElementById('email').value;
	var password = document.getElementById('password').value;
	var confirmPassword = document.getElementById('confirmPassword').value;
	var contactNumber = document.getElementById('contactNumber').value;
	
	
	if(firstNameValid(firstName) && lastNameValid(lastName) &&  emailValid(email) && passwordValid(password) && confirmPasswordValid(confirmPassword) && contactNumberValid(contactNumber))
	{
	    if(password === confirmPassword)
		{
			document.registerForm.submit();
		}
		else{
			alert("password and confirm password does not match");
		}
	}
}

function isNotEmpty(stringToVlidate)
{
	return stringToVlidate.length > 0;
}	

function firstNameValid(firstName)
{
	if(isNotEmpty(firstName) && isNameValid(firstName))
	{
		return true;
	}
	else{
		alert("first name is empty");
		return false;
	}
}

function lastNameValid(lastName)
{
	if(isNotEmpty(lastName) && isNameValid(lastName))
	{
		return true;
	}
	else{
		alert("last name is empty");
		return false;
	}
}

function emailValid(email)
{
	if(isNotEmpty(email) && isEmailValid(email))
	{
		return true;
	}
	else{
		alert("email is invalid");
		return false;
	}
}

function passwordValid(password)
{
	if(isPasswordValid(password))
	{
		return true;
	}
	else{
		alert("password is invalid");
		return false;
	}
}


function confirmPasswordValid(confirmPassword)
{
	if(isPasswordValid(confirmPassword))
	{
		return true;
	}
	else{
		alert("confirm password is invalid");
		return false;
	}
}

function contactNumberValid(contactNumber)
{
	if(contactNumber.length >= 8)
	{
		return true;
	}
	else{
		alert("contact is invalid");
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
		if(instanceValue < 65 || instanceValue > 90 && instanceValue != 32)
		{
			alert("Name does not contain only characters");
			return false;
		}			
	}
	return true;
}

function isEmailValid(email)
{
	var atInstance = email.indexOf("@");
	var dotInstance = email.lastIndexOf(".");
	if(atInstance < 1)
	{
		return false;
	}
	else if(dotInstance <= atInstance + 2)
	{
		return false;
	}
	else if(dotInstance == email.length - 2)
	{
		return false;
	}
	else{
		return true;
	}
}

function isPasswordValid(password)
{
	var passwordLength = password.length;
	var passwordInstance = password.toUpperCase();
	if(passwordLength < 8)
	{
		return false;
	}
	
	var i;
	for(i = 0; i < passwordLength; i++)
	{
		var instance = passwordInstance.charCodeAt(i);
		
		if(instance < 48 || instance > 57 && instance < 65 || instance > 90)
		{
			alert("password should contain only alphanumeric characters");
			return false;
		}
	}
	return true;
}