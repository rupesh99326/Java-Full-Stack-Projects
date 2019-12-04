import { Component, OnInit} from '@angular/core';

import {  favorites } from './favorites';
import {  MovieService } from 'src/app/food/movie.service';
import { FavoritesService } from '../favorites.service';

@Component({
  selector: 'app-shopping-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {



  favorites:favorites;

stat:boolean;
empty:boolean;

  constructor(private favoritesservice:FavoritesService,private _movieservice:MovieService) { }

  ngOnInit() {


this.favoritesservice.getAllFavorites();

  //  this.favoritesservice.favorites1.total=this.favoritesservice.favorites1.movie.length;
   
    

    this.empty=this.favoritesservice.favoritesempty;
  }



removeFromFavorites(favoritesId)
{

  this._movieservice.deleteFavoritesItem(favoritesId).subscribe(data=>{this.favoritesservice.getAllFavorites();})


  //added here 

this.empty=this.favoritesservice.favoritesempty;
this.stat=this.favoritesservice.favoritesstatus;

console.log(this.stat)
}


}
