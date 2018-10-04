var errorMap = new Map();

var errorAlert = "";
var firstNameValid = false;
var lastNameValid = false;
var emailValid = false;
var phoneValid = false;	
var zipcodeValid = false;
		
function firstNameValidate(firstName)
{
	var error = document.getElementById('fnameErr');
	var errorMsg = isNameValid(firstName.value);
    if(errorMsg != "")
    {
        firstName.style.border = "solid thin red";
		firstNameValid = false;
		errorMap.set("First Name", errorMsg);
		error.innerHTML = errorMsg;
		return false;
    }
    else{
		if(errorMap.has("First Name"))
			delete("First Name");
		firstName.style.borderColor = "";
		firstNameValid = true;
		error.innerHTML = "";
		return true;
    }
}

function lastNameValidate(lastName)
{
	var error = document.getElementById('lnameErr');
	var errorMsg = isNameValid(lastName.value);
    if(errorMsg != "")
    {
        lastName.style.border = "solid thin red";
		lastNameValid = false;
		errorMap.set("Last Name", errorMsg);
		error.innerHTML = errorMsg;
		return false;
    }
    else{
		if(errorMap.has("Last Name"))
			delete("Last Name");
		lastName.style.borderColor = "";
		lastNameValid = true;
		error.innerHTML = "";
		return true;
    }
}

function emailValidate(email)
{
	var error = document.getElementById('emailErr');
	var errorMsg = isEmailValid(email.value);
    if(errorMsg != "")
    {
        email.style.border = "solid thin red";
		emailValid = false;
		errorMap.set("Email", errorMsg);
		error.innerHTML = errorMsg;
		return false;
    }
    else{
		if(errorMap.has("Email"))
			delete("Email");
		email.style.borderColor = "";
		emailValid = true;
		error.innerHTML = "";
		return true;
    }
}

function phoneValidate(phone)
{
	var error = document.getElementById('phoneErr');
    if(isNaN(phone.value))
    {
		errorMsg = "Only numbers will be present";
		errorMap.set("Phone", errorMsg);
        phone.style.borderColor = "solid thin red";
		error.innerHTML = errorMsg;
		phoneValid = false;
        return false;
    }
	else if(phone.value.length != 10) {
		errorMsg = "Number should contains 10 charater";
		errorMap.set("Phone", errorMsg);
        phone.style.borderColor = "solid thin red";
		error.innerHTML = errorMsg;
		phoneValid = false;
        return false;
	}
    else{
		if(errorMap.has("Phone"))
			errorMap.delete("Phone");
        phone.style.borderColor = "";
		error.innerHTML = "";
		phoneValid = true;
        return true;
    }
}

function isNameValid(name)
{
    if(name.length < 2)
    {
        return "Name will have atleast 2 characters";
    }
    var i;
    var upperCaseName = name.toUpperCase();
    for(i = 0; i < upperCaseName.length; i++)
    {
        var instanceValue = upperCaseName.charCodeAt(i);
        if(instanceValue < 65 || instanceValue > 90)
        {
            return "Name should contain only characters";
        }			
    }
    return "";
}

function isEmailValid(email)
{
	var atInstance = email.indexOf("@");
	var dotInstance = email.lastIndexOf(".");
	if(atInstance < 1)
	{
		return "There should be @ present";
	}
	else if(dotInstance <= atInstance + 1)
	{
		return "There shoulb be . present";
	}
	else if(dotInstance == email.length - 1)
	{
		return "Atleast 2 character will present after .";
	}
	else{
		return "";
	}
}

