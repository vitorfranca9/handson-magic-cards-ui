$(document).ready(function() {
    $('.dataTable').DataTable( {
        "bFilter":false,
        "processing": true,
        "serverSide": true,
        "ajax": "/cards/data",
        "columns": [
            {"data":"gathererId"},
            {"data":"englishName"},
            {"data":"ptBrName"},
            {
                "data": null,
                "render": function (data, type, row, meta) {
                    return '<a href="/cards/update/' + row['gathererId'] + '" class="editor_edit">Edit</a> | <a href="/cards/delete/' + row['gathererId'] + '" class="editor_remove">Delete</a>';
                }
            }
        ]
    } );
    
    $('.dataTableExpansion').DataTable( {
        "bFilter":false,
        "processing": true,
        "serverSide": true,
        "ajax": "/cards/data",
        "columns": [
            {"data":"expansionId"},
            {"data":"name"},
            {"data":"ptBRName"},
            {
                "data": null,
                "render": function (data, type, row, meta) {
                    return '<a href="/cards/updateExpansion/' + row['expansionId'] + '" class="editor_edit">Edit</a> | <a href="/cards/deleteExpansion/' + row['expansionId'] + '" class="editor_remove">Delete</a>';
                }
            }
        ]
    } );
} );