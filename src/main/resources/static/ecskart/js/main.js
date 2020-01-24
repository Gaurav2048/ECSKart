	/*price range*/

 $('#sl2').slider();

	var RGBChange = function() {
	  $('#RGB').css('background', 'rgb('+r.getValue()+','+g.getValue()+','+b.getValue()+')')
	};	
		
/*scroll to top*/

$(document).ready(function(){
	$(function () {
		$.scrollUp({
	        scrollName: 'scrollUp', // Element ID
	        scrollDistance: 300, // Distance from top/bottom before showing element (px)
	        scrollFrom: 'top', // 'top' or 'bottom'
	        scrollSpeed: 300, // Speed back to top (ms)
	        easingType: 'linear', // Scroll to top easing (see http://easings.net/)
	        animation: 'fade', // Fade, slide, none
	        animationSpeed: 200, // Animation in speed (ms)
	        scrollTrigger: false, // Set a custom triggering element. Can be an HTML string or jQuery object
					//scrollTarget: false, // Set a custom target element for scrolling to the top
	        scrollText: '<i class="fa fa-angle-up"></i>', // Text for element, can contain HTML
	        scrollTitle: false, // Set a custom <a> title if required.
	        scrollImg: false, // Set true to use image
	        activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
	        zIndex: 2147483647 // Z-Index for the overlay
		});
	});
});


var element = document.getElementById("files"); 
if(element !==null)
{
	element.onchange = function () {
	console.log("Here")
    var reader = new FileReader();

    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("imageDisplay").src = e.target.result;
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
};
}

function plus(id, price){
	console.log("qty_"+id, price); 
	var input = document.getElementById("qty_"+id); 
	var amount = document.getElementById("amount_"+id); 
	input.value = parseInt(input.value)+1; 
	console.log(amount.innerHTML); 
	amount.innerHTML = "$ "+parseInt(input.value*price)
}

function minus(id, price){
	console.log("qty_"+id); 
	var input = document.getElementById("qty_"+id);
	if(input.value !=="0")
	{
		input.value = parseInt(input.value)-1; 	
	}
}

function viewProduct(){
	console.log('okay')
}

function removeRow(val){
    var position = val.parentNode.parentNode.rowIndex;
	var cart = getCookie("cart_info")
	if(cart.length === 0 ){
		cart = []; 
		console.log(cart+" sdfsdf")		
	}else {
		cart = JSON.parse(cart); 
	}
	
	    cart.splice(position, 1);
	
	document.cookie="cart_info ="+ JSON.stringify(cart)
	console.log(position)
	document.getElementById("item_table").deleteRow(position);
	
}

var cart = getCookie("cart_info")
if(cart.length === 0 ){
	cart = []; 
	console.log(cart+" sdfsdf")		
}else {
	cart = JSON.parse(cart); 
}
document.getElementById("cart_count").innerHTML=cart.length

function updatecookie(val){	
	
	console.log(val.split(',')[0])
	var val = val.split(','); 
	
	var cart = getCookie("cart_info")
	if(cart.length === 0 ){
		cart = []; 
		console.log(cart+" sdfsdf")		
	}else {
		cart = JSON.parse(cart); 
	}
	
	var item = cart.filter(function(c){
		if(c.id===val[0]){
			c.quantity=c.quantity+1; 
			c.price =c.rate*c.quantity; 
			return c; 
		}
	})
	console.log(item)		
	if(item.length===0 || cart.length ===0){
		cart.push({
			id:val[0], 
			name:val[1], 
			rate: parseInt(val[2]), 
			price:parseInt(val[2]), 
			quantity:1,
			image:val[3]		
		});		
	}

	console.log(JSON.stringify(cart))		
	document.cookie="cart_info ="+ JSON.stringify(cart)
	document.getElementById("cart_count").innerHTML=cart.length
}

function openCartPage(){
	 var parameter1 = getCookie("cart_information"); // some thing like this you can set value for 1st Param.
	 window.location.href="/ecscart/cart/"+parameter1;  
}

$("#cart_btn").click(function(){
	
	 var parameter1 = getCookie("cart_info");
	 console.log(parameter1)
    $.redirect("/ecskart/cart", {
    	busket:JSON.stringify(parameter1)
    });
    });



function getCookie(cname) {
	  var name = cname + "=";
	  var ca = document.cookie.split(';');
	  for(var i = 0; i < ca.length; i++) {
	    var c = ca[i];
	    while (c.charAt(0) == ' ') {
	      c = c.substring(1);
	    }
	    if (c.indexOf(name) == 0) {
	      return c.substring(name.length, c.length);
	    }
	  }
	  return "";
	}


function getval(sel)
{
	$.ajax({url: "/ecskart/subcat/"+sel.value, success: function(result){
  		  var x = document.getElementById("sub_category_select");
  		  $('#sub_category_select').empty(); 
  		  var option = document.createElement("option");
  		  option.text = "SELECT SUBCATEGORY";
  		  option.value = ""; 
  		  x.add(option); 

  		  
  		  result.map((sub_cat, index)=>{
			var option = document.createElement("option");
			option.text = sub_cat.sub_cat_name;
			option.value = sub_cat.sub_cat_id; 
			return  x.add(option); 
  		  })
	  }});
}

function getFloorCategories(sel){
	$.ajax({url: "/ecskart/floorcat/"+sel.value, success: function(result){
		  var x = document.getElementById("floor_category_select");
		  $('#floor_category_select').empty(); 
		  var option = document.createElement("option");
		  option.text = "SELECT SUBCATEGORY";
		  option.value = ""; 
		  x.add(option); 

		  
		  result.map((sub_cat, index)=>{
			var option = document.createElement("option");
			option.text = sub_cat.floor_category_name;
			option.value = sub_cat.id; 
			return  x.add(option); 
		  })
	  }});
}


function validateForm() {
	
		var product_name = document.getElementById('product_name'); 
		
		if(product_name.value.trim().length ===0){
			alert('product name is empty'); 
			return false; 
		}
		
		var description = document.getElementById('description'); 
		if(description.value.trim().length===0){
			alert('description is empty')
			return false; 
		}
		
		var price = document.getElementById('price'); 
		if(price.value<=0){
			alert('Invalid price.')
			return false; 
		}

		var category = document.getElementById('category'); 
		if(category.value===""){
			alert('Select a valid category')
			return false; 
		}
		
		var sub_category_select = document.getElementById('sub_category_select'); 
		if(sub_category_select.value===""){
			alert('Select a valid sub category')
			return false; 
		}
		
		var floor_category_select = document.getElementById('floor_category_select'); 
		if(floor_category_select.value===""){
			alert('Select a valid Inner category')
			return false; 
		}
		
		var  media = document.getElementById('files'); 
		console.log(media.files[0].name)
		
	    return true;
	  
	} 

	function onLoginSubmit(){
		console.log('called')
		var email = document.getElementById('email'); 
		if(email.value===""){
			alert('email id is not filled'); 
			return false; 
		}
		
		var password = document.getElementById('password'); 
		if(password.value===""){
			alert('Password is not filled'); 
			return false; 
		}
		
		var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		var data =  emailPattern.test(email.value);
		if(data ===false	)
		{
			alert('Email address is not valid')
			return false; 
		}
		
		return true; 
	}





