$(function(){
	
	$('#username').keydown(function(event){
		if (event.keyCode == 13){
			$('#password').focus();
		}
	});
	
	$('#password').keydown(function(event){
		if (event.keyCode == 13){
			login();
		}
	});
	
	$('#btn-login').click(function(event){
		login();
	});
	
	$('#btn-reset').click(function(event){
		$('#username').val('').focus();
		$('#password').val('');
	});
	
});

function login(){
	var userName = $('#username').val(),
		password = $('#password').val();
	$("form").submit();
};
