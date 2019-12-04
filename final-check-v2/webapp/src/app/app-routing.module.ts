import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemEditComponent } from './food/item-edit/item-edit.component';
import { AuthGuardServiceService } from './auth-guard-service.service';
import { SignupComponent } from './site/signup/signup.component';
import { FavoritesComponent } from './Booking/favorites/favorites.component';
import { LoginComponent } from './site/login/login.component';
import { SearchComponent } from './food/search/search.component';

const routes: Routes = [
{ path: '', redirectTo: 'search-bar', pathMatch: 'full'},  
  { path: 'edit-food-item/:id', component: ItemEditComponent, canActivate: [AuthGuardServiceService]},
{ path: 'signup', component: SignupComponent},
{ path: 'favorites', component: FavoritesComponent, canActivate: [AuthGuardServiceService]},
{ path: 'login',component: LoginComponent},
{ path: 'search-bar',component: SearchComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes
     )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
// { enableTracing: true }