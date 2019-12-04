import { Injectable } from '@angular/core';

import { Observable, of, Subject } from 'rxjs';
import {  FavoritesService } from '../Booking/favorites.service';
import { Router } from '@angular/router';
import { movie } from '../movie';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@Angular/common/http';
import { AuthServiceService } from '../site/auth-service.service';
@Injectable({
  providedIn: 'root'
})
export class MovieService {
 
  
 
 
  filterlist:movie[];

  subject=new Subject<string>();
  
  isAdmin:boolean = false;
  addedToFav:boolean = false;
  favAddedId:number;
  isLoggedIn:boolean = false;
  clickedOnAdd:boolean = false;


movie:movie[];


  constructor(private router:Router,private httpClient:HttpClient,private authservice:AuthServiceService) {


    this.getAllMovies().subscribe(data=>this.movie=data)
   }
getMenu(): Observable<movie[]>
{
return of (this.movie);
}
getCustomerItems():Observable<movie[]>
{
return of (this.movie.filter(fd_item => fd_item.active && fd_item.date_of_Launch <= new Date()));

}



//All Data From SPRING


getAllMovies():Observable<any>{

  if(this.authservice.loggedIn){
  this.isLoggedIn=true;
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });

  
    return this.httpClient.get<movie[]>(`${environment.baseUrl}`+'movie-service/movies',{headers})
  }
    else return this.httpClient.get<movie[]>(`${environment.baseUrl}`+'movie-service/movies');
  
}

getMovies(id:number):Observable<any>
{
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.get<movie>(`${environment.baseUrl}`+'movie-service/movies'+"/"+id,{headers});
}


updateMovie(mov:movie,id:number): Observable<void> {
  console.log("update movie")
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.put<void>(`${environment.baseUrl}`+'movie-service/movies'+"/"+id,mov,{headers});

}
//=============

// Getting FAVORITES from SPRING



addFavoritesItem(movieItemId:number):Observable<any>
{
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.post<movie[]>(`${environment.baseUrl}`+'movie-service/favorites/'+this.authservice.loggedInUser+"/"+movieItemId,null,{headers});
}

getAllFavoritesItems():Observable<any>
{
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.get<movie[]>(`${environment.baseUrl}`+'movie-service/favorites/'+this.authservice.loggedInUser,{headers});
}

deleteFavoritesItem(movieItemId:number):Observable<any>
{
  const headers = new HttpHeaders({ Authorization: 'Bearer ' + this.authservice.accessToken });
  return this.httpClient.delete<movie[]>(`${environment.baseUrl}`+'movie-service/favorites'+"/"+this.authservice.loggedInUser+"/"+movieItemId,{headers});
}


//=====================

getItem(name:string):movie[]
{
  if(name!="")
  {
this.filterlist=this.movie.filter(item =>
   {return item.title.toLowerCase().includes(name.toLowerCase());
})}
else{
  this.filterlist=this.movie
}
  return this.filterlist
}
 


  getSubject():Subject<string>
  {

return  this.subject

  }


  addToFavorites(movieItemId:number,itemCount:number)
{


  if(this.authservice.loggedIn){

    this.addFavoritesItem(movieItemId).subscribe(data=>{this.authservice.addedToFav=true;
    this.favAddedId=movieItemId;
    })
    
    
    }
    
    




else{
  this.clickedOnAdd = true;
  this.router.navigate(['login'])
}
}


updateMovieItem(Movie:movie)
{

for(let i=0;i<this.movie.length;i++)
{

  if(this.movie[i].id==Movie.id)
  {

    this.movie[i]=Movie;
   
   // this.favoritesservice.favorites1.total=this.favoritesservice.favorites1.movie.length;
  }
}
  
}
getMovieItem(MovieId:number):movie
{

  for(let item of this.movie)
  {
if(item.id==MovieId)
return item;

  }
}


}
