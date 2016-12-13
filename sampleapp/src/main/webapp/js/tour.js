var SERVICE_URL = "http://localhost:8080/sampleapp/rest";
var FORWARD_SLASH = "/";

	function getCombos(){
		
		var geturl = SERVICE_URL+"/tour/category/getAll";
		
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

		geturl = SERVICE_URL+"/tour/getAll";
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
	var date = $("#tday").val();
	
	///create/{tourName}/{org}/{venue}/{date}
	var geturl = SERVICE_URL+"/tour/create/"+name+FORWARD_SLASH+orgName+FORWARD_SLASH+venue+FORWARD_SLASH+date;
	
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
	var geturl = SERVICE_URL+"/player/get/"+id;
	
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


function createEvents(){
	var eventName = $('#eventName').val();
	var gender = $('input[name=gender]:checked').val();
	var matchType = $('input[name=match_type]:checked').val();
	var eventDate = $('#eday').val();
	var venue = $('#venue').val();
	
	//alert("gender: "+gender+" match: "+matchType+" eventDate: "+eventDate+" venue: "+venue);
	

//	/event/create/{name}/{matchType}/{gender}/{venue}/{date}
var geturl = SERVICE_URL+"/event/create/"+eventName+FORWARD_SLASH+matchType+FORWARD_SLASH+gender+FORWARD_SLASH+venue+FORWARD_SLASH+eventDate;
	
	$.ajax({
	    type: "GET",
	    url: geturl,
	    success: function(data, status, xhr) {
	     	alert(data.eventId);
	     	$('#create_msg').text("Event Created succesfully");
	    },
	    error: function(xhr, status, error) {
	        console.log(xhr+":"+status+":"+error);
	        $("#error_event").text("Duplicate Event Name");
	    }
	});
}
