// Namespace definition
Ext.ns("SYNOCOMMUNITY.sl");

// Application definition
Ext.define("SYNOCOMMUNITY.sl.AppInstance", {
	extend : "SYNO.SDS.AppInstance",
	appWindowName : "SYNOCOMMUNITY.sl.AppWindow",
	constructor : function() {
		this.callParent(arguments)
	}
});

// Window definition
Ext.define("SYNOCOMMUNITY.sl.AppWindow", {
	extend : "SYNO.SDS.AppWindow",
	constructor : function(config) {
		config = Ext.apply({
			resizable : true,
			maximizable : true,
			minimizable : true,
			width : 700,
			height : 350,
			items : [ {
				xtype : 'label',
				text : _TT("SYNOCOMMUNITY.sl.AppInstance", "body", "hw")
			} ]
		}, config);

		this.callParent([ config ]);
	}
});
