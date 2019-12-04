import { Component, OnInit } from '@angular/core';
import { fooditem } from 'src/app/fooditem';
import { FoodService } from '../food.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private _foodservice:FoodService) { }
  filterlist:fooditem[];
  ngOnInit() {
  this._foodservice.getAllMenuItems().subscribe(data => this._foodservice.fooditem=data)
  console.log("updating")





  }
  search(event:any)
  {

  //  this._foodservice.getItem(event.target.value).subscribe(filterlist=> this.filterlist=filterlist)

this._foodservice.getSubject().next(event.target.value)
    
  }
  
  }


