import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { fooditem } from 'src/app/fooditem';
import { FoodService } from '../food.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';



@Component({
  selector: 'app-item-info',
  templateUrl: './item-info.component.html',
  styleUrls: ['./item-info.component.css']
})
export class ItemInfoComponent {

@Input() fooditem1:fooditem;

@Output() addToCartClicked:EventEmitter<number> =new EventEmitter<number>();


  isAdmin:boolean;
   cartAddedId:number;
   addedToCart:boolean;


  constructor(private _foodService: FoodService,private authservice:AuthServiceService){}
ngOnInit()
{

  
this.isAdmin=this.authservice.isAdmin;





}



displayAddToCart(id:number) {
  this.cartAddedId = id;
  console.log(this.cartAddedId)
}

onAddToCart(itemId:number)
{
  console.log("From Clickedf");
  this.addToCartClicked.emit(itemId);
}

}
