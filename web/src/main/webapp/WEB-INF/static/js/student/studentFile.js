/**
 *   全局变量
 */
//通过数组保存点击文件夹记录路径，用于返回上一级的功能
var a = 0;//保存点击文件夹记录
var b;//缓存变量
var array = new Array();//通过数组保存
var PathNow;//当前路径

function show() {
    $.ajax({
        url: "http://localhost:8090/student/file/show.action",
        dataType:"JSON",
        type: "POST",
        async:false,
        success: function (data) {
            console.log(data)
            traversal(data.data)
        }
    })
}
function getCaption(data) {
    console.log(data)
    var index = data.lastIndexOf("\\");
    data = data.substring(index+1,data.length);
    return data
}


function back(data) {
    array.pop()
    a=a-2;
    traversal(data)
}
function traversal(data) {
    console.log(data)
    PathNow = data.filePath
    array[a] = data;
    a++;
    if(a-2<0){
        b=0
    }else {
        b=a-2
    }
    if (data.children!=null){
        var filepath = document.getElementById("filepath")
        if (a-2<0){
            filepath.innerHTML = "全部文件  | 路径 : " + data.filePath
        }else {
            filepath.innerHTML = '<a onclick="back('+ JSON.stringify(array[b]).replace(/\"/g,"'") +')">返回上一级</a>' +"  | 路径 : " + data.filePath
        }
        var directory = document.getElementById("directory");
        var row = directory.rows.length
        for (var i =1;i<=row;i++){
            directory.deleteRow(directory.rows[i])
        }
        if (data.leaf){
            for (var i=0;i<data.children.length;i++){
                var tr = document.createElement("tr");
                tr.innerHTML = '<td class="col-md-1"><input type="checkbox" onclick="respond(this,'+ JSON.stringify(data.children[i]).replace(/\"/g,"'") +')"></td>' +
                    '<td class="col-md-11" ondblclick="traversal('+ JSON.stringify(data.children[i]).replace(/\"/g,"'") +')">'+ getCaption(data.children[i].fileName) +'</td>';
                directory.appendChild(tr)
            }
        }
    }
}
function respond(obj,data) {
    var expand = document.getElementById("expand")
    if(obj.checked){
        console.log(data)
        expand.innerHTML =
            '        <button class="btn btn-default pull-right" id="btn_download" onclick="download('+ JSON.stringify(data).replace(/\"/g,"'") +')">下载  <span class="glyphicon glyphicon-save"></span></button>\n'
    }else {
        expand.innerHTML = null
    }
}
function download(data) {
    window.open("http://localhost:8080/"+data.filePath)

}
