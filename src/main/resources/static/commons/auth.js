$(function() {
	$("#detailTree").tree({
		url : "/menu/getRoleMenuTree",
		checkbox : true
	});
});

$.changeRole = function() {
	var roleId = $("#rolelist").val();
	$("#detailTree").tree({
		url : "/menu/getRoleMenuTree?roleId=" + roleId,
		checkbox : true
	});

}
$.save = function() {
	var powerIds = "";
	var roleId = $("#rolelist").val();
	if ($.trim(roleId) == "-1") {
		$.messager.alert("提示 ", "请选择一个角色");
		return;
	}

	var rows = $("#detailTree").tree("getChecked");
	var authId = $("#authId").val;
	for (var i = 0; i < rows.length; i++) {
		powerIds += rows[i].id + ",";
	}
	powerIds = powerIds.substring(0, powerIds.lastIndexOf(","));
	$('#save').linkbutton('disable');
	$.post("/menu/saveRoleMenu", {
		roleId : roleId,
		powerIds : powerIds
	}, function(data) {
		$.parseAjaxReturnInfo(data, $.success, $.failed);
	}, "json");
};

$.success = function(message, data) {
	$.messager.alert("提示 ", message);
	$('#save').linkbutton('enable');

};

$.failed = function(message, data) {
	$.messager.alert("提示 ", message);
	$('#save').linkbutton('enable');
};
