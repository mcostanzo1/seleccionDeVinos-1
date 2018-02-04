

$(document).ready(function() {

    $('.addStock').click(function(){

        var $row = $(this).closest("tr");

        $('#stockTitle').text("Editar "+$row.find('#table-name').text()+" - "+$row.find('#table-variety').text());

        $('#productId').val($row.find('#table-productId').text());
        $('#quantityOnStock').text($row.find('#table-quantityOnStock').text());
        $('#quantityPerBox').text($row.find('#table-quantityPerBox').text());
        $('#boxes').val(0);
        $('#units').val(0);
        calculateStock();

    });

    $('#boxes').focusout(function(){
        calculateStock();
    });

    $('#units').focusout(function(){
        calculateStock();
    });

    function calculateStock() {
        var boxes=$('#boxes').val();
        var totalFromBoxes=0;
        if (boxes!== ""){
            totalFromBoxes = boxes * $('#quantityPerBox').text();
        }
        var units=$('#units').val();
        if (units !== ""){
            units = parseInt(units);
        }
        var totalToAdd = totalFromBoxes + units;
        $('#totalToAdd').text(totalToAdd);
        $('#finalTotal').text(parseInt(totalToAdd) + parseInt($('#quantityOnStock').text()));
        $('#finalTotalInput').val(parseInt(totalToAdd) + parseInt($('#quantityOnStock').text()));
    }

    /*
    $('.editClient').click(function() {
        //console.log("Prueba entra metodo");
        var $row = $(this).closest("tr");    // Find the row

        $('.title').text("Editar cliente");

        $('#clientForm #clientId').val($row.find("#table-clientId").text());
        $('#clientForm #name').val($row.find("#table-name").text());
        $('#clientForm #address').val($row.find("#table-address").text());
        $('#clientForm #phone').val($row.find("#table-phone").text());
        $('#clientForm #email').val($row.find("#table-email").text());

        //$('#clientForm').attr('method','put')
        $('#clientForm').attr('action','/clients/'+$row.find("#table-clientId").text()+'/edit');
    });

    $('.newClient').click(function() {

        $('.title').text("Agregar nuevo cliente");

        $('#clientForm #clientId').val('');
        $('#clientForm #name').val('');
        $('#clientForm #address').val('');
        $('#clientForm #phone').val('');
        $('#clientForm #email').val('');

        $('#clientForm').attr('action','/clients/create');
        //$('#clientForm').attr('method','post')
    });
    */

    /*
    $(".editClient").on("click", function (event) {
        event.preventDefault();


        var href = $(this).attr('xxx');

        $.get(href, function () {

        });
    });*/
});
