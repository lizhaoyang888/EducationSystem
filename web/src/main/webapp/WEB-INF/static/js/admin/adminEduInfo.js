function ajax(url,data) {
    $.ajax({
        url: url,
        type: "POST",
        data:data,
        dataType: "JSON",
        async:false,
        success: function (data) {
            console.log(data)
            show_info(data)
        }
    })
}
function show() {
    var url = "http://localhost:8090/admin/edulog/show.action"
    ajax(url,null)
}
function show_info(data) {
    var param = data.data
    var education = document.getElementById("education")
    education.innerHTML=""
    for (var i in param){
        var a = document.createElement("a")
        if (param[i].crateuser!="administrator"){
            if (param[i].state==0){
                a.innerHTML = '<li style="margin-top:2px;margin-bottom: 2px;margin-left: 20px"><a href="##" data-toggle="modal" data-target="#showModal" onclick="show_education('+JSON.stringify(param[i]).replace(/\"/g,"'")+')">'+ param[i].title +"（未审批，申请人："+ param[i].createuser +"）" +'</a></li>'
            } else {
                a.innerHTML = '<li style="margin-top:2px;margin-bottom: 2px;margin-left: 20px"><a href="##" data-toggle="modal" data-target="#showModal" onclick="show_education('+JSON.stringify(param[i]).replace(/\"/g,"'")+')">'+ param[i].title +"（已审批，申请人："+ param[i].createuser +"）"+'</a></li>'

            }
        } else {
            a.innerHTML = '<li style="margin-top:2px;margin-bottom: 2px;margin-left: 20px"><a href="##" data-toggle="modal" data-target="#showModal" onclick="show_education('+JSON.stringify(param[i]).replace(/\"/g,"'")+')">'+ param[i].title +'</a></li>'

        }
        education.appendChild(a)
    }
}
var tempData;
function temp(data) {
    tempData = data;
}
function show_education(data) {
    temp(data.titleID)

    if (data.state!=0){
        document.getElementById("approve").style.visibility = "hidden"
    }
    var title = document.getElementById("title")
    var text = document.getElementById("text")
    title.innerHTML = data.title
    text.innerHTML = data.text
}
function approve() {
    var url = "http://localhost:8090/admin/edulog/approve.action"
    var json = {"titleID": tempData}
    ajax(url,json)
}


function del() {
    document.getElementById("education").innerHTML = '';
    var url = "http://localhost:8090/admin/edulog/delete.action"
    var json = {"titleID": tempData}
    ajax(url,json)
}
function add() {
    document.getElementById("education").innerHTML = '';
    var title = document.getElementById("modalTitle").value
    var text = document.getElementById("modalText").value
    var json = {"title":title,"text":text}
    if(title==0||text==0){
        alert("输入不能为空")
    }else {
        var url = "http://localhost:8090/admin/edulog/add.action"
        ajax(url,json)

    }
}
