import { Component, OnInit} from '@angular/core';
import { CartService } from '../cart.service';
import { cart } from './cartitem';
import { FoodService } from 'src/app/food/food.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {



  cart:cart;

stat:boolean;
empty:boolean;
addedToCart:boolean;
  constructor(private cartservice:CartService,private _foodservice:FoodService,private authservice:AuthServiceService) { }

  ngOnInit() {

  
    this.cartservice.getAllCart();
    
    
   //this.addedToCart=this.authservice.addedToCart;
    this.empty=this.cartservice.cartempty;
  }



removeFromCart(cartId)
{

  this._foodservice.deleteCartItem(cartId).subscribe(data=>{this.cartservice.getAllCart();})


  

this.empty=this.cartservice.cartempty;
this.stat=this.cartservice.cartstatus;

console.log(this.stat)

}


}
