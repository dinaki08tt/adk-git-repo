	
	function getCombos(){
		
		var geturl = "http://localhost:8080/sampleapp/rest/tour/category/getAll";
		
		$.ajax({
		    type: "GET",
		    url: geturl,
		    success: function(data, status, xhr) {
		    	var select = $('#category');
	            $.each(data, function(k,v){
	            	var options = '';
		            for (var x = 0; x < v.length; x++) {
		                options = '<option value="' + v[x].categoryId + '">' + v[x].categoryName +'-'+v[x].gender+'-'+v[x].matchType+ '</option>';
			            select.append(options);
			        }
	            });
	            console.log(select);
		    },
		    error: function(xhr, status, error) {
		        console.log(xhr+":"+status+":"+error);
		
		    }
		});
		$("#category").trigger("change");

		geturl = "http://localhost:8080/sampleapp/rest/tour/getAll";
		$.ajax({
		    type: "GET",
		    url: geturl,
		    success: function(data, status, xhr) {
		    	var select = $('#tour');
		    	$.each(data, function(k,v){
	            	var options = '';
		            for (var x = 0; x < v.length; x++) {
		                options = '<option value="' + v[x].tourId + '">' + v[x].tourName +'-'+v[x].venue+'-'+v[x].organizer+ '</option>';
		                select.append(options);
		            }
		            
	            });
	            
		    },
		    error: function(xhr, status, error) {
		        console.log(xhr+":"+status+":"+error);
		
		    }
		});
		$("#tour").trigger("change");
	}

function createTour(){
	var name = $("#tourName").val();
	var orgName = $("#orgName").val();
	var venue = $("#venue").val();
	
	///create/{tourName}/{org}/{venue}
	var geturl = "http://localhost:8080/sampleapp/rest/tour/create/"+name+"/"+orgName+"/"+venue;
	
	$.ajax({
	    type: "GET",
	    url: geturl,
	    success: function(data, status, xhr) {
	     	//alert(data.tourId+":"+data.tourName+":"+data.venue+":"+data.organizer);
	    	
	    	console.log(data.tourId+":"+data.tourName+":"+data.venue+":"+data.organizer);
	
	    	//var data1 = $() 
	    	$("#tourId").text("Tournament Id :"+data.tourId);
	    	$("#tourName").text("Tournament Name :"+data.tourName);
	    	$("#tourVenue").text("Venue :"+data.venue);
	    	$("#tourOrganizer").text("Organizer :"+data.organizer);
	    },
	    error: function(xhr, status, error) {
	        console.log(xhr+":"+status+":"+error);
	        $("#error").text("Duplicate Tournament Name");
	    }
	});

}


function getPlayer(){
	var id = $("#search").val()
	var geturl = "http://localhost:8080/sampleapp/rest/player/get/"+id;
	
	$.ajax({
        url: geturl
    }).then(function(data) {
    	$('.play_id').text('Player ID :'+ data.playerId);
    	$('.play_playerName').text('Player Name :'+data.playerName);
    	$('.play_fatherName').text('Father Name :'+data.fatherName);
    	$('.play_motherName').text('Mother Name :'+data.motherName);
    	$('.play_occupation').text('Occupation :'+data.occupation);
    	$('.play_dob').text('Date of Birth :'+data.dob);
    	$('.play_dateOfJoining').text('Date of Joining :s'+data.dateOfJoining);
    	$('.play_mobileNumber').text('Mobile No :'+data.mobileNumber);
    	$('.play_address').text('Address :'+data.address);
    	$('.play_age').text('Age :'+data.age);
    	$('.play_playerCode').text('Player Code :'+data.playerCode);
    });
}


