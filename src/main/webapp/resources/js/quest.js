$(function () {
    $("#submit").click(function () {
        var questionpojo = {};
        for (var i = 1; i < 16; i++) {
            questionpojo["question" + i] = $("#question" + i).val();
        }
        $.ajax({
            type: "POST",
            contentType : 'application/json',
            url: "rest/question/answerthreat/save/",
            data: JSON.stringify(questionpojo),
            success: function() {
                $(location).attr('href',"answerofquestion");
            },
            complete: function () {
                /*window.location.href = "answerofquestion";*/
            },
            error: function (err) {
                alert("AJAX error in request: " + JSON.stringify(err, null, 2));
            }
        }).always(function(jqXHR, textStatus) {
            if (textStatus !== "success") {
                alert("Error: " + jqXHR.statusText);
            }
        });
        return false;
    });
});