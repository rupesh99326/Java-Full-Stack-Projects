import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@Angular/common/http';
import { User } from './signup/User';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

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

    if(data)
    {
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
