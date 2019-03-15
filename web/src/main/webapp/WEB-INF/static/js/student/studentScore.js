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
    var url = "http://localhost:8090/student/score/show.action"
    var json = {"studentID":JSON.parse(window.localStorage.getItem("data")).userID}
    ajax(url,json)
}
function showScore(data) {
    var param = data.data
    var tbody = document.getElementById("tbody");
    var row = tbody.rows.length
    console.log(row)
    for (var j = 1; j <= row; j++) {
        tbody.deleteRow(tbody.rows[j])
    }
    for (var i in  param) {
        var tr = document.createElement("tr")
            if (param[i].score == 0) {
                tr.innerHTML = ' <tr>\
                                <td class="col-md-6" style="text-align: center">' + param[i].courseName + '</td>\
                                <td class="col-md-6" style="text-align: center"></td>\
                            </tr>';
            } else if (60<=param[i].score){
            tr.setAttribute("class" , "alert-success")
                tr.innerHTML = ' <tr>\
                                <td class="col-md-6" style="text-align: center">' + param[i].courseName + '</td>\
                                <td class="col-md-6" style="text-align: center">' + param[i].score + '</td>\
                            </tr>';
            }else if (param[i].score<=60){
                tr.setAttribute("class" , "alert-danger")
                tr.innerHTML = ' <tr class="alert-danger">\
                                <td class="col-md-6" style="text-align: center">' + param[i].courseName + '</td>\
                                <td class="col-md-6" style="text-align: center">' + param[i].score + '</td>\
                            </tr>';
            }
            tbody.appendChild(tr)
        }
}

