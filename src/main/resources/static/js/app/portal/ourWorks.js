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
};