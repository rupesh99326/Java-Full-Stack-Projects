import { Component, OnInit } from '@angular/core';
import { fooditem } from 'src/app/fooditem';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from '../food.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscriber } from 'rxjs';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit {

foodItem:fooditem={id:1,name:"",price:99.00,active:true,date_of_Launch:new Date('03/15/2017'),category:"Main Course",free_delivery:true,image:"https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1353&q=80"};

form:FormGroup;
bool:boolean=false;

categories=["Main Course","Starters","Dessert","Drinks"];

  constructor(private fb:FormBuilder,private foodService:FoodService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit() {
    this.bool=true;
    const id1=this.route.snapshot.paramMap.get('id');
   this.foodService.getMenuITem(+id1).subscribe(data=>{this.foodItem=data
    
    this.foodItem.date_of_Launch=new Date(this.foodItem.date_of_Launch)
this.foodItem.date_of_Launch.setDate(this.foodItem.date_of_Launch.getDate()+1);


this.form=this.fb.group({


  title:[this.foodItem.name,[Validators.required,Validators.maxLength(200)]],
  photoURL:[this.foodItem.image,[Validators.required]],
  price:[this.foodItem.price,[Validators.required]],
  Date_of_Launch:[this.foodItem.date_of_Launch.toISOString().substring(0,10),[Validators.required]],
  category:[this.foodItem.category,[Validators.required]],
  active:[this.foodItem.active,[Validators.required]],
  free_delivery:[this.foodItem.free_delivery,[Validators.required]]
})
}
    
    );

//  const foodItemId=this.route.snapshot.paramMap.get('id');
//  this.foodItem=this.foodService.getFoodItem(+foodItemId);
 
  }

get title()
{  return this.form.get('title');}

get photoURL()
{  return this.form.get('photoURL');}

get price()
{  return this.form.get('price');}


get Date_of_Launch()
{  return this.form.get('Date_of_Launch');}

get category()
{  return this.form.get('category');}

get active()
{  return this.form.get('active');}

get free_delivery(){
  return this.form.get('free_delivery');
}


OnSubmit()
{

  let newItem:fooditem=
  {id:this.foodItem.id,
    name:this.form.value["title"],
    price:this.form.value["price"],
    date_of_Launch:new Date(this.form.value["Date_of_Launch"]),
    category:this.form.value["category"],
    active:this.form.value["active"],
    free_delivery:this.form.value["free_delivery"],
    image:this.form.value["photoURL"]};


console.log(newItem)
  //this.foodService.updateFoodItem(newItem);

  this.foodService.updateMenuItem(newItem,+this.foodItem.id).subscribe(data=>{
    this.router.navigate(['search-bar'])
  })
  


  
}




}
