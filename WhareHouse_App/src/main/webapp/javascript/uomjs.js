
function myload(){
	console.log('hello');
}

function checkUomType(){

    var ErrorElement= document.getElementById('uomTypeError');

    ErrorElement.innerText=" ";
    var uomType=document.getElementById('uomType').value;
    console.log(uomType);
    if(uomType===" "){
        ErrorElement.innerText=`choose anyone option`;
        return false;
    }
    return true;
   
}


function checkUomModel(){

    var ErrorElement= document.getElementById('uomModelError');

    ErrorElement.innerText=" ";
    var uomModel=document.getElementById('uomModel').value;
    console.log(uomModel);
    if(uomModel.length===0){
        ErrorElement.innerText=`Uom Model Cannot be Blank`;
        return false;
    }

    var uomModelPattern=/[A-Z]/;

    if(!uomModelPattern.test(uomModel)){
        ErrorElement.innerText="Should Start with Caps Letters";
         return false;
    }

    else if(uomModel.length<4 || uomModel.length>10){
        ErrorElement.innerText="Must be in Range of 4-10 Characters only";
         return false;
    }
    return true;
}


function checkUomDescription(){

    var ErrorElement= document.getElementById('descriptionError');

    ErrorElement.innerText=" ";
    var description=document.getElementById('description').value;
    console.log(description.length);
    if(description.length<=13){
        ErrorElement.innerText=`Description should not be Blank`;
        return false;
    }

    else if(description.length<20 || description.length>40){
        ErrorElement.innerText="Must be in Range of 20-40 Characters only";
    }
    
    return true;
}


function wholeFormValidate(frm){
	
	var wholeValidatemsgerror=document.getElementById('wholeValidateMsgError');
	wholeValidatemsgerror.innerText=" ";
	if(checkUomType() && checkUomModel() && checkUomDescription()){
		return true;
	}
	else{
		wholeValidatemsgerror.innerText="Please fill All Fields";
		return false;
		
	}
		
	
}