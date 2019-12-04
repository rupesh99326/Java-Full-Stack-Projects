import { Component, OnInit } from '@angular/core';

import {  MovieService } from '../movie.service';
import { movie } from 'src/app/movie';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private _foodservice:MovieService) { }
  filterlist:movie[];

  //mov:movie[];
  ngOnInit() {
 
    this._foodservice.getAllMovies().subscribe(data => this._foodservice.movie=data)
  console.log("updating")
  }
  search(event:any)
  {


this._foodservice.getSubject().next(event.target.value)
    
  }
  
  }


