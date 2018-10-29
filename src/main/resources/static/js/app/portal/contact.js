var contact = {
	
	openDialogEditContact: function() {
		openDialogConfirm("Edit Contact", function(){
			contact.submitEdit();
		});
	},

	submitEdit: function() {
		var json = $("#editContactForm").serializeObject();
		ajaxCall({
            type: 'POST',
			url: "contact/submitEdit",
			data: json,
			replaceid: '#container',
			onSuccess: function() {
				$('#mainDialog').modal('toggle');
				menuPortal.menuPortalAction('PAGE_CONTACT', 'back');
			}
		});
	}
};