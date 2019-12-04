import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthServiceService } from './site/auth-service.service';
import { Observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardServiceService  implements CanActivate {

  constructor(private authService: AuthServiceService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    // retain the url that is requested for authorization
    this.authService.redirectUrl = state.url;

    console.log('URL', state.url);
    
    return Observable.create((observer: Observer<boolean>) => {
      if (this.authService.loggedIn) {
        console.log('Logged in');
        observer.next(true);
      } else {
        console.log('Not Logged in');
        this.router.navigate(['login'], { queryParams: { from: state.url.substr(1) } });
      }
    });
  }
}