function stateChange()
{
	var countChildren = document.getElementById("contactForm").children.length;
	var stateRef = document.getElementById("stateSelect");
	
    var referenceNode = stateRef.parentNode.parentNode;	
		
	var zipcode = document.createElement("div");
	zipcode.className = "form-element";
	zipcode.innerHTML = "<div id='zipcodeLabel' class='label'><label><strong>Zip Code<span>*</span></strong></label></div><div id='zipcodeIcon' class='icon'><span><i class='fas fa-home'></i></span></div><div id='zipcode' class='input-field-div'><input type='text' placeholder='Zip Code' id='zipcodeValue' maxlength='6' required class='input-field' onblur='zipcodeValidate(this)'><p id='zipErr'></p></div>";			
					
	var website = document.createElement("div");
	website.className = "form-element";
	website.innerHTML = "<div id='websiteLabel' class='label'><label><strong>Website or domain name</strong></label></div><div id='websiteIcon' class='icon'><span><i class='fas fa-globe'></i></span></div><div id='website' class='input-field-div'><input type='text' placeholder='Website or domain name' id='websiteValue' class='input-field'></div>";
					
    var hosting = document.createElement("div");
	hosting.className = "form-element";
	hosting.innerHTML = "<div id='hostingLabel' class='label'><label><strong>Do you have hosting?</strong></label></div><div id='hosting' class='input-field-div'><input type='radio' name='hosting' id='yes_hosting'/>Yes <br /><input type='radio' value='No' name='hosting' id='no_hosting'/>No <br /></div>";
					
    var project = document.createElement("div");
	project.className = "form-element";
	project.innerHTML = "<div id='projectLabel' class='label'><label><strong>Project Description<span>*</span></strong></label></div><div id='projectIcon' class='icon'><span><i class='fas fa-pencil-alt'></i></span></div><div id='project' class='input-field-div'><textArea type='text' placeholder='Project Description' id='projectValue' required class='input-field'></textArea></div>";
			
	if(countChildren == 10) {
        var parentForm = document.getElementById("contactForm");
        var item1 = parentForm.childNodes[14];
        var item2 = parentForm.childNodes[15];
        
        parentForm.removeChild(item1);
        parentForm.removeChild(item2);
    }				
	
	console.log(stateRef.value);
	
	if(stateRef.value == 'Rajasthan') {
        referenceNode.parentNode.insertBefore(project, referenceNode.nextSibling);
        referenceNode.parentNode.insertBefore(website, referenceNode.nextSibling);
    }
    else if(stateRef.value == "Haryana") {
        referenceNode.parentNode.insertBefore(hosting, referenceNode.nextSibling);
        referenceNode.parentNode.insertBefore(zipcode, referenceNode.nextSibling);
    }
    else if(stateRef.value == "Maharashtra") {
        referenceNode.parentNode.insertBefore(project, referenceNode.nextSibling);
        referenceNode.parentNode.insertBefore(zipcode, referenceNode.nextSibling);
    }
}

function zipcodeValidate(zipcode) {
	var error = document.getElementById("zipErr");
	if(isNaN(zipcode.value))
    {
		var errorMsg = "Only numbers will be present";
        zipcode.style.borderColor = "solid thin red";
		error.innerHTML = errorMsg;
		errorMap.set("Zip", errorMsg);
		zipcodeValid = false;
        return false;
    }
	else if(zipcode.value.length != 6) {
		var errorMsg = "6 charater should be present";
		errorMap.set("Zip", errorMsg);
        phone.style.borderColor = "solid thin red";
		error.innerHTML = errorMsg;
		zipcodeValid = false;
        return false;
	}
    else{
		if(errorMap.has("Zip"))
			delete("Zip");
        zipcode.style.borderColor = "";
		error.innerHTML = "";
		zipcodeValid = true;
        return true;
    }
}

function submitForm()
{
	var firstName = document.getElementById("firstNameValue");
	var contactNumber = document.getElementById("phoneValue");
	var email = document.getElementById("emailValue");
	var state = document.getElementById("stateSelect");
	
	localStorage.clear();
    localStorage.setItem("First Name", firstName.value);
    localStorage.setItem("Email", email.value);
    localStorage.setItem("Phone #", contactNumber.value);
	
	var lastName = document.getElementById("lastName");
    if(lastName.value != "") {
        localStorage.setItem("Last Name", lastName.value);
    }
        
    var address = document.getElementById("addressValue");
    if(address.value != "") {
        localStorage.setItem("Address", address.value);
    }
        
    var city = document.getElementById("cityValue");
    if(city.value != "") {
        localStorage.setItem("City", city.value);
    }
    
    localStorage.setItem("State", state.value);
    if(state.value == "Rajasthan") {
        alert("Raj");
        var project_description = document.getElementById("projectValue");
            
        if (project_description.value != ""){
            localStorage.setItem("Project Description", project_description.value);
        }
            
        var website = document.getElementById("websiteValue");
        alert(website);
        if(website.value != "") {
            localStorage.setItem("Website or domain name", website.value);
        }
    }
    else if(state.value == "Haryana") {
        var zipcode = document.getElementById("zipcodeValue");
        if (zipcode.value != ""){
            localStorage.setItem("Zip Code",  zipcode.value);
        }
            
        var yesHosting = document.getElementById("yes_hosting");
        var noHosting = document.getElementById("no_hosting");
            
        if(yesHosting.checked) {
            alert("yes");
            localStorage.setItem("Has Hosting", yesHosting.value);
        }
        else if(noHosting.checked) {
            alert("No");
            localStorage.setItem("Has Hosting", noHosting.value);
        }
    }
    else if(state.value == "Maharastra") {
        var zipcode = document.getElementById("zipcodeValue");
        if (zipcode.value != ""){
            localStorage.setItem("Zip Code",  zipcode.value);
        }
            
        var project_description = document.getElementById("project_description");
        if (project_description.value != ""){
            localStorage.setItem("Project Description", project_description.value);
        }
    }
	
	if(firstNameValid & lastNameValid & emailValid & phoneValid & zipcodeValid) {
		document.contactForm.submit();
		return true;
    }
	else {
		var keys = errorMap.keys();
		var message = "";
		
		for(var key of keys)
		{
			message += key + " : " + errorMap.get(key) + "\n";
		}
		
		alert("Error is/are: \n" + message);
		return false;
	}
}