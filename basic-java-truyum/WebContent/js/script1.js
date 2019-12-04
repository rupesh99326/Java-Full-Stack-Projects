function validateMenuItemForm()
{
	//document.write("Hello");
	 var name=document.menuItemForm.name.value;
     var price=document.menuItemForm.price.value;
     var special = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;;
     var num=/[1234567890]+/;
     var date=document.menuItemForm.date.value;
     var date1=/[1234567890/]+/;
     var select1=document.menuItemForm.select.value;
     if(name==null||name=="")
         {
             alert("Please Enter something instead of nothing");
             return false;
         }
         else if(name.length>65 ||name.length<2 )
          {
             alert("Name should be between 2 & 65");
             return false;
         }
         else if(special.test(name))
         {
             alert("It cant contain special chara");
             return false;
         }
         else if(isNaN(price))
         {
             alert("price should contain numbers");
             return false;
         }
         
     else if(price==null||price=="")
         {
             alert('price should not be blank');        
             return false;

         }
    
     
     else if(date==null||date=="")
     {
         alert("date cant be empty");
         return false;
     }
     else if(isNaN(price))
     {
    	 
         alert("It should contain numbers");
         return false;
     }
  
     else if(select1==null||select1=="")
     {
         alert("Please select atleast one Category");
         return false;
     }
 }/**
 * 
 */