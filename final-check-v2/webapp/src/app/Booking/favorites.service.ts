import { Injectable, Output, EventEmitter } from '@angular/core';
import {favorites } from './favorites/favorites';
import { MovieService } from '../food/movie.service';





@Injectable({
  providedIn: 'root'
})
export class FavoritesService {


  @Output() cartUpdated = new EventEmitter();

favoritesempty:boolean=true;
favoritesstatus:boolean;
  
  favorites1:favorites={movieList:[],total:0};
  
constructor(private movieservice:MovieService) { }

getAllFavorites()
{
  this.movieservice.getAllFavoritesItems().subscribe(data=>{


    this.favorites1=data;
    if(this.favorites1.movieList.length==0)
    {
      this.favoritesempty=true;
      this.favoritesstatus=true;
    }
    else{
    
      this.favoritesempty=false;
      this.favoritesstatus=false;
    }
    })
        

}

getTotal()
{
this.favorites1.total=0;
for(let i=0;i<this.favorites1.movieList.length;i++)
{


  this.favorites1.total += this.favorites1.movieList[i].box_office;
}
  this.cartUpdated.emit;
}


clearFavorites()
{

this.favorites1={movieList:[],total:0};
this.favoritesempty=true;



}


}
