/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 */
Ext.define('SampleSystem.Application', {
    extend: 'Ext.app.Application',
    name: 'SampleSystem',
    requires: [
    	'Ext.layout.container.Border',
    	'Ext.layout.container.Fit'   	
 	],
    views: [
    	'main.ViewPort',
    	'main.LeftPanel',
    	'main.LeftMenus',
    	'main.HeaderPanel',
    	'main.MainPanel',
    	'detail.Home',
    	'detail.MyDream',
    	'detail.MyInfo',
    	'detail.MyInterests',
    	'detail.MyWork'
 	],
 	controllers: [
		'MainController'
	],
	stores: [
    	'MenusStore'  
	],
    launch: function () {
//    	var me = this;
//		Ext.Ajax.request({
//			url: '../controller/security/getUserAccess',
//		    success: function(response){
//		    	var responseText = Ext.JSON.decode(response.responseText);
//		    	if(responseText.success == true){
//					me.initExtJSConfig();
//					app.user = responseText.data;
//					
					Ext.create('SampleSystem.view.main.ViewPort');
					Ext.fly('loading').fadeOut({
						remove: true
					});
//		    	}else {
//		    		window.location.href = '../index.html';
//		    	}
//		    },
//		    failure: function() {
//		    	window.location.href = '../index.html';
//		    }
//		});
    }
});
