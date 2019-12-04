import { Component,  Input, Output, EventEmitter } from '@angular/core';

import {  MovieService } from '../movie.service';
import { movie } from 'src/app/movie';
import { AuthServiceService } from 'src/app/site/auth-service.service';



@Component({
  selector: 'app-item-info',
  templateUrl: './item-info.component.html',
  styleUrls: ['./item-info.component.css']
})
export class ItemInfoComponent {

@Input() movieitem1:movie;

@Output() addToFavoritesClicked:EventEmitter<number> =new EventEmitter<number>();


  isAdmin:boolean;
  favAddedId:number;
  constructor(private _movieService: MovieService,private authservice:AuthServiceService){}
ngOnInit()
{

  
this.isAdmin=this.authservice.isAdmin;





}



displayAddToCart(id:number) {
  this.favAddedId = id;
  console.log(this.favAddedId)
}

onAddToFavorites(itemId:number)
{

  this.addToFavoritesClicked.emit(itemId);
}

}
