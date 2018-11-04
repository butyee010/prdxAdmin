var home = {
	
	openDialogEditHome: function() {
		openDialogConfirm("Edit Home", function(){
			home.submitHome();
		});
	},
	
	addImageRef1: function() {
		var i = $("#homeRef1Table tbody tr").length + 1;
		var newRow = `<tr>
						<td align="center" class="count-index">`+i+`</td>
						<td>
							<input type="file" name="homeRef1FileImage" value=""/></td>
						<td align="center"><i class="material-icons btn-delete" onclick="home.deleteImageRef1(this)">delete</i></td>
					</tr>`;
		$("#homeRef1Table tbody").append(newRow);
	},
	
	deleteImageRef1: function(elm) {
		$(elm).parents("tr").remove();
		
		jQuery.each($("#homeRef1Table tbody tr"), function(i, tr) {
			$(tr).find(".count-index").html((i+1));
		});
		
	},
	
	submitHome: function() {
		var form = $("#editHomeForm")[0];
		var formData = new FormData();
		//section 1
		jQuery.each($("#homeRef1Table tbody tr"), function(i, tr) {
			var homeRef1File = $(tr).find('input[name="homeRef1FileImage"]')[0].files[0];
			if (!!homeRef1File) {
				formData.append("imageRef1List["+i+"].fileName", homeRef1File.name);
				formData.append("imageRef1List["+i+"].file", homeRef1File);
			}
		});
		formData.append("headerRef1", $("input[name=headerRef1]").val());
		formData.append("contentRef1", $("textarea[name=contentRef1]").val());
		//section 2
		var homeRef2File = $('input[name="homeRef2FileImage"]')[0].files[0];
		if (!!homeRef2File) {
			formData.append("imageRef2.fileName", homeRef2File.name);
			formData.append("imageRef2.file", homeRef2File);
		}
		//section 3
		var homeRef3File = $('input[name="homeRef3FileImage"]')[0].files[0];
		if (!!homeRef3File) {
			formData.append("imageRef3.fileName", homeRef3File.name);
			formData.append("imageRef3.file", homeRef3File);	
		}
		formData.append("headerRef3", $("input[name=headerRef3]").val());
		formData.append("contentRef3", $("textarea[name=contentRef3]").val());
		$.ajax({
			url: form.action,
			method: form.method,
			type: 'POST',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data) {
				$('#mainDialog').modal('toggle');
				menuPortal.menuPortalAction('PAGE_HOME', 'back');
			}
		});
	}

};