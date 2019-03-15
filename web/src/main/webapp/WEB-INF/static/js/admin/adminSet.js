//设置日期时间控件
function Datetime() {
        $('#datetimepicker1').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            locale: moment.locale('zh-cn')
        });
        //默认获取当前日期
        var today = new Date();
        var nowdate = (today.getFullYear()) + "-" + (today.getMonth() + 1) + "-" + today.getDate();
        //对日期格式进行处理
        var date = new Date(nowdate);
        var mon = date.getMonth() + 1;
        var day = date.getDate();
        var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
        document.getElementById("nowdate").value = mydate;
}
function Datetime2() {
    $('#datetimepicker2').datetimepicker({
        language: 'zh-CN',//显示中文
        format: 'yyyy-mm-dd',//显示格式
        minView: "month",//设置只显示到月份
        initialDate: new Date(),
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        locale: moment.locale('zh-cn')
    });
    //默认获取当前日期
    var today = new Date();
    var nowdate = (today.getFullYear()) + "-" + (today.getMonth() + 1) + "-" + today.getDate();
    //对日期格式进行处理
    var date = new Date(nowdate);
    var mon = date.getMonth() + 1;
    var day = date.getDate();
    var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-" + (day < 10 ? "0" + day : day);
    document.getElementById("nowdate2").value = mydate;
}
function show() {
    var url = "http://localhost:8090/admin/flow/show.action"
    $.ajax({
        url: url,
        type: "POST",
        data:null,
        dataType: "JSON",
        async:false,
        success: function (data) {
            if (data.issuccess===false) {
                alert(data.message)
            }else {

                var select = document.getElementById("select")
                var div = document.getElementById("div")
                for (var j in  data.data){
                    if (data.data[j].operator!=null){
                        var p = document.createElement("p")
                        p.setAttribute("style","margin-left: 10px;height: 15px;font-size:15px")
                        p.innerHTML = data.data[j].remark + ":" + data.data[j].operator.replace('/','到')
                        div.appendChild(p)
                    }
                }
                for (var i in  data.data) {
                    var option = document.createElement("option")
                    option.innerHTML =data.data[i].remark
                    option.setAttribute("id",data.data[i].id)
                    select.appendChild(option)
                }
                select.selectedIndex = -1
                $('#datetimepicker1').hide()
                $('#datetimepicker2').hide()
            }
        }
    })
}
function choose() {
    var id = $("#select option:selected").attr("id")
    if (id<100){
        $('#datetimepicker1').show()
        $('#datetimepicker2').show()
    }else if (id>1000){
        $('#datetimepicker1').show()
    } else {

    }
}
function btn() {
    var id = $("#select option:selected").attr("id")
    var nowdate1 = document.getElementById("nowdate").value
    var nowdate2 = document.getElementById("nowdate2").value
    if (id<100){
        var json = {"id":id,"start":nowdate1,"limit":nowdate2}
        $.ajax({
            url: "http://localhost:8090/admin/flow/edit.action",
            type: "POST",
            data:json,
            dataType: "JSON",
            async:false,
            success: function (data) {
                if (data.issuccess===false) {
                    alert(data.message)
                }else {
                    location.reload()
                }
            }
        })
    }else if (id>1000){

    } else {

    }

}
