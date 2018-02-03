

$(document).ready(function() {

    $('#edit').on('click', function (event) {
        event.preventDefault();
        var ref = $(this).attr('xxx');

        $.get(ref, function () {

        });
    });
});
