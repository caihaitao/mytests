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
            var vname = $("#vn").val();
            var vphone = $("#vp").val();
            if(typeof(vname) == undefined || $.trim(vname)=='') {
                return false;
            }
            if(typeof (vphone) == undefined || $.trim(vphone) == '') {
                return false;
            }
        },
        success: function (data) {
            $("#iv").hide();

            if (data == 'success') {
                alert("投票成功");
                window.location.reload()
            } else {
                alert(data);
            }
        }
    });
}