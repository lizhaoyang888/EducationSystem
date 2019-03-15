/**
 *   全局变量
 */
//通过数组保存点击文件夹记录路径，用于返回上一级的功能
var a = 0;//保存点击文件夹记录
var b;//缓存变量
var array = new Array();//通过数组保存
var PathNow;//当前路径

function upload() {
    var form1 = document.createElement("form");
    form1.setAttribute("id","form1");
    document.body.appendChild(form1)
    var inputObj=document.createElement('input')
    inputObj.setAttribute('id','file');
    inputObj.setAttribute('type','file');
    inputObj.setAttribute('name','file');
    inputObj.setAttribute("style",'visibility:hidden');
    inputObj.click()
    form1.appendChild(inputObj)
    inputObj.onchange = function () {
        form1.enctype = "multipart/form-data";
        var formData = new FormData();
        formData.append('file' , $("#file")[0].files[0]);
        formData.append('path',PathNow)
        $.ajax({
            url:"http://localhost:8090/teacher/file/upload.action",
            contentType:false,
            cache:false,
            processData:false,
            type:"POST",
            data:formData,
            success:function (data) {
                if (data.issuccess==true) {
                    window.location.reload();
                }
            }
        })
    }

}
function show() {
    $.ajax({
        url: "http://localhost:8090/teacher/file/show.action",
        data:{"userID":JSON.parse(window.localStorage.getItem("data")).userID},
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
    var index = data.lastIndexOf("\\");
    data = data.substring(index+1,data.length);
    return data
}

function back(data) {
    array.pop()
    a=a-2;
    console.log(a)
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
            '    <button class="btn btn-default pull-right hidden" id="btn_move">移动到</button>\n' +
            '            <button class="btn btn-default pull-right hidden" id="btn_copy">复制到</button>\n' +
            '            <button class="btn btn-default pull-right hidden" id="btn_rename">重命名</button>\n' +
            '            <button class="btn btn-default pull-right" id="btn_delete" onclick="del('+ JSON.stringify(data).replace(/\"/g,"'") +')">删除  <span class="glyphicon glyphicon-trash"></span></button>\n' +
            '        <button class="btn btn-default pull-right" id="btn_download" onclick="download('+ JSON.stringify(data).replace(/\"/g,"'") +')">下载  <span class="glyphicon glyphicon-save"></span></button>\n'
    }else {
        expand.innerHTML = null
    }

}

function del(data) {
    console.log(data)
    $.ajax({
        url: "http://localhost:8090/teacher/file/delete.action",
        data:{"file":data.filePath},
        dataType:"JSON",
        type: "POST",
        async:false,
        success:function (data) {
            if (data.issuccess==true){
                window.location.reload();
            }
        }
    })
}
function download(data) {
    window.open("http://localhost:8080/"+data.filePath)

}

