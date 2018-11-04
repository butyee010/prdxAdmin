var services = {
	
	openDialogEditServices: function() {
		openDialogConfirm("Edit Services", function(){
			services.uploadFile();
		});
	},
	
	initEditServices: function() {
		/*$("#servicesTable").DataTable({
          	"info" : false,
          	"paging": true,
          	"searching": true,
          	"lengthChange": false,
          });*/
	},
	
	addService: function() {
		var i = $("#servicesTable tbody tr").length + 1;
		var newRow = `<tr>
							<td align="center" class="count-index">`+i+`</td>
							<td><input type="text" name="header" class="form-control" value=""/></td>
							<td><textarea rows="5" cols="50" name="content" class="form-control"></textarea></td>
							<td>
								<input type="file" name="fileImage" value=""/></td>
							<td align="center"><i class="material-icons btn-delete" onclick="services.deleteService(this)">delete</i></td>
						</tr>`;
		$("#servicesTable tbody").append(newRow);
	},
	
	deleteService: function(elm) {
		$(elm).parents("tr").remove();
		
		jQuery.each($("#editServiceForm tbody tr"), function(i, tr) {
			$(tr).find(".count-index").html((i+1));
		});
		
	},
	
	uploadFile: function() {
		var form = $("#editServiceForm")[0];
		var formData = new FormData();
		
		jQuery.each($("#editServiceForm tbody tr"), function(i, tr) {
			var header = $(tr).find('input[name="header"]').val();
			var content = $(tr).find('textarea[name="content"]').val();
			var file = $(tr).find('input[name="fileImage"]')[0].files[0];
			formData.append("serviceForm["+i+"].header", header);
			formData.append("serviceForm["+i+"].content", content);
			if (!!file) {
				formData.append("serviceForm["+i+"].fileName", file.name);
				formData.append("serviceForm["+i+"].file", file);
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
				menuPortal.menuPortalAction('PAGE_SERVICES', 'back');
			}
		});
	}

};