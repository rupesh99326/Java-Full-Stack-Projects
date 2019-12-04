import { Component, OnInit, Input, EventEmitter } from '@angular/core';


import {  MovieService } from '../movie.service';

import { movie } from 'src/app/movie';
import { AuthServiceService } from 'src/app/site/auth-service.service';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


 @Input() 
  movie:movie[];

   addToFavoritesClicked =new EventEmitter();

   isAdmin:boolean;
   constructor(private _movieService: MovieService,private authservice:AuthServiceService){}
  
   addedToFav:boolean;

   
  ngOnInit()
  {
   
   
 
    this._movieService.getAllMovies().subscribe(data =>this.movie=data);

    this._movieService.getSubject().subscribe((data) =>(this.movie=this._movieService.getItem(data)));



this.authservice.addedToFav=false;


    }
    

}