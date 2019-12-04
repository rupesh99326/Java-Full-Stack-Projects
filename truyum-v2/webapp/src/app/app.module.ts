import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemInfoComponent } from './food/item-info/item-info.component';
import { FoodService } from './food/food.service';
import { MenuComponent } from './food/menu/menu.component';
import { SearchComponent } from './food/search/search.component';
import { CartComponent } from './shopping/cart/cart.component';
import { ItemEditComponent } from './food/item-edit/item-edit.component';

import { FormsModule, ReactiveFormsModule}   from '@angular/forms';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { Routes } from '@angular/router';
import { AuthGuardServiceService } from './auth-guard-service.service';
import { HttpClientModule } from '@angular/common/http';



const appRoutes: Routes = [ 
  
];

@NgModule({
  declarations: [
    AppComponent,
   
    ItemInfoComponent,
   
    MenuComponent,
   
    SearchComponent,
   
    CartComponent,
   
    ItemEditComponent,
   
    SignupComponent,
   
    LoginComponent,
   
 
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // RouterModule.forRoot(
    //   appRoutes,
    //   { enableTracing: true }
    // ),

    FormsModule,ReactiveFormsModule,HttpClientModule
  ],
  providers: [FoodService],
  bootstrap: [AppComponent]
})
export class AppModule { }
