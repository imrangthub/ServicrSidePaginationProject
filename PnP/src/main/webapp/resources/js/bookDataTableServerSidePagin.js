  var serverSidePaginationTable;
$(document).ready(function(){
	
  serverSidePaginationTable = $('#serverSidePaginationTable').DataTable({
	"bAutoWidth": true,
    "scrollX": false,
    "bServerSide": true, // for process server side
    "iDisplayLength": 5,
    "lengthMenu": [[5, 10, 20, 50], [5,10, 20, 50]],
    "stateSave": true,  // restore table state on page reload.
    "processing": true, // for show progress bar
    "filter": true, // this is for disable filter (search box)
    "aaSorting": [0, 'asc'],
	"oLanguage": {
        "sSearch": "Search Book:"
    },
     "ajax": {
         "url": "/PnP/bookDataTableServerSidePagin/list",
         "type": "GET",
         "data":function(data){
        	 data.bookType = $('#typeFilter').val();
         },
     },
  
     
     "columns": [
//         { "data": "id", "bVisible" : false},
         { "data": "name", "orderable": true },
         { "data": "type", "orderable": false, "searchable": false },
         {
 			// add another column not persisted on the server-side
 			data : null,
 			// order is not available
 			orderable : false,
 			// yet filter should be available through the method
 			// findAll(DataTablesInput input, Specification<T>
 			// additionalSpecification)
 			searchable : false,
 			render : function(data, type, row) {
 				return '<a href=""  class="edit-reference" referenceId='+row.id+'>Edit</a> | <a href=""  class="delete-reference" referenceId='+row.id+'>Delete</a>';
 			}
         }
     ],
     
 });
  
  $('#typeFilter').on('change', function (e) {
    $('#serverSidePaginationTable').DataTable().ajax.reload();		 
 });
	

    
    $('#serverSidePaginationTable').on('click', 'a.delete-reference', function (e) {
        var selectRow = $(this).parents('tr');
        var confirmDel = confirm("Are you sure?");
        if (confirmDel == true) {
            var control = this;
            var referenceId = $(control).attr('referenceId');
         	$.ajax({
   			 url:'delete/'+referenceId,
   			 type:'POST',
   			 success: function(data){
//   				 $('#serverSidePaginationTable').DataTable().ajax.reload();
   				serverSidePaginationTable.draw(false);
   				  if (data.isError == false) {
   					  alert("Delated operation failed");
                     } else {
                         alert("Successfully delated");
                    	 
                     }
   			 }
   			 
   		 });
        }
        e.preventDefault();
    });
    
    
    $('#serverSidePaginationTable').on('click', 'a.edit-reference', function (e) {
        var selectRow = $(this).parents('tr');
        var confirmDel = confirm("Are you sure?");
        if (confirmDel == true) {
            var control = this;
            var referenceId = $(control).attr('referenceId');
            alert("Edit Id is: "+referenceId);
        }
        e.preventDefault();
    });
    

 
});