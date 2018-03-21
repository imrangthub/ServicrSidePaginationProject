function removebook(){
alert("remove Book");
}
function editInfo(){
	alert("Edit");
}
$(document).ready(function(){

		 $.ajax({
			 url:'/PnP/bookTwoList?pageNumber=1',
			 type:'POST',
			 success: function(data){
				 console.log(JSON.stringify(data));
				 $('#totalRow').val(data.dataMap.totalRow);
		      var refRowIndex=1;
			  data.bookList.forEach(function(element, index) {
			      	var newRow = '<tr>' +
				            '<td><label id="bookId'+ refRowIndex + '"style="display: none">' + element.id + '</label>' +
				            '<label id="id' +refRowIndex + '">' + element.id  + '</label></td>' +
				            '<td><label id="type' +refRowIndex + '">' + element.name + '</label></td>' +
				            '<td><label id="expectedDate' +refRowIndex + '">' + element.type + '</label></td>' +           
				            '<td><a href="#" onclick="editInfo(this,' +refRowIndex + ')"> Edit</a>' +
				            '<a href="#" onclick="removebook(this,' +refRowIndex + ')"> Delete</a></td>' +          
				            '</tr>';      	
		            $ ("#bookTbody").append(newRow); 
		            refRowIndex++; 
		            
			  });			
			 }			 
		 });
		 
	  $(window).on('load', function () {
			$('#pagination-demo').twbsPagination({
				
		        totalPages:$('#totalRow').val(),
		        visiblePages: 3,
		        next: 'Next',
		        prev: 'Prev',
		        onPageClick: function (event, page) {
		        	 $("#bookTbody").empty(); 
		        	load(page);
		            console.log("Current page"+page);
		        }
		    });
	    });
 
});

var load = function(requestPage){
	 $.ajax({
		 url:'/PnP/bookTwoList?pageNumber='+requestPage,
		 type:'POST',
		 success: function(data){
			 console.log(JSON.stringify(data));
			 $('#totalRow').val(data.dataMap.totalRow);
	      var refRowIndex=1;
		  data.bookList.forEach(function(element, index) {
		      	var newRow = '<tr>' +
			            '<td><label id="bookId'+ refRowIndex + '"style="display: none">' + element.id + '</label>' +
			            '<label id="id' +refRowIndex + '">' + element.id  + '</label></td>' +
			            '<td><label id="type' +refRowIndex + '">' + element.name + '</label></td>' +
			            '<td><label id="expectedDate' +refRowIndex + '">' + element.type + '</label></td>' +           
			            '<td><a href="#" onclick="editInfo(this,' +refRowIndex + ')"> Edit</a>' +
			            '<a href="#" onclick="removebook(this,' +refRowIndex + ')"> Delete</a></td>' +          
			            '</tr>';      	
	            $ ("#bookTbody").append(newRow); 
	            refRowIndex++; 
	            
		  });			
		 }			 
	 });
}
