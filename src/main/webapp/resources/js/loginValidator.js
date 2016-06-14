/**
 * 
 */
jQuery.validator.addMethod("lettersonly", function(value, element) {
	return this.optional(element) || /^[a-z,""]+$/i.test(value);
}, "only characters are allowed");

jQuery.validator.addMethod("minus", function(value, element) {
	return this.optional(element) || /^[0-9]+./i.test(value);
}, "only numbers are allowed");

jQuery.validator.addMethod("minus", function(value, element) {
	return this.optional(element) || /^[0-9]+./i.test(value);
}, "only numbers are allowed");

jQuery.validator.addMethod("dateFormat", function(value, element) { 
	  return this.optional(element) || /^\d\d?-\w\w-\d\d\d\d/.test(value); 
	}, "Please specify the date in DD-MM-YYYY format");

/*jQuery.validator.addMethod("dateFormat", function(value, element) {
	 return this.optional(element) || /^dd?-dd?-dd$/i.test(value);
}, "Please enter a date in the format dd-mm-yyyy.");*/

(function($, W, D) {
			var JQUERY4U = {};

			JQUERY4U.UTIL = {
				setupFormValidation : function() {
					//form validation rules
					$("#taxform")
							.validate(
									{
										rules : {
											userName : {
												required : true,
												lettersonly : true
											},
											address : {
												required : true,
												minlength : 10,
												maxlength : 255,
											},
											pan : {
												required : true,
												minlength : 8,
												maxlength : 8
											},
											dob :{
												required : true,
												dateFormat: true,
											},
											ayear : {
												required : true,
											},
											income : {
												required : true,
												number : true,
											},
											tds : {
												required : true,
												number : true,
											},
											taxdeducted : {
												required : true,
												number : true,
											},
										},
										messages : {
											userName : {
												required : "Please enter Your name",
												lettersonly : "only characters are allowed"
											},
											address : {
												required : "Please enter a valid address",
												minlength : "Your address must contain 10 characters",
												maxlength : "Your address can not contain more than 255 characters",
											},
											pan : {
												required : "Please enter a valid pan number",
												minlength : "Your pan must contain 10 characters",
												maxlength : "Your pan can not contain more than 10 characters",
											},
											dob : {
												required : "Please enter date of birth",
												dateFormat : true,
											},
											ayear : {
												required : "Please enter a valid assessment year",
											},
											income : {
												required : "Please enter Your income",
												number : "only numbers are allowed"
											},
											tds :{
												required : "Please enter TDS amount",
												number : "only numbers are allowed"
											},
											taxdeducted : {
												required : "Please enter Your deducted tax amount",
												number : "only numbers are allowed"
											}

										},

										highlight : function(element) {
											$(element).closest('.form-group')
													.addClass('has-error');
										},
										unhighlight : function(element) {
											$(element).closest('.form-group')
													.removeClass('has-error');
										},
										errorElement : 'span',
										errorClass : 'help-block',
										errorPlacement : function(error, element) {
											if (element.parent('.input-group').length) {
												error.insertAfter(element.parent());
											} else {
												error.insertAfter(element);
											}
										}
										/*submitHandler : function(form) {
											form.submit();
										}
*/
									});
				

				}
			}

			//when the dom has loaded setup form validation rules
			$(D).ready(function($) {
				JQUERY4U.UTIL.setupFormValidation();
			});

		})(jQuery, window, document);

$(document).ready(function() {
	$("#loginLink").click(function() {
		$("div.form-group").removeClass('has-error');
		$("#name").val("");
		$("#password").val("");
	});

	$("input").focus(function() {
		$("#errorMessage").hide();
	});
});




