import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import {  MovieService } from '../movie.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { movie } from 'src/app/movie';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit {

movie:movie={id:1,title:"",box_office:2787965087,active:true,date_of_Launch:new Date('03/15/2017'),genre:"Science Fiction",has_teaser:true,image:"https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Avatar-Teaser-Poster.jpg/220px-Avatar-Teaser-Poster.jpg"};

form:FormGroup;


categories=["Science Fiction","Superhero","Romance"];

  constructor(private fb:FormBuilder,private movieService:MovieService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit() {


 const movieId=this.route.snapshot.paramMap.get('id');



this.movieService.getMovies(+movieId).subscribe(data=>{this.movie=data

 //this.movie=this.movieService.getMovieItem(+movieId);
this.movie.date_of_Launch=new Date(this.movie.date_of_Launch);

this.movie.date_of_Launch.setDate(this.movie.date_of_Launch.getDate()+1);
this.form=this.fb.group({


  title:[this.movie.title,[Validators.required,Validators.maxLength(200)]],
  photoURL:[this.movie.image,[Validators.required]],
  box_office:[this.movie.box_office,[Validators.required]],
  Date_of_Launch:[this.movie.date_of_Launch.toISOString().substring(0,10),[Validators.required]],
  genre:[this.movie.genre,[Validators.required]],
  active:[this.movie.active,[Validators.required]],
  has_teaser:[this.movie.has_teaser,[Validators.required]]
})});
  }

get title()
{  return this.form.get('title');}

get photoURL()
{  return this.form.get('photoURL');}

get box_office()
{  return this.form.get('box_office');}


get Date_of_Launch()
{  return this.form.get('Date_of_Launch');}

get genre()
{  return this.form.get('genre');}

get active()
{  return this.form.get('active');}

get has_teaser(){
  return this.form.get('has_teaser');
}


OnSubmit()
{

  let newItem:movie=
  {id:this.movie.id,
    title:this.form.value["title"],
    box_office:this.form.value["box_office"],
    date_of_Launch:new Date(this.form.value["Date_of_Launch"]),
    genre:this.form.value["genre"],
    active:this.form.value["active"],
    has_teaser:this.form.value["has_teaser"],
    image:this.form.value["photoURL"]};

console.log(newItem)
  //this.movieService.updateMovieItem(newItem);

  this.movieService.updateMovie(newItem,+this.movie.id).subscribe(data=>{ 
     this.router.navigate(['search-bar'])})



  
}




}
