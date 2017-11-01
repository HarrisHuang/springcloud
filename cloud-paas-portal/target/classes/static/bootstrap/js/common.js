function reloadJqGridTable(eid,url,postData) {
	var p = $("#" + eid).jqGrid('getGridParam', 'page');// 获取当前页
	var r = $("#" + eid).jqGrid('getGridParam', 'rowNum');// 获取显示行
	postData._index = p;
	postData._size = r;
	$("#" + eid).jqGrid('setGridParam', {
		url : url,
		datatype : 'json',
		postData : postData
	}).trigger("reloadGrid");
}

function jqGridLoadError(request,status,error) {
	var url = $(this).jqGrid('getGridParam', 'url');
	if (request.status == 0 && status == "error") {
		message("亲，请您检查网络是否畅通");
	} else if (request.status == 401 && status == "error") {
		message("亲，登录超时了哦，系统为您重新登录");
		setTimeout(redirect(jsCtx + "/login"), 2000);
	} else if (request.status == 0 && status == "timeout") {
		message("亲，您的网络不给力哦");
	} else if (request.status == 500 && status == "error") {
		message("亲，系统出现异常，请联系管理员哦");
	} else if (request.status == 403 && status == "error") {
		message("亲，您没有权限访问：" + url + " ，请联系管理员哦");
	}
}

function postRequest(url, data, callback, complete) {
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		success : callback,
		timeout : 60000, // 超时时间：60秒
		error : function(request, status, thrown) {
			if (request.status == 0 && status == "error") {
				message("亲，请您检查网络是否畅通");
			} else if (request.status == 401 && status == "error") {
				message("亲，登录超时了哦，系统为您重新登录");
				setTimeout(redirect(jsCtx + "/login"), 2000);
			} else if (request.status == 0 && status == "timeout") {
				message("亲，您的网络不给力哦");
			} else if (request.status == 500 && status == "error") {
				message("亲，系统出现异常，请联系管理员哦");
			} else if (request.status == 403 && status == "error") {
				message("亲，您没有权限访问 " + url + " ，请联系管理员哦");
			}
		},
		complete : complete
	});
}

function postLayerRequest(url, data, callback, complete) {
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		success : callback,
		timeout : 60000, // 超时时间：60秒
		error : function(request, status, thrown) {
			if (request.status == 0 && status == "error") {
				message("亲，请您检查网络是否畅通");
			} else if (request.status == 401 && status == "error") {
				message("亲，登录超时了哦，系统为您重新登录");
				setTimeout(redirect(jsCtx + "/login"), 2000);
			} else if (request.status == 0 && status == "timeout") {
				message("亲，您的网络不给力哦");
			} else if (request.status == 500 && status == "error") {
				message("亲，系统出现异常，请联系管理员哦");
			} else if (request.status == 403 && status == "error") {
				message("亲，您没有权限访问 " + url + " ，请联系管理员哦");
			}
		},
		complete : complete
	});
}

function redirect(url) {
	window.location.href = url;
}

function message(msg) {
	layer.msg(msg, {
		icon : 1,
		time : 4000
	// 2秒关闭（如果不配置，默认是3秒）
	}, function() {

	});
}

$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

// 获取字典标签
function getDictLabel(data, value, defaultValue) {
	for (var i = 0; i < data.length; i++) {
		var row = data[i];
		if (row.value == value) {
			return row.label;
		}
	}
	return defaultValue || '';
}

//打开对话框(添加修改)
function openDialog(title,url,width,height) {
	
	if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端，就使用自适应大小弹窗
		width = 'auto';
		height = 'auto';
	}
	
	top.layer.open({
	    type: 2,  
	    area: [width, height],
	    title: title,
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	    btn: ['确定', '关闭'],
	    yes: function(index, layero){
	    	 var body = top.layer.getChildFrame('body', index);
	         var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	         if(!iframeWin.contentWindow.validate()){
	        	return;
	         }
	         var formData = iframeWin.contentWindow.getFormData();
	         var formUrl = iframeWin.contentWindow.getFormUrl();
	     	 var loading = top.layer.load();
	         postLayerRequest(formUrl,formData,function(data) {
	 			var success = data.success;
				if(!success) {
					message("保存数据失败");
				}
	         },function(XMLHttpRequest, textStatus) {
	        	 top.layer.close(index);
	        	 top.layer.close(loading);
				 doSearch();
	         });
		},
		cancel: function(index){ 
			
	    }
	}); 	
}

//打开对话框(tree模式)
//{title:title,url:url,width:width,height:height,ztree:{"arg1":"xxx"}}
function openDialogTree(param,callback) {
	// 正常打开	
	top.layer.open({
	    type: 2, 
	    area: [param.width, param.height],
	    title: param.title,
	    content: param.url,
	    btn: ['确定', '关闭'],
	    yes: function(index, layero){ //或者使用btn1
	    	var nodes = [];
			var tree = layero.find("iframe")[0].contentWindow.$.fn.zTree.getZTreeObj("ztree");
			
			if(param.check) {
				nodes = tree.getCheckedNodes(true);
			} else {
				nodes = tree.getSelectedNodes();
			}
			if(param.required) {
				if(nodes == null || nodes.length == 0) {
					top.layer.msg("请选择一个节点", {icon : 0});
					return;
				}
				/*for(var i = 0; i < nodes.length; i++) {//
					ids.push(nodes[i].id);
					names.push(nodes[i].name);//
				}*/
			}
			if(typeof callback === 'function'){
				//callback(ids.join().replace(/u_/ig,""),names.join(),index);
				callback(nodes,index);
			} else{
				top.layer.close(index);
			}
		},
		cancel: function(index){ 
			//或者使用btn2
            //按钮【按钮二】的回调
        }
	}); 
}


//打开对话框(查看)
function openDialogView(title,url,width,height){
	if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端，就使用自适应大小弹窗
		width = 'auto';
		height = 'auto';
	}
	top.layer.open({
	    type: 2,  
	    area: [width, height],
	    title: title,
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	    btn: ['关闭'],
	    cancel: function(index){ 
	    	
	    }
	}); 
}

//确认对话框
function confirmx(mess, href,data,callback){
	top.layer.confirm(mess, {icon: 3, title:'系统提示'}, function(index){
		var loading = top.layer.load();
		postRequest(href, data, function(result) {
			var success = result.success;
			if(!success) {
				message("保存数据失败");
			} else {
				if(typeof callback === 'function'){
					callback();
				} else {
					doSearch();
				}
			}
		},function(XMLHttpRequest, textStatus) {
			top.layer.close(loading);
			top.layer.close(index);
		});
	});
}

function getGridParam(eid) {
	var rows = [];
	//获取多选到的行集合
	var rowids = $("#" + eid).jqGrid("getGridParam", "selarrrow");
	if(null != rowids && rowids.length > 0) {
		for(var i = 0;i < rowids.length; i++) {
			rows.push($("#" + eid).jqGrid("getRowData",rowids[i]));
		}
	}
	return rows;
}