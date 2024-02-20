
    var shipmentMode;
	   
   function CheckShipmentMode() {

	   var ErrorElement=document.getElementById('shipmentModeError');
	   ErrorElement.innerText=" ";
	   

    shipmentMode= document.getElementById('shipmentMode').value;
	   
	   console.log(shipmentMode);
	
	   if(shipmentMode===" "){
		   ErrorElement.innerText="cannot be empty";
		   return false;
	   }
	  
		return true;
	
}



function CheckShipmentCode() {

	var ErrorElement=document.getElementById('shipmentCodeError');

	ErrorElement.innerText=" ";

	
	
	var shipmentcode=document.getElementById('shipmentCode').value;
	console.log(shipmentcode);
 
	if(shipmentcode.length===0){
		ErrorElement.innerText="cannot be empty";
		return false;
	}

	var shipmentCodePattern=/[A-Z]/;

	if(!shipmentCodePattern.test(shipmentcode)){
		ErrorElement.innerText="Should start with Caps";
			return false;

	}

	else if(shipmentcode.length<4 || shipmentcode.length>10){
		ErrorElement.innerText="ShipmentCode Should be in range of 4-10 Chars only";
			return false;

	}
		return true;
}



function CheckShipmentGrade() {

	var ErrorElement=document.getElementById('shipmentGradeError');

	ErrorElement.innerText=" ";

	
	
	var shipmentGrade1=document.getElementById('shipmentGrade1').value;
	console.log(shipmentGrade1);
 
	
	var shipmentGrade2=document.getElementById('shipmentGrade2').checked;
	console.log(shipmentGrade2);

	
	var shipmentGrade3=document.getElementById('shipmentGrade3').checked;
	console.log(shipmentGrade3);
	}


var ErrorElement
function CheckDescription() {

	 ErrorElement=document.getElementById('descriptionError');
	 ErrorElement.innerText=' ';

	

	var description=document.getElementById('description').value;

	console.log(description.length);
	if(description.length<=13){
		
		ErrorElement.innerText='Cannot be Empty';
		return false;
	}
	return true;
	
	
	
	
}

function validateWholeForm(frm){
	
	/*  
  shipmentMode= document.getElementById('shipmentMode').value;
  var wholeMsg=document.getElementById('wholeMsg');
  wholeMsg.innerText=" ";
	if(shipmentMode===" "){
		wholeMsg.innerText="Pleae fill All Fields ";
	}
	return false;*/
	if(CheckShipmentCode() && CheckShipmentMode() && CheckDescription()){
		  
		return true;
	}
	else{
		var wholeMsg=document.getElementById('wholeMsg');
  wholeMsg.innerText=" ";
  wholeMsg.innerText="Pleae fill All Fields ";
  return false;
  
	}
	
	
	
	
}

	



