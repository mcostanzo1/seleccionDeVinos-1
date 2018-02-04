



$(document).ready(function() {

    $('.clickable-row').click(function () {
        var $row = $(this).closest("tr");
        var href = '/lists/'+$row.find("#table-listId").text()+'/details';
        window.location.href = href;
    });

});
