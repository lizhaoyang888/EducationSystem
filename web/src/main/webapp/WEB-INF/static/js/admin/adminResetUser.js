function ajax(url,data) {
    $.ajax({
        url: url,
        type: "POST",
        data:data,
        dataType: "JSON",
        async:false,
        success: function (data) {
            if (data.issuccess===false) {
                alert(data.message)
            }else {
                showUser(data)
            }
        }
    })
}
function showUser(data) {
    var json = data.data;
    var tbody = document.getElementById("tbody");
    var row = tbody.rows.length
    for (var i =1;i<=row;i++){
        tbody.deleteRow(tbody.rows[i])
    }
    for (var i in  json){
        var priority = json[i].priority;
        var name;
        if(priority==1){
            name = "教师";
        }else {
            name = "学生";
        }
        var tr = document.createElement("tr")
        tr.innerHTML = ' <tr>\
                            \<td id="userID" class="col-md-2" style="text-align: center">'+ json[i].userID +'</td>\
                                <td class="col-md-2" style="text-align: center">'+ name +'</td>\
                                <td id="tdUsername" class="col-md-2" style="text-align: center">'+json[i].username+'</td>\
                                <td class="col-md-6">\
                                \<div class="col-md-6">\
                                <center><button id="buttonDel" class="btn btn-default btn-xs btn-info" style="width: 32px;height: 20px;font-size: 10px;text-align: center" onclick="del(\''+ json[i].userID +'\',\''+ json[i].priority +'\')">删除</button></center>\
                                \</div>\
                                <div class="col-md-6">\
                                \<center><button i class="btn btn-default btn-xs btn-danger btn-primary" style="width: 32px;height: 20px;font-size: 10px;text-align: center" data-toggle="modal" data-target="#editModal" onclick="temp(\''+ json[i].userID +'\')" )">修改</button></center>\
                                \</div>\
                                </td>\
                            </tr>';
        tbody.appendChild(tr)
    }
}
function show() {
    showUser(ajax("http://localhost:8090/admin/user/show.action",null))
}
function del(userID,priority) {
    ajax("http://localhost:8090/admin/user/delete.action",{"userID":userID,"priority":priority})
}
function add() {
    var priority = document.getElementById('modalState').value
    var username = document.getElementById('modalUsername').value
    var password = document.getElementById('modalPassword').value
    var ID = document.getElementById("modalId").value
    if (priority == 0 || username == 0 || password == 0 || ID == 0) {
        alert("输入不能为空")
    } else {
        if (priority.toString() == "学生") {
            priority = "2";
        } else if (priority.toString() == "教师") {
            priority = "1";
        } else {
            alert("用户字段必须为学生或者教师，请重新输入")
            return
        }
        var json = {"userID": ID, "username": username, "password": password, "priority": priority}
        var url = "http://localhost:8090/admin/user/add.action"
        ajax(url,json)
    }
}

/**  temp保存需要修改的用户ID，当模态框发出请求时使用此参数  */
var tempData;
function temp(data) {
    tempData = data
}
function edit() {
    var password = document.getElementById('modalAddPassword').value
    var json = {"userID":tempData,"password":password}
    var url = "http://localhost:8090/admin/user/reset.action"
    ajax(url,json)
}

