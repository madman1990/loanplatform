$(window).resize(function() {
	$('#viewRole').datagrid('resize', {
		width : cs()
	});
});
function cs() {
	return $(window).width() - 6;
}
var flag;
var userCount;
$.openWin = function(obj, index) {
	$('#roleSave').window({
		title : '添加角色'
	});
	$.showDivShade('/');
	$('#roleId').val('');
	$('#RoleName').val('');
	$("#Status").combobox('select', 1);
	$("#roletypeId").combobox('select', 2);
	$("#roleDesc").val('');
	flag = obj;
	if (flag != "-1") {
		$('#roleSave').window({
			title : '修改角色'
		});
		$('#viewRole').datagrid('selectRow', index);
		var row = $('#viewRole').datagrid('getSelected');
		$("#roleId").val(row.roleId);
		$("#RoleName").val(row.roleName);
	}
	$("#roleSave").window('open').window('refresh');
};
$.save = function() {
	var roleId = $("#roleId").val();
	var roleName = $("#RoleName").val();

	if ($.trim(roleName) == "") {
		$.messager.alert("提示 ", "请输入角色名称");
		return false;
	}

	$('#save').linkbutton('disable');
	if (flag == "-1") {
		$.post("/role/insertRole", {
			roleName : roleName
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");
	} else {
		$.post("/role/updateRole", {
			roleId : roleId,
			roleName : roleName
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");
	}

};
$.success = function(message, data) {
	$.messager.alert("提示 ", message);
	$('#save').linkbutton('enable');
	$.close();
	$.viewRole();
};
$.failed = function(message, data) {
	$.messager.alert("提示 ", message);
	$('#save').linkbutton('enable');
};
$.close = function() {
	$.hideDivShade();
	$("#roleSave").window('close');
};
$.roleViewClose = function() {
	$("#roleView").window('close');
}

$.deleteRole = function(index) {
	$('#viewRole').datagrid('selectRow', index);
	var rows = $('#viewRole').datagrid('getSelected');
	$.post("/role/checkExist", {
		roleId : rows.roleId,
	}, function(data) {
		if (data.success) {
			var count = data.obj.EXISTS_SUM;
			if (count > 0) {
				$.messager.alert("提示 ", "该角色已分配了用户，不能删除!");
				return false;
			}
			$.messager.confirm("提示", "确定删除？", function(r) {
				if (r) {
					$.post("/role/deleteRole", {
						roleId : rows.roleId,
					}, function(data) {
						$.parseAjaxReturnInfo(data, $.success, $.failed);
					}, "json");
				}
			});
		}
	}, "json");

};
$.viewRoleInfo = function(index) {
	$('#viewRole').datagrid('selectRow', index);
	var rows = $('#viewRole').datagrid('getSelected');
	$("#roleNameView").val(rows.roleName);
	$("#roleView").window('open').window('refresh');
}
$.viewRole = function() {
	var roleName = $("#roleName").val();
	$('#viewRole')
			.datagrid(
					{
						title : '角色管理',
						width : $(window).width() - 6,
						height : $(window).height() * 0.9,
						nowrap : true,
						fitColumns : true,
						url : "/role/rolelist",
						pageSize : 20,
						pageNumber : 1,
						singleSelect : true,
						queryParams : {
							roleName : roleName
						},
						loadMsg : '数据载入中,请稍等！',
						remoteSort : false,
						columns : [ [
								{
									field : "roleName",
									title : "角色名称",
									width : $(window).width() * 0.2,
									align : "center",
									sortable : true
								},
								{
									field : "roleId",
									title : "操作",
									width : $(window).width() * 0.2,
									align : "center",
									sortable : true,
									formatter : function(value, row, index) {
										var html = "";
										html += "  <a href='#' onclick='$.viewRoleInfo("
												+ index + ")'>详情</a>";

										html += " | <a href='#' onclick='$.openWin(-2,"
												+ index + ")'>修改</a>";

										html += " | <a href='#' onclick='$.deleteRole("
												+ index + ")'>删除</a>";
										return html;
									}
								} ] ],
						hideColumn : [ [ {
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
	var p = $('#viewRole').datagrid('getPager');
	$(p).pagination({
		pageList : [ 5, 10, 20, 50 ],
		beforePageText : '第',
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
};
$(function() {
	$.viewRole();
});
$.ClearRole = function() {
	$("#roleName").val('');
}
