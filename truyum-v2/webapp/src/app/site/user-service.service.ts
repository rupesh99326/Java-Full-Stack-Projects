import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

import { Observable } from 'rxjs';
import { User } from './signup/User';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private router:Router,private http:HttpClient) { }
userExists:boolean=true;
  addUser(user:any) {

let NewUsers:User={firstname:user["firstname"],lastname:user["lastname"],username:user["username"],password:user["password"]}

this.addUsers(NewUsers).subscribe(data=>
  {

    this.userExists=data;
console.log(this.userExists);
    if(data)
    {
      console.log("inside if user serivce"+this.userExists);
      this.router.navigate(['login']); 
    }
  },
  (error)=>{console.log(error);}
  )

}
  


addUsers(user:User):Observable<any>
{

  return this.http.post<User>(environment.baseUrl+"auth-service/users",user)
}

}
