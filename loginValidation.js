	function loginValid()
	{	
		if(emailValid() && passwordValid())
		{
			document.loginForm.submit();
		}
	}

