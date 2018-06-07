/*$(function () {

    $("#target").submit(function () {

        var lolz = $("#name").val();
        $.ajax({
            type: "POST",
            url: "threatyes/",
            data: {name: lolz},
            error: function (err) {
                alert("AJAX error in request: " + JSON.stringify(err, null, 2));
            },
            success: function() {
                $('#editRow').modal('hide');
            }
        });
        return false;
    });

});*/

function show() {
    $('#editRow').modal();
}

function dontshow() {
    $('#editRow').modal('hide');
}