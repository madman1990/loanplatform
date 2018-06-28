$('#dt').datetimebox({
    required: true,
    showSeconds: true
});
$.clear = function() {
    $("#application").val("");
    $.loadList();
}

$.loadList = function() {
    var application = $("#application").val();<!-- 获取参数 -->
    var logkey = $("#logKey").val();
    $('#viewMessage').datagrid( <!-- 给table加载数据 -->
        {
            title : '接口信息查看',
            width : $(window).width() - 6,
            height : $(window).height() * 0.9,
            nowrap : true, // 把数据显示在一行里
            fitColumns : true, // 长宽自适应
            url : "/message/queryMessage.json", // 请求地址
            pageSize : 20, //页面大小
            pageNumber : 1, //初始页数
            singleSelect : true, // 单选
            queryParams : { // 查询参数
                application : application,
                logkey : logkey
            },
            loadMsg : '数据载入中,请稍等！', // 加载提示
            remoteSort : false, // 是否从服务器排序数据
            columns : [ [ // 列名
                {
                    field : "id",
                    title : "id",
                    width : $(window).width() * 0.1,
                    align : "center",
                    sortable : true
                },
                {
                    field : "branchId",
                    title : "机构号",
                    width : $(window).width() * 0.2,
                    align : "center",
                    sortable : true
                },
                {
                    field : "application",
                    title : "接口名字",
                    width : $(window).width() * 0.3,
                    align : "center",
                    sortable : true
                },
                {
                    field : "reqTime",
                    title : "请求时间",
                    width : $(window).width() * 0.2,
                    align : "center",
                    sortable : true
                }, {
                    field : "respTime",
                    title : "返回时间",
                    width : $(window).width() * 0.2,
                    align : "center",
                    sortable : true
                }, {
                    field : "tradeLongTime",
                    title : "交易耗时",
                    width : $(window).width() * 0.1,
                    align : "center",
                    sortable : true
                }, {
                    field : "customerId",
                    title : "客户编码",
                    width : $(window).width() * 0.2,
                    align : "center",
                    sortable : true
                }, {
                    field : "respCode",
                    title : "返回码",
                    width : $(window).width() * 0.1,
                    align : "center",
                    sortable : true
                },{
                    field : "respDesc",
                    title : "返回描述",
                    width : $(window).width() * 0.3,
                    align : "center",
                    sortable : true
                },{
                    field : "logKey",
                    title : "进程编号",
                    width : $(window).width() * 0.3,
                    align : "center",
                    sortable : true
                },{
                    field : "frmSys",
                    title : "来源系统",
                    width : $(window).width() * 0.2,
                    align : "center",
                    sortable : true
                } ] ],
            pagination : true,
            rownumbers : true,
            showFooter : true,
        });
    var p = $('#viewMessage').datagrid('getPager');
    $(p).pagination({
        pageList : [ 5, 10, 20, 50 ],
        beforePageText : '第',
        afterPageText : '页    共 {pages} 页',
        displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
    });
};
$(function() {
    $.loadList();
});
