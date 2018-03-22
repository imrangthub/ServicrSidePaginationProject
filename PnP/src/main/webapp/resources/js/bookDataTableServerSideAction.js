$(document).ready(function(){
	
	var	serverSideActionDataTable = $('#serverSideActionDataTable').DataTable({
	    ajax: {
	        "url": '/PnP/bookDataTableServerSideAction/list',
//	        "data": 'data',
	    	"serverSide" : false,
	        "DisplayLength": 2,
	         data: function () {
	        	return 'type='+$('#typeFilter').val();
            },
	    },
	    columns: [
	        { "data": "id" },
            { "data": "name" },
            { "data": "type" },
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
	    ]
	});
   $('#typeFilter').on('change', function (e) {
      $('#serverSideActionDataTable').DataTable().ajax.reload();    
    });



 
});