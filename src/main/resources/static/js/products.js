var editor; // use a global for the submit and return data rendering in the examples
 
$(document).ready(function() {
    editor = new $.fn.dataTable.Editor( {
        ajax: {
            create: {
                type: 'POST',
                url:  '../products/'
            },
            edit: {
                type: 'PUT',
                url:  '../products/'
            },
            remove: {
                type: 'DELETE',
                url:  '../products/id=_id_'
            }
        },
        table: "#products",
        fields: [ {
                label: "ID de Producto:",
                name: "productId"
            }, {
                label: "Nombre:",
                name: "name"
            }, {
                label: "Variedad:",
                name: "variety"
            }, {
                label: "Bodega:",
                name: "cellar"
            }, {
                label: "Precio de lista:",
                name: "price"
            }, {
                label: "Cant. por Caja:",
                name: "quantityOnBox"
            }
        ]
    } );
 
    $('#products').DataTable( {
        dom: "Bfrtip",
        ajax: "../products/all/",
        columns: [
            { data: "productId" },
            { data: "name" },
            { data: "variety" },
            { data: "cellar" },
            { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) },
            { data: "quantityOnBox" }
        ],
        select: true,
        buttons: [
        		{ extend: "create", editor: editor },
            { extend: "edit",   editor: editor },
            { extend: "remove", editor: editor }
        ]
    } );
} );