var sessionKey = "";
(function($) {
	$.fn.serializeObject = function(){

        var self = this,
            json = {},
            push_counters = {},
            patterns = {
                "validate": /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
                "key":      /[a-zA-Z0-9_]+|(?=\[\])/g,
                "push":     /^$/,
                "fixed":    /^\d+$/,
                "named":    /^[a-zA-Z0-9_]+$/
            };


        this.build = function(base, key, value){
            base[key] = value;
            return base;
        };

        this.push_counter = function(key){
            if(push_counters[key] === undefined){
                push_counters[key] = 0;
            }
            return push_counters[key]++;
        };

        $.each($(this).serializeArray(), function(){
            // skip invalid keys
            if(!patterns.validate.test(this.name)){
                return;
            }

            var k,
                keys = this.name.match(patterns.key),
                merge = this.value,
                reverse_key = this.name;

            while((k = keys.pop()) !== undefined){

                // adjust reverse_key
                reverse_key = reverse_key.replace(new RegExp("\\[" + k + "\\]$"), '');

                // push
                if(k.match(patterns.push)){
                    merge = self.build([], self.push_counter(reverse_key), merge);
                }

                // fixed
                else if(k.match(patterns.fixed)){
                    merge = self.build([], k, merge);
                }

                // named
                else if(k.match(patterns.named)){
                    merge = self.build({}, k, merge);
                }
            }

            json = $.extend(true, json, merge);
        });
        return json;
    };
	
})(jQuery);

ajaxCall = function(option) {
	var o = $.extend({
		type : 'POST',
//		contentType : 'application/json; charset=utf-8',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		redirect : '',
		fullPageReplace : false,
		session : true,
		replaceid : '',
		data: null,
		showSuccess : false,
		successMsg : '',
		modalClose : false,
		onSuccess : function(html) {
		},
	}, option);

	if (o.session) {
		//sessionCheck();
	}
	if (o.modalClose) {
		//modals.close();
	}
	data = $.extend(o.data, {
		sessionKey: sessionKey
	});
		$.ajax({
				url : o.url,
				type : o.type,
				data : data,
				contentType : o.contentType,
				beforeSend : function() {
					openLoading();
				},
				complete : function() {
					closeLoading();
					resetWindow();
				},
				success : function(html) {
					if (o.fullPageReplace) {
						$("html").html(html);
					} else if (!o.redirect.trim()) {
						var errorMsg = $(html).find('strong#errorMsg').text();
						var warningMsg = $(html).find('strong#warningMsg').text();
						if (!!warningMsg.trim()) {
							$('#warning').html(html);
							$("html, body").animate({
								scrollTop : 0
							}, 100);
							return;
						}
						else {
							$('#warning').empty();
						}
						
						if (!errorMsg.trim()) {
							$('#error').empty();
							
							if (o.replaceid.trim()) {
								$(o.replaceid).empty();
								$(o.replaceid).html(html);
							}
							if (o.showSuccess || o.successMsg.trim()) {
								var successHtml = "<div class='alert alert-success' ><span class='closesucbtn' onclick='actions.alertdisnone();'>&times;</span><strong>Success!</strong>&nbsp;#massage#</div>";
								successHtml = successHtml.replace("#massage#",
										o.successMsg)
								$('#error').html(successHtml);
								$("html, body").animate({
									scrollTop : 0
								}, 100);
							}
							
						} else {
							$('#error').html(html);
							$("html, body").animate({
								scrollTop : 0
							}, 100);
							return;
						}
						
					} else {
						window.location.href = o.redirect;
					}
					if (!errorMsg.trim()) {
						o.onSuccess(html);
					}
				}
			});
		closeLoading();
};
/*** Loading ***/
function showLoading(index) {
	
}

function hideLoading(index) {

	
}
/*** End Loading ***/

/*** Error Box ***/
function showError(msg) {
	$("#errorBox").errorMessage("option", "msg", msg);
	$("#errorBox").errorMessage("show");
}

function hideError() {
	$("#errorBox").errorMessage("hide");
}
/*** End Error Box ***/

function dateABeforeDateB(dateA , dateB) {
    var objA = convertDateFormat(dateA);
    var objB = convertDateFormat(dateB);
    return new Date(objA) <= new Date(objB);
}

function dateAAfterDateB(dateA , dateB) {
    var objA = convertDateFormat(dateA);
    var objB = convertDateFormat(dateB);
    return new Date(objA) >= new Date(objB);
}

