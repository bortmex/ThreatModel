$(function () {
   /* $.extend($.fn.dataTable.defaults, {
        dom: 'frtip'
    });*/

    $('#datatables').DataTable({
        "columns": [
            {
                "data": "id"
            },
            {
                "data": "name"
            },
            {
                "data": "description"
            },
            {
                "data": "sourceOfThreat"
            },
            {
                "data": "theObjectOfTheImpact"
            }
        ],
        "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]]
    });
});

/*
function getAllThreat() {
    $.get( "rest/threat/getAll/", function(data) {
        return JSON.stringify(data);
    });
    /!*$.ajax({
        type: "GET",
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        url: "rest/threat/getAll/",
        data: JSON.stringify(data),
        success: function(data) {
            return data;
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });*!/
}*/
