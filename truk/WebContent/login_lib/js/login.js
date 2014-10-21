loginApp ={
	start: function(){
		this.bindEvents();
	},
	bindEvents:function(){
		var me = this;
		$('#username').keydown(function(event){
			if (event.keyCode == 13){
				$('#password').focus();
			}
		});
		
		$('#password').keydown(function(event){
			if (event.keyCode == 13){
				me.login();
			}
		});
		
		$('#btn-login').click(function(event){
			me.login();
		});
		
		$('#btn-reset').click(function(event){
			$('#username').val('').focus();
			$('#password').val('');
		});
	},
	login: function(){
		var userName = $('#username').val(),
		password = $('#password').val();
		$("form").submit();
	}
}
$(function(){
	loginApp.start();
});
