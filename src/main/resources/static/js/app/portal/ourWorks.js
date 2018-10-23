var ourWorks = {
	
	onLoad: function() {

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