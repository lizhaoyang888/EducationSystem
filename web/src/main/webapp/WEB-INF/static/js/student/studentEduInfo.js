var tempData;
function temp(data) {
    tempData = data;
}
function show() {
    $.ajax({
        url:"http://localhost:8090/student/edulog/find.action",
        data:{"studentID":JSON.parse(window.localStorage.getItem("data")).userID},
        type:"POST",
        dataType: "JSON",
        success:function (data) {
            console.log(data)
            var param = data.data
            var education = document.getElementById("education")
            for (var i in param){
                console.log(param[i])
                var json2 = {"titleID":param[i].titleID,"title":param[i].title,"text":param[i].text}
                var a = document.createElement("a")
                if (param[i].state==1){
                    a.innerHTML = '<li style="margin-top:2px;margin-bottom: 2px;margin-left: 20px;"><a href="##" style="color:#B03060" data-toggle="modal" data-target="#showModal" onclick="show_education('+JSON.stringify(json2).replace(/\"/g,"'")+');response(this)">'+ param[i].title +"("+ param[i].createuser +")"+'</a></li>'

                }else {
                    a.innerHTML = '<li style="margin-top:2px;margin-bottom: 2px;margin-left: 20px"><a href="##"  data-toggle="modal" data-target="#showModal" onclick="show_education('+JSON.stringify(json2).replace(/\"/g,"'")+');response(this)">'+ param[i].title +"("+ param[i].createuser +")"+'</a></li>'

                }
                education.appendChild(a)
            }
        }
    })

}
function show_education(data) {
    console.log(data)
    temp(data.titleID)
    var title = document.getElementById("title")
    var text = document.getElementById("text")
    title.innerHTML = data.title
    text.innerHTML = data.text
    $.ajax({
        url: "http://localhost:8090/student/edulog/see.action",
        type: "POST",
        data: {"titleID":data.titleID,"studentID":JSON.parse(window.localStorage.getItem("data")).userID},
        dataType: "JSON",
        success:function (data) {
            // if(json==1){
            //     var Count = document.getElementById("count")
            //     count = document.getElementById("count").innerHTML-1
            //     if (count==0){
            //         Count.style.display = "none";
            //     }else {
            //         Count.innerHTML = count
            //     }
            // }
        }

    })
}
function response(e) {
    e.style.color = '#B03060'
}
