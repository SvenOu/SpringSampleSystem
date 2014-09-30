Ext.define('SampleSystem.view.main.LeftPanel', {
	extend: 'Ext.panel.Panel',
	xtype:'left-panel',
    title: '菜单',
	bodyCls: 'main-left-panel',
    border: false, 
    animCollapse: true,
    collapsible: true,
    split: true,
    width: 115,
    layout:{
    	type: 'fit'
    },
    items: {
    	xtype:'left-menus'
    }
});