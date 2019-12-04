import { Injectable, Output, EventEmitter } from '@angular/core';
import { cart } from './cart/cartitem';
import { FoodService } from '../food/food.service';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthServiceService } from '../site/auth-service.service';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';





@Injectable({
  providedIn: 'root'
})
export class CartService {


  @Output() cartUpdated = new EventEmitter();

cartempty:boolean=true;
cartstatus:boolean;
  
  cart1:cart={menuItemList:[],total:0};
  
constructor(private httpClient:HttpClient,private foodservice:FoodService) {
console.log("inside cart service")
  //added now
//this.foodservice.getAllCartItems().subscribe(data=>this.cart1=data);
}

 getAllCart()
 {

this.foodservice.getAllCartItems().subscribe(data=>{


this.cart1=data;
if(this.cart1.total==0)
{
  this.cartempty=true;
  this.cartstatus=true;
}
else{

  this.cartempty=false;
  this.cartstatus=false;
}
})
    
  }

getTotal()
{
this.cart1.total=0;
for(let i=0;i<this.cart1.menuItemList.length;i++)
{


  this.cart1.total += this.cart1.menuItemList[i].price;
}
  this.cartUpdated.emit;
}


clearCart()
{

this.cart1={menuItemList:[],total:0};
this.cartempty=true;

this.cartstatus=true;

}


}
