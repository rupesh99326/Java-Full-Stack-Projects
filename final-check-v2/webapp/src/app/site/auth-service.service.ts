import { Injectable } from '@angular/core';
import { UserServiceService } from './user-service.service';
import { Router } from '@angular/router';
import {  MovieService } from '../food/movie.service';
import {  FavoritesService } from '../Booking/favorites.service';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@Angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  loggedInUser={loggedOut:true};
  validCredentials:boolean = true;
  accessToken: string; // JWT token
  redirectUrl = '/';
  loggedIn:boolean = false;

  //added
 
  name:string;
  baseUrl = environment.baseUrl;
  private token: string;
  error: string = "Login Failed";
 private  role:string;
  isAdmin:boolean=false;
  clickedOnAdd:boolean=false;
  addedToFav:boolean=false;

  userName:string="null";




  authenticateSpring(user:string,password:string):Observable<any> {
    let credentials = btoa(user+':'+password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic '+credentials)
    return this.httpClient.get(this.baseUrl+"auth-service/authenticate", {headers})
  }
  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }



  constructor(private userService:UserServiceService,public router: Router,private httpClient:HttpClient) { }

  authenticateUser(user) {
    this.authenticateSpring(user.username,user.password).subscribe(
      (data)=>{


        console.log(data.role)
        this.role=data.role;



        this.loggedInUser = user.username;
        this.validCredentials = true;
        if(data.role == 'ADMIN')
        this.isAdmin=true;
        this.loggedIn = true;

     this.accessToken=data.token;
     console.log(this.accessToken);

           this.router.navigate(['search-bar']);
      },
      (error)=>{
        this.validCredentials = false;
        console.log(error);
        console.log("ERROR");
   
      }
      )
  }
  logout() {
    this.loggedInUser = {loggedOut:true};
    this.isAdmin = false;
    this.loggedIn = false;
   // this.isLoggedIn = false;
    this.clickedOnAdd = false;
    this.addedToFav = false;
    //this.favoritesservice.clearFavorites();
    this.router.navigate(['login']);
   
  }



}

