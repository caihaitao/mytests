$(function () {
    $(".vote").click(function () {
        $("#iv").show();
        $("#voterId").val(( $(this).parent().parent().find("input").val()));
    });

    $(".closeVote").click(function () {
        $("#voterId").val("");
        $("#iv").hide();
    });
});

function doVote() {
    $('#voteFm').form('submit', {
        onSubmit: function () {
            //进行表单验证
            //如果返回false阻止提交
        },
        success: function (data) {
            // $("#iv").hide();
            if (data == 'success') {
                Dialog.alert("提示：你点击了一个按钮");
                $.messager.alert("操作提示", "操作成功！", "info");
                window.location.reload()
            } else {
                $.messager.alert("error", data)
            }
        }
    });
}