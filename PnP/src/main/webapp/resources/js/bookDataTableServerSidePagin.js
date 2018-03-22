$(document).ready(function(){
	
    $('#serverSidePaginationTable').DataTable({
        "processing": true,
        "serverSide": true,
        "iDisplayLength": 5,
        "ajax": {
            "url": "/PnP/bookDataTableServerSidePagin/test",
            "type": "GET"
        },
        "columns": [
            { "data": "id" },
            { "data": "name" },
            { "data": "type" }
        ]
    });
	
//	$('#serverSidePaginationTable').DataTable( {
//	    serverSide: true,
//	    ajax: {
//	        url: '/PnP/bookDataTableServerSidePagin/test',
//	        dataFilter: function(data){
//	            var json = jQuery.parseJSON( data );
//	             
//	            alert(JSON.stringify( data ));
//	            
//	            json.recordsTotal = json.total;
//	            json.recordsFiltered = json.total;
//	            json.data = json.bookList;
//	 
//	            return JSON.stringify( json ); // return JSON string
//	        }
//	    }
//	} );
	
	
//	    $('#serverSidePaginationTable').DataTable( {
//	        "processing": true,
//	        "serverSide": true,
//	        "ajax": "/PnP/bookDataTableServerSidePagin/test"
//	    });


	
	

//	var	serverSideActionDataTable = $('#serverSidePaginationTable').DataTable({
//	    ajax: {
//	        "url": '/PnP/bookDataTableServerSidePagin/list',
////	        "data": 'data',
//	    	"serverSide" : true,
//	        "DisplayLength": 2,
//	         data: function () {
//	        	return 'type='+$('#typeFilter').val();
//            },
//	    },
//	    columns: [
//	        { "data": "id" },
//            { "data": "name" },
//            { "data": "type" },
//            {
//    			// add another column not persisted on the server-side
//    			data : null,
//    			// order is not available
//    			orderable : false,
//    			// yet filter should be available through the method
//    			// findAll(DataTablesInput input, Specification<T>
//    			// additionalSpecification)
//    			searchable : false,
//    			render : function(data, type, row) {
//    				return '<a href=""  class="edit-reference" referenceId='+row.id+'>Edit</a> | <a href=""  class="delete-reference" referenceId='+row.id+'>Delete</a>';
//    			}
//            }
//	    ]
//	});
//   $('#typeFilter').on('change', function (e) {
//      $('#serverSidePaginationTable').DataTable().ajax.reload();    
//    });


 
});