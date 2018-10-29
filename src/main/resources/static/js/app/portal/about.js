var about = {
	
	openDialogEditAbout: function() {
		openDialogConfirm("Edit About", function(){
			about.submitEdit();
		});
	},
	
	submitEdit: function() {
		var json = $("#editAboutForm").serializeObject();
		ajaxCall({
            type: 'POST',
			url: "about/submitEdit",
			data: json,
			replaceid: '#container',
			onSuccess: function() {
				$('#mainDialog').modal('toggle');
				menuPortal.menuPortalAction('PAGE_ABOUT', 'back');
			}
		});
	}

};