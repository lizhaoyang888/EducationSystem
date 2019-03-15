function ajax(url,data) {
    $.ajax({
        url: url,
        type: "POST",
        data:data,
        dataType: "JSON",
        async:false,
        success: function (data) {
            console.log(data)
            if (data.issuccess===false) {
                alert(data.message)
            }else {
                    if (data.data.teacherList!=null){
                        window.localStorage.setItem("teacherList",JSON.stringify(data.data.teacherList));
                    }
                showCourse(data)
            }
        }
    })
}

function showCourse(data) {
    var json = data.data.course
    var tbody = document.getElementById("tbody");
    var row = tbody.rows.length
    for (var i =1;i<=row;i++){
        tbody.deleteRow(tbody.rows[i])
    }
    for (var i in  json) {
        var tr = document.createElement("tr")
        tr.innerHTML = ' <tr>\
                                <td class="col-md-2" style="text-align: center">' + json[i].courseID + '</td>\
                                <td class="col-md-2" style="text-align: center">' + json[i].courseName + '</td>\
                                <td class="col-md-2" style="text-align: center">' + json[i].hours + '</td>\
                                \<td class="col-md-2" style="text-align: center">' + json[i].credit + '</td>\
                                \<td class="col-md-2" style="text-align: center">' + json[i].teacherName + '</td>\
                                <td class="col-md-2">\
                                <center><button class="btn btn-default btn-xs btn-info" style="width: 32px;height: 20px;font-size: 10px;text-align: center" onclick="del(\'' + json[i].courseID + '\')">删除</button></center>\
                                </td>\
                            </tr>';

        tbody.appendChild(tr)
    }
}
function show() {
    var url = "http://localhost:8090/admin/course/show.action";
    ajax(url,null)
}
function add() {
    var  courseName = document.getElementById('modalCourseName').value
    var  courseTime = document.getElementById('modalCourseTime').value
    var  courseScore = document.getElementById('modalCourseScore').value
    var  courseTeacher = document.getElementById('modalCourseTeacher').value
    if(courseName==0||courseTime==0||courseScore==0||courseTeacher==0){
        alert("输入不能为空")
    }else {
        var array = JSON.parse(window.localStorage.getItem("teacherList"))
        var teacherID;
        for (var i in array){
            if (array[i].username == courseTeacher){
                teacherID = array[i].userID
            }
        }
        var json = {"courseName":courseName,"hours":courseTime,"credit":courseScore,"teacherID":teacherID}
        var url = "http://localhost:8090/admin/course/add.action";
        ajax(url,json)
    }
}
function del(data) {
    var url = "http://localhost:8090/admin/course/delete.action"
    var json = {"courseID": data}
    ajax(url,json)
}
var global = 0;
function setTeacherList() {
    if (global==0){
        var teacherList = document.getElementById("teacherList")
        var teacherListJson = JSON.parse(window.localStorage.getItem("teacherList"))
        console.log(teacherListJson)
        for (var i in teacherListJson){
            var option  = document.createElement("option")
            option.innerHTML =teacherListJson[i].username
            teacherList.appendChild(option)
        }
        global = 1
    }
}

