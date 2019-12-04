
 (function() {
	 'use strict';
	 window.addEventListener('load', function() {
	 var forms = document.getElementsByClassName('needs-validation');
	 var validation = Array.prototype.filter.call(forms, function(form) {
	 form.addEventListener('submit', function(event) {
		 var name=document.menuItemForm.iname.value;
         var price=document.menuItemForm.price.value;
         var active=document.menuItemForm.active.value;
         var select=document.menuItemForm.dep.value;
         var date=document.menuItemForm.dateOfLaunch.value;
         document.getElementById("name_valid").innerHTML=null;
         document.getElementById("price_valid").innerHTML=null;
         document.getElementById("depart_valid").innerHTML=null;
         document.getElementById("date_valid").innerHTML=null;
         document.getElementById("active_valid").innerHTML=null;
         var flag=0;
         var format=/^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$/;
         if(name==null||name=="")
         {
          document.getElementById("name_valid").innerHTML="Item name is required";
             flag=1;
         }
     
      if(name.length>200)
     {
    	 document.getElementById("name_valid").innerHTML="Item Name cannot exceed 200 characters";
         flag=1;
     }
      if(price==null||price=="")
         {
    	 document.getElementById("price_valid").innerHTML="Price is required";        
             flag=1;
         

         }
      if(isNaN(price)){
    	 document.getElementById("price_valid").innerHTML="Price has to be number";
     	flag=1;
     }
      if(select==null||select=="")
    	 {
    	 document.getElementById("depart_valid").innerHTML="Select one category";
      	flag=1;
    	 }
      if(!format.test(date))
    	 {
    	 document.getElementById("date_valid").innerHTML="Incorrect date format";
       	flag=1;
    	 }
      if(active==null||active=="")
    	 {
    	 document.getElementById("active_valid").innerHTML="Select in stock status";
       	flag=1;
    	 }
         
         
		 
	 if (flag == 1) {
	 event.preventDefault();
	 event.stopPropagation();
	 }
	 
	 }, false);
	 });
	 }, false);
	 })();