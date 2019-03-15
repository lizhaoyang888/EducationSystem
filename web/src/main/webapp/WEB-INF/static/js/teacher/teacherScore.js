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
                showScore(data)
            }
        }
    })
}
function show() {
    var url = "http://localhost:8090/teacher/score/show.action"
    var json = {"teacherID":JSON.parse(window.localStorage.getItem("data")).userID}
    ajax(url , json)
}
function showScore(data) {
    var param = data.data
    var tbody = document.getElementById("tbody");
    var row = tbody.rows.length
    for (var j = 1; j <= row; j++) {
        tbody.deleteRow(tbody.rows[j])
    }
    for (var i in  param) {
        var tr = document.createElement("tr")
            if (param[i].score==0){
                tr.innerHTML = ' <tr>\
                                <td class="col-md-4" style="text-align: center">' + param[i].courseName + '</td>\
                                <td class="col-md-4" style="text-align: center">' + param[i].studentName + '</td>\
                                <td class="col-md-4" style="text-align: center"><center><button class="btn btn-default btn-xs btn-info" style="width: 32px;height: 20px;font-size: 10px;text-align: center" onclick="add(\'' + param[i].studentID + '\',\'' + param[i].courseID + '\')">录入</button></center></td>\
                            </tr>';
            }else {
                tr.innerHTML = ' <tr>\
                                <td class="col-md-4" style="text-align: center">' + param[i].courseName + '</td>\
                                <td class="col-md-4" style="text-align: center">' + param[i].studentName + '</td>\
                                <td class="col-md-4" style="text-align: center">' + param[i].score + '</td>\
                            </tr>';
            }
            tbody.appendChild(tr)
    }
}
function add(studentID,courseID) {
    var score =  prompt("请输入成绩","")
    var url = "http://localhost:8090/teacher/score/give.action"
    var json = {"studentID":studentID,"courseID":courseID , "score": score , "teacherID" : JSON.parse(window.localStorage.getItem("data")).userID}
    ajax(url,json)
}
function output() {
    var json = {"teacherID": JSON.parse(window.localStorage.getItem("data")).userID}
    var url = "http://localhost:8090/teacher/score/output.action"
    console.log(json)
    $.ajax({
        url: url,
        type: "POST",
        data:json,
        dataType: "JSON",
        async:false,
        success: function (data) {
            console.log(data)
            if (data.issuccess==true){
                window.open(data.data)
            }
        }
    })
}
