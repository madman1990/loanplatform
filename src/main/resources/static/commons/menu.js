$(window).resize(function() {
	$('#viewmenu').datagrid('resize', {
		width : cs()
	});
});
function cs() {
	return $(window).width() - 6;
}
var flag;
var userCount;
$.openWin = function(obj, index) {
	$('#menuSave').window({
		title : '添加菜单'
	});
	$.showDivShade('/');
	$('#menuCode').val('');
	$("#upMenuCode").val('');
	$('#menuName').val('');
	$("#menuDesc").val('');
	$("#menuUrl").val('');
	flag = obj;
	if (flag != "-1") {
		$('#menuSave').window({
			title : '修改菜单'
		});
		$('#viewmenu').datagrid('selectRow', index);
		var row = $('#viewmenu').datagrid('getSelected');
		$('#menuCode').val(row.menuCode);
		$("#upMenuCode").val(row.upMenuCode);
		$('#menuName').val(row.menuName);
		$("#menuDesc").val(row.menuDesc);
		$("#menuUrl").val(row.menuUrl);
	}
	$("#menuSave").window('open').window('refresh');
};
$.save = function() {
	var menuCode = $("#menuCode").val();
	var menuName = $("#menuName").val();
	var upMenuCode = $("#upMenuCode").val();
	var menuDesc = $("#menuDesc").val();
	var menuUrl = $("#menuUrl").val();

	if ($.trim(menuName) == "") {
		$.messager.alert("提示 ", "请输入菜单名称");
		return false;
	}

	if ($.trim(upMenuCode) != "" && $.trim(menuUrl) == "") {
		$.messager.alert("提示 ", "请输入菜单地址");
		return false;
	}

	$('#save').linkbutton('disable');
	if (flag == "-1") {
		$.post("/menu/insertMenu", {
			menuName : $("#menuName").val(),
			upMenuCode : $("#upMenuCode").val(),
			menuDesc : $("#menuDesc").val(),
			menuUrl : $("#menuUrl").val()
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");
	} else {
		$.post("/menu/updateMenu", {
			menuCode : $("#menuCode").val(),
			menuName : $("#menuName").val(),
			upMenuCode : $("#upMenuCode").val(),
			menuDesc : $("#menuDesc").val(),
			menuUrl : $("#menuUrl").val()
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");
	}

};
$.success = function(message, data) {
	$.messager.alert("提示 ", message);
	$('#save').linkbutton('enable');
	$.close();
	$.viewmenu();
};
$.failed = function(message, data) {
	$.messager.alert("提示 ", message);
	$('#save').linkbutton('enable');
};
$.close = function() {
	$.hideDivShade();
	$("#menuSave").window('close');
};
$.menuViewClose = function() {
	$("#menuView").window('close');
}

$.deletemenu = function(index) {
	$('#viewmenu').datagrid('selectRow', index);
	var row = $('#viewmenu').datagrid('getSelected');
	$.messager.confirm("提示", "确定删除？", function(r) {
		if (r) {
			$.post("/menu/deleteMenu", {
				menuCode : row.menuCode,
			}, function(data) {
				$.parseAjaxReturnInfo(data, $.success, $.failed);
			}, "json");
		}
	});
};

$.ClearMenu = function() {
	$("#menuNameOper").val('');
};

$.viewApplication = function() {
	var menuName = $("#menuNameOper").val();
	$('#viewmenu').datagrid(
			{
				title : '菜单管理',
				width : $(window).width() - 6,
				height : $(window).height() * 0.9,
				nowrap : true,
				fitColumns : true,
				url : "/menu/selectList",
				pageSize : 20,
				pageNumber : 1,
				singleSelect : true,
				queryParams : {
					menuName : menuName
				},
				loadMsg : '数据载入中,请稍等！',
				remoteSort : false,
				columns : [ [
						{
							field : "menuName",
							title : "菜单 名称",
							width : $(window).width() * 0.2,
							align : "center",
							sortable : true
						},
						{
							field : "menuDesc",
							title : "地址",
							width : $(window).width() * 0.2,
							align : "center",
							sortable : true
						},
						{
							field : "upMenuName",
							title : "上级菜单 名称",
							width : $(window).width() * 0.2,
							align : "center",
							sortable : true
						},
						{
							field : "menuId",
							title : "操作",
							width : $(window).width() * 0.2,
							align : "center",
							sortable : true,
							formatter : function(value, row, index) {
								var html = "";
								html += " <a href='#' onclick='$.openWin(-2,"
										+ index + ")'>修改</a>";
								html += " | <a href='#' onclick='$.deletemenu("
										+ index + ")'>删除</a>";
								return html;
							}
						} ] ],
				hideColumn : [ [ {
					field : "menuCode",
					field : "upMenuCode"
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
	var p = $('#viewmenu').datagrid('getPager');
	$(p).pagination({
		pageList : [ 5, 10, 20, 50 ],
		beforePageText : '第',
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
};
$(function() {
    $.viewApplication();
});
