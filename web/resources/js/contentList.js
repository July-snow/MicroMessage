function changeContent(basePath){
    $("#mainForm").attr("action",basePath+"servlet/DeleteBatchServlet");
    $("#mainForm").submit();
}

function insertContent(){
    $("#newContent").show();
}

function insertOneContent(basePath) {
    var command_id = $('#command_id').val();
    var content = $('#content').val();
    window.location.href=basePath+"servlet/InsertOneContentServlet?command_id="+command_id+"&content="+content;
   /* $("#mainForm").attr("action",basePath+"servlet/InsertOneContentServlet?command_id="+$('#command_id').text+"&content="+$('#content').val());
    $("#mainForm").submit();*/
}

function updateOneContent(basePath,contentId) {

    var command_id = $('#command_id').val();
    var content_id = $('#con'+contentId).val();
    var content = $('#content'+contentId).val();
    $('#content'+contentId).attr("readonly","readonly");
    window.location.href=basePath+"servlet/UpdateOneContentServlet?command_id="+command_id+"&content="+content+"&content_id="+content_id;
  /*
    $("#mainForm").attr("action",basePath+"servlet/UpdateOneContentServlet?command_id="+$('#command_id').text+"&content_id="+$('#content_id').text);
    $("#mainForm").submit();*/
}

function modifyContent(content_id) {
    // var contentSelect =  $('#contents')
    // for (var i = 0; i < index; i++) {
    //     contentSelect =  contentSelect.next()
    //
    // }
  //  $(".contentList").each(function () {
        $('#content'+content_id).removeAttr("readonly");

    //  });
    // $("#contents").removeAttr("readonly");
}

