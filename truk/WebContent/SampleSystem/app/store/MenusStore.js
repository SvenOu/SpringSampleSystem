Ext.define('SampleSystem.store.MenusStore',{
	extend:'Ext.data.Store',
	model:'SampleSystem.model.MenusModel',
	autoLoad:false,
	data: [
		{ src:'./resources/images/icon_action_plan.png', caption:'首页', functionCode:'首页'},
		{ src:'./resources/images/icon_new.png', caption:'我的作品', functionCode:'我的作品' },
		{ src:'./resources/images/icon_excel.png', caption:'档案馆', functionCode:'档案馆' },
		{ src:'./resources/images/icon_ops_manual.png', caption:'兴趣爱好', functionCode:'兴趣爱好' },
		{ src:'./resources/images/icon_help.png', caption:'理想抱负', functionCode:'理想抱负' }     
	]
});