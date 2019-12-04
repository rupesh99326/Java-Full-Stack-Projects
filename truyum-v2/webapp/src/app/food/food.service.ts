import { Injectable } from '@angular/core';
import { fooditem } from '../fooditem';
import { Observable, of, Subject } from 'rxjs';

import { Router } from '@angular/router';
import { MenuItemService } from '../services/menu-item.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthServiceService } from '../site/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
 
  
  fooditem:fooditem[];
 
  filterlist:fooditem[];

  subject=new Subject<string>();
  
  isAdmin:boolean = false;
  addedToCart:boolean = false;
  cartAddedId:number;
  isLoggedIn:boolean = false;
 
 
  clickedOnAdd:boolean = false;

  constructor(private router:Router,private httpClient:HttpClient,private authservice:AuthServiceService) { 

  
  this.getAllMenuItems().subscribe(data=>this.fooditem=data)



  console.log("inside food service")

  }


getAllMenuItems():Observable<any>{

if(this.authservice.loggedIn){
this.isLoggedIn=true;
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.get<fooditem[]>(`${environment.baseUrl}`+'menu-service/menu-items',{headers})}
  else return this.httpClient.get<fooditem[]>(`${environment.baseUrl}`+'menu-service/menu-items')
}



getMenuITem(id:number):Observable<any>
{
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.get<fooditem>(`${environment.baseUrl}`+'menu-service/menu-items'+"/"+id,{headers});
}


updateMenuItem(fooditen:fooditem,id:number): Observable<void> {
  console.log("update menu")
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.put<void>(`${environment.baseUrl}`+'menu-service/menu-items'+"/"+id,fooditen,{headers});

}

// Getting CART from SPRING



addCartItem(menuItemId:number):Observable<any>
{
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.post<fooditem[]>(`${environment.baseUrl}`+'menu-service/carts/'+this.authservice.loggedInUser+"/"+menuItemId,null,{headers});
}

getAllCartItems():Observable<any>
{
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.get<fooditem[]>(`${environment.baseUrl}`+'menu-service/carts/'+this.authservice.loggedInUser,{headers});
}

deleteCartItem(menuItemId:number):Observable<any>
{
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.delete<fooditem[]>(`${environment.baseUrl}`+'menu-service/carts'+"/"+this.authservice.loggedInUser+"/"+menuItemId,{headers});
}


getMenu(): Observable<fooditem[]>
{
return of (this.fooditem);

}
getCustomerItems():Observable<fooditem[]>
{
return of (this.fooditem.filter(fd_item => fd_item.active && new Date(fd_item.date_of_Launch) <= new Date()));
}

getItem(name:string):fooditem[]
{
  console.log("get item")
  if(name!="")
  {
this.filterlist=this.fooditem.filter(item =>
   {return item.name.toLowerCase().includes(name.toLowerCase());
})}
else{
  this.filterlist=this.fooditem
}
  return this.filterlist
}
 


  getSubject():Subject<string>
  {

return  this.subject

  }


  addToCart(foodItemId:number,itemCount:number)
{

  if(this.authservice.loggedIn){

this.addCartItem(foodItemId).subscribe(data=>{this.authservice.addedToCart=true;
this.cartAddedId=foodItemId;
})


}




else{
  this.clickedOnAdd = true;
  this.router.navigate(['login'])
}
}


updateFoodItem(FoodItem:fooditem)
{

for(let i=0;i<this.fooditem.length;i++)
{

  if(this.fooditem[i].id==FoodItem.id)
  {

    this.fooditem[i]=FoodItem;

  }
}
  
}
getFoodItem(foodItemId:number):fooditem
{

  for(let item of this.fooditem)
  {
if(item.id==foodItemId)
return item;

  }
}


}
