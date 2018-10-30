var ourWorks = {
	
	onLoad: function() {

	},
	
	openDialogEditOurWorks: function() {
		openDialogConfirm("Edit Our Works", function(){
			console.log("click");
		});
	},

	openSubOurWorks: function(topic) {
		ajaxCall({
			type: "POST",
			url: "ourWorks/sub",
			data: {topic: topic},
			replaceid: "#container",
			onSuccess: function() {
				
			},
		});		
	},

	openJssorSubOurWorks: function(serviceName, topic) {
		CallJssor({
			type: "POST",
			data: {serviceName: serviceName, topic: topic},
			url: "ourWorks/sub/jssor",
			onSuccess: function() {
			},
		});
	},
	
	//tab
	
	tabOurWorksGroup: function() {
		ajaxCall({
			type: "POST",
			url: "ourWorks/editOurWorksGroup",
			replaceid: "#ourworksGroup",
			onSuccess: function() {
				
			},
		});
	},
	
	tabOurWorksSubGroup: function() {
		ajaxCall({
			type: "POST",
			url: "ourWorks/editOurWorksSubGroup",
			replaceid: "#ourworksSubGroup",
			onSuccess: function() {
				
			},
		});
	},
	
	tabOurWorksJssor: function() {
		ajaxCall({
			type: "POST",
			url: "ourWorks/editOurWorksJssor",
			replaceid: "#ourworksJssor",
			onSuccess: function() {
				
			},
		});
	},
};