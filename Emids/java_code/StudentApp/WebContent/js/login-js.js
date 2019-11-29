$(document).ready(function(){

	$("#login_form").validate({
		rules:{

		regno:{	
			required : true
		},
		pswd:{
			required : true
		}
	},

	messages :{
		regno:{
			required: "Please enter a username"
		},
		pswd:{
			required : "Please register a password"
		}

	}
});
});