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
                showCourse(data)
            }
        }
    })
}
function show() {
    var url = "http://localhost:8090/student/course/show.action"
    var json = {"studentID":JSON.parse(window.localStorage.getItem("data")).userID}
    ajax(url,json)
}
function showCourse(data) {
        var json = data.data
        var tbody = document.getElementById("tbody");
        var row = tbody.rows.length
        console.log(row)
        for (var j =1;j<=row;j++){
            tbody.deleteRow(tbody.rows[j])
        }
        for (var i in  json) {
            var tr = document.createElement("tr")
            if (json[i].state==0){
                tr.innerHTML = ' <tr>\
                                <td class="col-md-2" style="text-align: center">' + json[i].courseID + '</td>\
                                <td class="col-md-2" style="text-align: center">' + json[i].courseName + '</td>\
                                <td class="col-md-2" style="text-align: center">' + json[i].hours + '</td>\
                                \<td class="col-md-2" style="text-align: center">' + json[i].credit + '</td>\
                                \<td class="col-md-2" style="text-align: center">' + json[i].teacherName + '</td>\
                                <td class="col-md-2">\
                                <center><button class="btn btn-default btn-xs btn-info" style="width: 32px;height: 20px;font-size: 10px;text-align: center" onclick="choose(\'' + json[i].courseID + '\')">选课</button></center>\
                                </td>\
                            </tr>';
                tbody.appendChild(tr)
            }else if(json[i].state==1){
                tr.setAttribute("class" , "alert-success");
                tr.innerHTML = ' <tr>\
                                <td class="col-md-2" style="text-align: center">' + json[i].courseID + '</td>\
                                <td class="col-md-2" style="text-align: center">' + json[i].courseName + '</td>\
                                <td class="col-md-2" style="text-align: center">' + json[i].hours + '</td>\
                                \<td class="col-md-2" style="text-align: center">' + json[i].credit + '</td>\
                                \<td class="col-md-2" style="text-align: center">' + json[i].teacherName + '</td>\
                                <td class="col-md-2">\
                                <center><button class="btn btn-danger btn-xs btn-info" style="width: 32px;height: 20px;font-size: 10px;text-align: center" onclick="drop(\'' + json[i].courseID + '\')">退课</button></center>\
                                </td>\
                            </tr>';
                tbody.appendChild(tr)
            }
        }
}
function choose(data) {
    var url = "http://localhost:8090/student/course/choose.action"
    var json = {"studentID":JSON.parse(window.localStorage.getItem("data")).userID,"courseID":data}
    ajax(url,json)
}
function drop(data) {
    var url = "http://localhost:8090/student/course/drop.action"
    var json = {"studentID":JSON.parse(window.localStorage.getItem("data")).userID,"courseID":data}
    ajax(url,json)
}

