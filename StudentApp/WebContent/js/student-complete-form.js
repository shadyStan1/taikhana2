$(document).ready(function(){
	
	$("#student_profile").validate({
		rules:{

		regno:{	
			required : true,
			minlength : 2
		},
		pswrd:{	
			required : true,
			minlength : 5
		},
		stuFName:{	
			required : true
		},
		guarFName:{	
			required : true,
		},
		homeno:{	
			required : true,
		},
		area:{	
			required : true,
		},
		city:{	
			required : true,
		},
		country:{	
			required : true,
		},
		pincode:{	
			required : true,
			minlength : 6
		}
	},

	messages :{
		regno:{
			required: "Please enter a registration no",
			minlength: "Registration No should be of 2 digits atleast"
		},
		pswrd:{	
			required : "Please enter a password",
			minlength : "Password should be of 5 digits atleast"
		},
		stuFName:{	
			required : "Please enter your first name"
		},
		guarFName:{	
			required : "Please enter guardian first name"
		},
		homeno:{	
			required : "Please enter your homeno"
		},
		area:{	
			required : "Please enter your area"
		},
		city:{	
			required : "Please enter your city",
		},
		country:{	
			required : "Please enter your country",
		},
		pincode:{	
			required : "Please enter your pincode",
			minlength : "Pincode should be 6 digit long"
		}
	}
});
});