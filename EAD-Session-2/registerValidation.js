var firstNameValidate = false;
var lastNameValidate = false;
var emailValidate = false;
var passwordValidate = false;
var confirmPasswordValidate = false;
var contactNumberValidate = false;

function registerationValid()
{
	if(firstNameValidate && lastNameValidate &&  emailValidate && passwordValidate && confirmPasswordValidate && contactNumberValidate)
	{	
       document.registerForm.submit();
	}
	else{
		alert('Please fill all the fields');
	}
}

function firstNameValid()
{
	var firstName = document.getElementById('firstName');
	var firstNameSpan = document.getElementById('firstNameSpan');
	if(isNameValid(firstName.value))
	{
		firstNameValidate = true;
		firstName.style.borderColor = "green";
		firstNameSpan.innerHTML = "";
		return true;
	}
	else{
		firstName.style.borderColor = "red";
		firstNameSpan.innerHTML = "Invalid first name";
		return false;
	}
}

function lastNameValid()
{
	var lastName = document.getElementById('lastName');
	var lastNameSpan = document.getElementById('lastNameSpan');
	if(isNameValid(lastName.value))
	{
		lastNameValidate = true;
		lastName.style.borderColor = "green";
		lastNameSpan.innerHTML = "";
		return true;
	}
	else{
		lastName.style.borderColor = "red";
		lastNameSpan.innerHTML = "Invalid last name";
		return false;
	}
}

function emailValid()
{
	var email = document.getElementById('email');
	var emailSpan = document.getElementById('emailSpan');
	if(isEmailValid(email.value))
	{
		emailValidate = true;
		email.style.borderColor = "green";
		emailSpan.innerHTML = "";
		return true;
	}
	else{
		email.style.borderColor = "red";
		emailSpan.innerHTML = "Invalid email";
		return false;
	}
}

function passwordValid()
{
	var password = document.getElementById('password');
	var passwordSpan = document.getElementById('passwordSpan');
	if(isPasswordValid(password.value))
	{
		passwordValidate = true;
		password.style.borderColor = "green";
		passwordSpan.innerHTML = "";
		return true;
	}
	else{
		password.style.borderColor = "red";
		passwordSpan.innerHTML = "Invalid password";
		return false;
	}
}

function confirmPasswordValid()
{
	var confirmPassword = document.getElementById('confirmPassword');
	var confirmPasswordSpan = document.getElementById('confirmPasswordSpan');
	var password = document.getElementById('password');
	
	if(password.value === confirmPassword.value)
	{
		confirmPasswordValidate = true;
		confirmPassword.style.borderColor = "green";
		confirmPasswordSpan.innerHTML = "";
		return true;
	}
	else{
    	confirmPassword.style.borderColor = "red";
		confirmPasswordSpan.innerHTML = "Password and confirm password does not match";
		return false;
	}
}

function contactNumberValid()
{
	var contactNumber = document.getElementById('contactNumber');
	var contactNumberSpan = document.getElementById('contactNumberSpan');
	if(contactNumber.value.length >= 8)
	{
		contactNumberValidate = true;
		contactNumber.style.borderColor = "green";
		contactNumberSpan.innerHTML = "";
		return true;
	}
	else{
		contactNumber.style.borderColor = "red";
		contactNumberSpan.innerHTML = "Invalid Contact Number";
		return false;
	}
}	

function isNameValid(name)
{
	if(name.length < 2)
	{
		return false;
	}
	var i;
	var upperCaseName = name.toUpperCase();
	for(i = 0; i < upperCaseName.length; i++)
	{
		var instanceValue = upperCaseName.charCodeAt(i);
		if(instanceValue < 65 || instanceValue > 90)
		{
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
	else if(dotInstance <= atInstance + 1)
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
		var instanceValue = passwordInstance.charCodeAt(i);
		
		if(instanceValue < 32 || instanceValue > 38 && instanceValue < 48 || instanceValue > 57 && instanceValue < 64 || instanceValue > 90)
		{
			return false;
		}
	}
	return true;
}