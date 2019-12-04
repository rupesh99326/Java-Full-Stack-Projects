import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, of } from 'rxjs';
import { fooditem } from '../fooditem';

// const httpOptions = {
//   headers: new HttpHeaders({
//     'Content-Type': 'application/json',
//   })
// };
@Injectable({
  providedIn: 'root'
})
export class MenuItemService {

  constructor(private httpClient: HttpClient) { }
  // getAllMenuItems():Observable<any>{
  //   console.log("hola")
  //   let username='user'
  //   let password='pwd'
  //   const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
  //   return this.httpClient.get<fooditem[]>(`${environment.baseUrl}`+'menu-items',{headers})
  // }
}