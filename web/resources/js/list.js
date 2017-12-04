function deleteBatch(basePath){

    /**
     * 删除信息
     */
    /*
    document.getElementById("mainForm").setAttribute("action",basepath+"servlet/DeleteBatchServlet");
     document.getElementById("mainForm").submit();
     */

   $("#mainForm").attr("action",basePath+"servlet/DeleteBatchServlet");
   $("#mainForm").submit();

    
}

/**
 * 修改当前页码时，重新调用后台查询
 */
function changeCurrentPage(currentPage) {
   $("#currentPage").val(currentPage);
   $("#mainForm").submit();
}