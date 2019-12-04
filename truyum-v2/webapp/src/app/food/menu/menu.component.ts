import { Component, OnInit, Input, EventEmitter } from '@angular/core';

import { fooditem } from 'src/app/fooditem';
import { FoodService } from '../food.service';
import { CartService } from 'src/app/shopping/cart.service';
import { MenuItemService } from 'src/app/services/menu-item.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


 @Input() 

 addedToCart:boolean;

  fooditem:fooditem[];

   addToCartClicked =new EventEmitter();

   isAdmin:boolean;
   constructor(private _foodService: FoodService,private cartservice:CartService,private Menuitemservice:MenuItemService,private authservice:AuthServiceService){}
  
  ngOnInit()
  {
      this._foodService.getAllMenuItems().subscribe(fooditem =>this.fooditem=fooditem);

      this._foodService.getSubject().subscribe((data) =>(this.fooditem=this._foodService.getItem(data)));

      this.authservice.addedToCart=false;
      
  }

}