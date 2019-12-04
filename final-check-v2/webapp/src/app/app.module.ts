import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemInfoComponent } from './food/item-info/item-info.component';
import {  MovieService } from './food/movie.service';
import { MenuComponent } from './food/menu/menu.component';
import { SearchComponent } from './food/search/search.component';
import { FavoritesComponent } from './Booking/favorites/favorites.component';
import { ItemEditComponent } from './food/item-edit/item-edit.component';

import { FormsModule, ReactiveFormsModule}   from '@angular/forms';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { Routes } from '@angular/router';
import { HttpClientModule } from '@Angular/common/http';




const appRoutes: Routes = [ 
  
];

@NgModule({
  declarations: [
    AppComponent,
   
    ItemInfoComponent,
   
    MenuComponent,
   
    SearchComponent,
   
    FavoritesComponent,
   
    ItemEditComponent,
   
    SignupComponent,
   
    LoginComponent,
   
 
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  

    FormsModule,ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [MovieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
