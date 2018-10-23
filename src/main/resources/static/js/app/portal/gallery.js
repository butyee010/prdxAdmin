var gallery = {
	onLoad: function() {

	},

	openSubGalley: function(topic) {
		ajaxCall({
			type: "POST",
			url: "gallery/sub",
			data: {topic: topic},
			replaceid: "#container",
			onSuccess: function() {
				
			},
		});		
	},

	openJssorSubGalley: function(topic) {
		CallJssor({
			type: "POST",
			url: "gallery/sub/jssor",
			data: {topic: topic},
			onSuccess: function() {
			},
		});
	},
};