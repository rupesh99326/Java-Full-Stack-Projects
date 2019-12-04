function jspfunction()
{
	 var name=document.myform.uname.value;
     var price=document.myform.price.value;
     var special = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;;
     var num=/[1234567890]+/;
     var date=document.myform.date.value;
     var date1=/[1234567890/]+/;
     var opt=document.myform.o.value;
     if(name==null||name=="")
         {
             alert("Please Enter something instead of nothing");
             return false;
         }
         else if(name.length>100 ||name.length<2 )
          {
             alert("Name should be between 2 & 100");
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
     else if(opt==null||opt=="")
     {
         alert("Choose atleast One GENRE");
         return false;
     }
  
     
 }