var datepickerConfig = {
		
	dateOpts: {
		limitDays: undefined,
		maxDays: undefined,
		curDate: new Date()
	},
	
	setDatepicker: function(dateFrom, dateTo, opts) {
		var _opts = $.extend(datepickerConfig.dateOpts, opts);
		var dateFromVal = $(dateFrom).val();
		var dateToVal = $(dateTo).val();
		var curDate = new Date();
		var limitDays = '-90d';

		if (!!_opts.limitDays || _opts.limitDays == 0) {
			limitDays = _opts.limitDays;
		}
		
		var maxDate = new Date();
		if (!!_opts.maxDays || _opts.maxDays == 0) {
			maxDate = new Date().addDays(_opts.maxDays);
		}
		
		var minDate = limitDays;
		
		$(dateFrom).datepicker({
			minDate: minDate,
			maxDate: maxDate,
		}).change(function () {
			var fromDate = $(dateFrom).datepicker("getDate");
			var toDate = $(dateTo).datepicker("getDate");
			if (fromDate > toDate) {
				$(dateTo).datepicker("setDate", fromDate);
			}	         
		});

		if (!(dateFromVal != undefined && dateFromVal != null && dateFromVal.trim() != "")) {
			if (!!_opts.curDate) {
				$(dateFrom).datepicker('setDate', curDate);
			}
		}
		
		$(dateTo).datepicker({
			minDate: minDate,
			maxDate: maxDate
		}).change(function () {
			var fromDate = $(dateFrom).datepicker("getDate");
			var toDate = $(dateTo).datepicker("getDate");
			if (toDate < fromDate) {
			   $(dateFrom).datepicker("setDate", toDate);
			}
		});

		if ( !(dateToVal != undefined && dateToVal != null && dateToVal.trim() != "") ) {
			if (!!_opts.curDate) {
				$(dateTo).datepicker('setDate', curDate);
			}
		}
	},
	
	
	setEffdate: function(dateEff, opts) {
		var _opts = $.extend(datepickerConfig.dateOpts, opts);
		var dateEffVal = $(dateEff).val();
		var curDate = new Date();
		var limitDays = '-90d';
		if (!!_opts.limitDays || _opts.limitDays == 0) {
			limitDays = _opts.limitDays;
		}
		
		if ( !(dateEffVal != undefined && dateEffVal != null && dateEffVal.trim() != "") ) {
			if (!!_opts.curDate) {
				$(dateEff).datepicker('setDate', curDate);
			}
		}
		
		var minDate = new Date().addDays(limitDays);
		
		$(dateEff).datepicker({
			minDate: minDate,
			maxDate: curDate
		});
	},
	
	setBusinessDate: function(dateId, opts) {
		var _opts = $.extend(datepickerConfig.dateOpts, opts);
		var dateVal = $(dateId).val();
		var curDate = new Date();
		var limitDays = '-90d';
		if (!!_opts.limitDays || _opts.limitDays == 0) {
			limitDays = _opts.limitDays;
		}

		var minDate = limitDays;
		var maxDate = new Date();
		if (!!_opts.maxDays || _opts.maxDays == 0) {
			maxDate = _opts.maxDays;
		}
		$(dateId).datepicker({
			minDate: minDate,
			maxDate: maxDate
		});
		
		if ( !(dateVal != undefined && dateVal != null && dateVal.trim() != "") ) {
			if (!!_opts.curDate) {
				$(dateId).datepicker('setDate', curDate);
			}
		}
		
	}
}

function openModal(option){
	var o = $.extend({
		headerEmpty: false,
		title: '',
		content: '',
		footer: '', 
		replaceid : '',
	}, option);
	o.replaceid = '.modal-body';
	ajaxCall(o);		
	if (o.headerEmpty)
		$("modal-header").empty();
	$("modal-title").append(o.title);
	$("modal-body").append(o.dataContent);
	$("modal-footer").append(o.dataFooter);
	$('#modal').modal();
}     

function CallJssor(opts) {
	opts.replaceid = ".jssor-content-area";
	ajaxCall(opts);
	openJssor();
}

function openJssor() {
	$("#jssor-content").css("display", "block");
	$("body").css("overflow", "hidden");
}

function closeJssor() {
	$("#jssor-content").css("display", "");
	$("#jssor-content-area").empty();
	$("body").css("overflow", "");
}

function openLoading() {
	$("#loading").fadeIn("fast");
}

function closeLoading() {
	$("#loading").fadeOut("fast");
}

function resetWindow() {
	window.scrollTo(0, 0);
}