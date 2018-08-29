	function editProfile()
	{
		var editButton = document.getElementById('submitButton');
			
		if(editButton.value == 'Edit Profile')
		{
			editInfo(editButton);
		}
		else{
			updateInfo(editButton);
		}
	}

	function editInfo(editButton)
	{	
		firstName.value = "First Name";
		lastName.value = "Last Name";
		email.value = "email@em.in";
		password.value = "Password";
		confirmPassword.value = "Password";
		contactNumber.value = "12345678";
		
		editButton.value = "Update";
	}

	function updateInfo(editButton)
	{
		firstName.value = "";
		lastName.value = "";
		email.value = "";
		password.value = "";
		confirmPassword.value = "";
		contactNumber.value = "";
		
		editButton.value = "Edit Profile";
	}

	function getValues()
	{
		var firstName = document.getElementById('firstName');
		var lastName = document.getElementById('lastName');
		var email = document.getElementById('email');
		var password = document.getElementById('password');
		var confirmPassword = document.getElementById('confirmPassword');
		var contactNumber = document.getElementById('contactNumber');
	}
