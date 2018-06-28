$(window).resize(function() {
	$('#viewUser').datagrid('resize', {
		width : cs()
	});
});
function cs() {
	return $(window).width() - 6;
}
var flag;
var userCount;
$.openWin = function(obj, index) {
	$('#UserSave').window({
		title : '添加用户'
	});
	$.showDivShade('/');
	$('#loginName').val('');
	$('#realName').val('');
	$("#roleId").val('');
	$("#password").val('');
	$("#psdTd").show();
	$("#userId").val('');
	flag = obj;
	if (flag != "-1") {
		$("#psdTd").hide();
		$('#UserSave').window({
			title : '修改用户'
		});
		$('#viewUser').datagrid('selectRow', index);
		var row = $('#viewUser').datagrid('getSelected');
		$('#loginName').val(row.loginName);
		$('#realName').val(row.realName);
		$("#roleId").val(row.roleId);
		$("#userId").val(row.userId);
	}
	$("#UserSave").window('open').window('refresh');
};
$.save = function() {

	var loginName = $('#loginName').val();
	var realName = $('#realName').val();
	var roleId = $("#roleId").val();

	if ($.trim(loginName) == "") {
		$.messager.alert("提示 ", "请输入登录名称");
		return false;
	}
	if (!$.checkUserName) {
		return false;
	}
	if ('' == $("#userId").val()) {
		if ($.trim($("#password").val()) == "") {
			$.messager.alert("提示 ", "请输入密码");
			return false;
		}
		// if (${#strings.length($("#password").val())} < 6) {
		// $.messager.alert("提示 ", "输入密码长度必须大于等 于6位");
		// return false;
		// }
		if ($.trim(realName) == "") {
			$.messager.alert("提示 ", "请输入真实名");
			return false;
		}
	}

	if ($.trim(roleId) == "") {
		$.messager.alert("提示 ", "请选择角色");
		return false;
	}

	$('#save').linkbutton('disable');
	if (flag == "-1") {
		$.post("/user/insertUser", {
			loginName : $('#loginName').val(),
			realName : $('#realName').val(),
			roleId : $("#roleId").val(),
			password : hex_md5($("#password").val())
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");
	} else {
		$.post("/user/updateUser", {
			userId : $("#userId").val(),
			loginName : $('#loginName').val(),
			realName : $('#realName').val(),
			roleId : $("#roleId").val()
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");
	}

};
$.success = function(message, data) {
	$.messager.alert("提示 ", message);
	$('#save').linkbutton('enable');
	$.close();
	$.UserViewClose();
	$.viewUser();
};
$.failed = function(message, data) {
	$.messager.alert("提示 ", message);
	$('#save').linkbutton('enable');
};
$.close = function() {
	$.hideDivShade();
	$("#UserSave").window('close');
};
$.UserViewClose = function() {
	$("#UserView").window('close');
}

$.deleteUser = function(index) {
	$('#viewUser').datagrid('selectRow', index);
	var rows = $('#viewUser').datagrid('getSelected');

	$.messager.confirm("提示", "确定删除？", function(r) {
		if (r) {
			$.post("/user/deleteUser", {
				userId : rows.userId,
			}, function(data) {
				$.parseAjaxReturnInfo(data, $.success, $.failed);
			}, "json");
		}
	});
};
$.savePas = function() {
	$.post("/user/updateUserPwd", {
		userId : $("#userIdUpdate").val(),
		password : hex_md5($("#passwordUpdate").val())
	}, function(data) {
		$.parseAjaxReturnInfo(data, $.success, $.failed);

	}, "json");

};
$.viewUserInfo = function(index) {
	$('#viewUser').datagrid('selectRow', index);
	var rows = $('#viewUser').datagrid('getSelected');
	$("#userIdUpdate").val(rows.userId);
	$("#passwordUpdate").val('');
	$("#UserView").window('open').window('refresh');
}
$.checkUserName = function() {
	$.post("/user/checkUserName", {
		userId : $("#userId").val(),
		loginName : $('#loginName').val()
	}, function(data) {
		if (!data.success) {
			$.messager.alert("提示 ", data.msg);
			return false;
		}
	}, "json");
	return true;
}

$.viewUser = function() {
	var UserName = $("#UserName").val();
	$('#viewUser')
			.datagrid(
					{
						title : '用户管理',
						width : $(window).width() - 6,
						height : $(window).height() * 0.9,
						nowrap : true,
						fitColumns : true,
						url : "/user/selectList",
						pageSize : 20,
						pageNumber : 1,
						singleSelect : true,
						queryParams : {
							UserName : UserName
						},
						loadMsg : '数据载入中,请稍等！',
						remoteSort : false,
						columns : [ [
								{
									field : "loginName",
									title : "用户登录名",
									width : $(window).width() * 0.1,
									align : "center",
									sortable : true
								},
								{
									field : "roleName",
									title : "角色名",
									width : $(window).width() * 0.1,
									align : "center",
									sortable : true
								},
								{
									field : "realName",
									title : "用户真实名",
									width : $(window).width() * 0.1,
									align : "center",
									sortable : true
								},
								{
									field : "userId",
									title : "操作",
									width : $(window).width() * 0.2,
									align : "center",
									sortable : true,
									formatter : function(value, row, index) {
										var html = "";
										html += "  <a href='#' onclick='$.viewUserInfo("
												+ index + ")'>重置密码</a>";

										html += " | <a href='#' onclick='$.openWin(-2,"
												+ index + ")'>修改</a>";

										html += " | <a href='#' onclick='$.deleteUser("
												+ index + ")'>删除</a>";
										return html;
									}
								} ] ],
						hideColumn : [ [ {
							field : "userId",
							field : "roleId"
						} ] ],
						pagination : true,
						rownumbers : true,
						showFooter : true,
						toolbar : [ {
							id : 'btnadd',
							text : '添加',
							iconCls : 'icon-add',
							handler : function() {
								$.openWin(-1);
							}
						} ]
					});
	var p = $('#viewUser').datagrid('getPager');
	$(p).pagination({
		pageList : [ 5, 10, 20, 50 ],
		beforePageText : '第',
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
};
$(function() {
	$.viewUser();
});
