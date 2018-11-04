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
	
	//group
	openDialogEditOurWorksGroup: function() {
		openDialogConfirm("Edit Our Works Group", function(){
			ourWorks.uploadFileOurWorksGroup();
		});
	},
	
	addOurWorksGroup: function() {
		var i = $("#ourworksGroupTable tbody tr").length + 1;
		var newRow = 	`<tr>
							<td align="center" class="count-index">`+i+`</td>
							<td><input type="text" name="header" class="form-control" value=""/></td>
							<td><textarea rows="5" cols="50" name="content" class="form-control"></textarea></td>
							<td>
								<input type="file" name="fileImage" value=""/></td>
							<td align="center"><i class="material-icons btn-delete" onclick="ourWorks.deleteOurWorksGroup(this)">delete</i></td>
						</tr>`;
		$("#ourworksGroupTable tbody").append(newRow);
	},
	
	deleteOurWorksGroup: function(elm) {
		$(elm).parents("tr").remove();
		
		jQuery.each($("#ourworksGroupTable tbody tr"), function(i, tr) {
			$(tr).find(".count-index").html((i+1));
		});
		
	},
	
	uploadFileOurWorksGroup: function() {
		var form = $("#editOurWorksGroupForm")[0];
		var formData = new FormData();
		
		var jsonData = {};
		var items = $("#ourworksGroupTable tbody tr");
		
		jQuery.each($("#ourworksGroupTable tbody tr"), function(i, tr) {
			var header = $(tr).find('input[name="header"]').val();
			var content = $(tr).find('textarea[name="content"]').val();
			var file = $(tr).find('input[name="fileImage"]')[0].files[0];
			formData.append("ourWorksForm["+i+"].header", header);
			formData.append("ourWorksForm["+i+"].content", content);
			if (!!file) {
				formData.append("ourWorksForm["+i+"].fileName", file.name);
				formData.append("ourWorksForm["+i+"].file", file);
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
				menuPortal.menuPortalAction('PAGE_OUR_WORKS', 'back');
			}
		});
	},
	
	//sub group
	
	onLoadEditOurWorksSubGroup: function() {
		ourWorks.eventChangeOurWorksSubGroup();
	},
	
	eventChangeOurWorksSubGroup: function() {
		$("select[name=ourworksGroup]").on('change', function() {
			ourWorks.changeOurWorksSubGroup(this.value);
		});
		
		ourWorks.changeOurWorksSubGroup($("select[name=ourworksGroup]").val());
	},
	
	changeOurWorksSubGroup: function(ourworksGroup) {
		ajaxCall({
			type: "POST",
			url: "ourWorks/changeOurWorksSubGroup",
			data: {topic: ourworksGroup},
			replaceid: "#ourworksSubGroupContent",
			onSuccess: function() {
				
			},
		});
	},
	
	openDialogEditSubOurWorksGroup: function() {
		openDialogConfirm("Edit Our Works Sub Group", function(){
			ourWorks.uploadFileSubOurWorksGroup();
		});
	},
	
	addOurWorksSubGroup: function() {
		var i = $("#ourworksSubGroupTable tbody tr").length + 1;
		var newRow = 	`<tr>
							<td align="center" class="count-index">`+i+`</td>
							<td><input type="text" name="header" class="form-control" value=""/></td>
							<td><textarea rows="5" cols="50" name="content" class="form-control"></textarea></td>
							<td>
								<input type="file" name="fileImage" value=""/></td>
							<td align="center"><i class="material-icons btn-delete" onclick="ourWorks.deleteOurWorksSubGroup(this)">delete</i></td>
						</tr>`;
		$("#ourworksSubGroupTable tbody").append(newRow);
	},
	
	deleteOurWorksSubGroup: function(elm) {
		$(elm).parents("tr").remove();
		
		jQuery.each($("#ourworksSubGroupTable tbody tr"), function(i, tr) {
			$(tr).find(".count-index").html((i+1));
		});
		
	},
	
	uploadFileSubOurWorksGroup: function() {
		var form = $("#editOurWorksSubGroupForm")[0];
		var formData = new FormData();
		
		var jsonData = {};
		var items = $("#editOurWorksSubGroupForm tbody tr");
		
		jQuery.each($("#editOurWorksSubGroupForm tbody tr"), function(i, tr) {
			var file = $(tr).find('input[name="fileImage"]')[0].files[0];
			if (!!file) {
				formData.append("fileImageList["+i+"].fileName", file.name);
				formData.append("fileImageList["+i+"].file", file);
			}
		});
		var ourworksGroup = $("select[name=ourworksGroup]").val();
		formData.append("topic", ourworksGroup);
		$.ajax({
			url: form.action,
			method: form.method,
			type: 'POST',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data) {
				$('#mainDialog').modal('toggle');
				menuPortal.menuPortalAction('PAGE_OUR_WORKS', 'back');
			}
		});
	},
	
	//jssor
	
	onLoadEditOurWorksJssor: function() {
		ourWorks.eventChangeOurWorksJssorGroup();
	},
	
	eventChangeOurWorksJssorGroup: function() {
		$("select[name=ourworksGroup]").on('change', function() {
			ourWorks.changeOurWorksJssorGroup(this.value);
		});
		ourWorks.changeOurWorksJssorGroup($("select[name=ourworksGroup]").val());
		ourWorks.eventChangeOurWorksJssorSubGroup();
	},
	
	eventChangeOurWorksJssorSubGroup: function() {
		$("select[name=ourworksSubGroup]").on('change', function() {
			ourWorks.changeOurWorksJssorSubGroup($("select[name=ourworksGroup]").val(), this.value);
		});
	},
	
	changeOurWorksJssorGroup: function(ourworksGroup) {
		if (!!ourworksGroup) {
			ajaxCall({
				type: "POST",
				url: "ourWorks/changeOurWorksJssorGroup",
				data: {topic: ourworksGroup},
				onSuccess: function(data) {
					$("select[name=ourworksSubGroup]").empty();
					if (!!data && !jQuery.isEmptyObject(data)) {
						jQuery.each(data, function(i, obj) {
							var o = new Option(obj.topicName, obj.topicName);
							$("select[name=ourworksSubGroup]").append(o);
						});
						ourWorks.changeOurWorksJssorSubGroup($("select[name=ourworksGroup]").val(), $("select[name=ourworksSubGroup]").val());
					}
				},
			});	
		}
	},
	
	changeOurWorksJssorSubGroup: function(group, subGroup) {
		if (!!group && !!subGroup) {
			ajaxCall({
				type: "POST",
				url: "ourWorks/changeOurWorksJssorSubGroup",
				data: {serviceName: group, topic : subGroup},
				replaceid: "#ourworksJssorContent",
				onSuccess: function(data) {
				},
			});
		}
	},
	
	openDialogEditOurWorksJssor: function() {
		openDialogConfirm("Edit Our Works Sub Group Jssor", function(){
			ourWorks.uploadFileOurWorksJssor();
		});
	},
	
	addOurWorksJssor: function() {
		var i = $("#ourworksSubGroupTable tbody tr").length + 1;
		var newRow = 	`<tr>
							<td align="center" class="count-index">`+i+`</td>
							<td>
								<input type="file" name="fileImage" value="" />
							</td>
							<td align="center"><i class="material-icons btn-delete"
								onclick="ourWorks.deleteOurWorksJssor(this)">delete</i></td>
						</tr>`;
		$("#ourworksSubGroupTable tbody").append(newRow);
	},
	
	deleteOurWorksJssor: function(elm) {
		$(elm).parents("tr").remove();
		
		jQuery.each($("#ourworksSubGroupTable tbody tr"), function(i, tr) {
			$(tr).find(".count-index").html((i+1));
		});
		
	},
	
	uploadFileOurWorksJssor: function() {
		var form = $("#editOurWorksJssorForm")[0];
		var formData = new FormData();
		
		var jsonData = {};
		var items = $("#editOurWorksJssorForm tbody tr");
		
		jQuery.each($("#editOurWorksJssorForm tbody tr"), function(i, tr) {
			var file = $(tr).find('input[name="fileImage"]')[0].files[0];
			if (!!file) {
				formData.append("fileImageList["+i+"].fileName", file.name);
				formData.append("fileImageList["+i+"].file", file);
			}
		});
		var ourworksGroup = $("select[name=ourworksGroup]").val();
		var ourworksSubGroup = $("select[name=ourworksSubGroup]").val();
		formData.append("service", ourworksGroup);
		formData.append("topic", ourworksSubGroup);
		$.ajax({
			url: form.action,
			method: form.method,
			type: 'POST',
			processData: false,
			contentType: false,
			data: formData,
			success: function(data) {
				$('#mainDialog').modal('toggle');
				menuPortal.menuPortalAction('PAGE_OUR_WORKS', 'back');
			}
		});
	},
};