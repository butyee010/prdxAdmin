var gallery = {
	onLoad: function() {
	},
	
	openDialogEditGallery: function() {
		openDialogConfirm("Edit Gallery", function(){
			gallery.uploadFile();
		});
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
	
	tabGalleryGroup: function() {
		ajaxCall({
			type: "POST",
			url: "gallery/editGalleryGroup",
			replaceid: "#galleryGroup",
			onSuccess: function() {
				
			},
		});
	},
	
	tabGalleryJssor: function() {
		ajaxCall({
			type: "POST",
			url: "gallery/editGalleryJssor",
			replaceid: "#galleryJssor",
			onSuccess: function() {
				
			},
		});
	},
	
	addGallery: function() {
		var i = $("#editGalleryForm tbody tr").length + 1;
		var newRow = `<tr>
							<td align="center" class="count-index">`+i+`</td>
							<td><input type="text" name="header" class="form-control" value=""/></td>
							<td><textarea rows="5" cols="50" name="content" class="form-control"></textarea></td>
							<td>
								<input type="file" name="fileImage" value=""/></td>
							<td align="center"><i class="material-icons btn-delete" onclick="services.deleteService(this)">delete</i></td>
						</tr>`;
		$("#galleryTable tbody").append(newRow);
	},
	
	deleteGallery: function(elm) {
		$(elm).parents("tr").remove();
		
		jQuery.each($("#editGalleryForm tbody tr"), function(i, tr) {
			$(tr).find(".count-index").html((i+1));
		});
		
	},
	
	uploadFile: function() {
		var form = $("#editGalleryForm")[0];
		var formData = new FormData();
		
		var jsonData = {};
		var items = $("#editGalleryForm tbody tr");
		
		jQuery.each($("#editGalleryForm tbody tr"), function(i, tr) {
			var header = $(tr).find('input[name="header"]').val();
			var content = $(tr).find('textarea[name="content"]').val();
			var file = $(tr).find('input[name="fileImage"]')[0].files[0];
			formData.append("galleryForm["+i+"].header", header);
			formData.append("galleryForm["+i+"].content", content);
			if (!!file) {
				formData.append("galleryForm["+i+"].fileName", file.name);
				formData.append("galleryForm["+i+"].file", file);
			}
		});
		$.ajax({
			url: form.action,
			method: form.method,
			type: 'POST',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data) {
				$('#mainDialog').modal('toggle');
				menuPortal.menuPortalAction('PAGE_GALLERY', 'back');
			}
		});
	}
};