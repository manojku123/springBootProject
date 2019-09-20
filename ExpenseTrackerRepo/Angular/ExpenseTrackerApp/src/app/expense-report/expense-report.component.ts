import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router'
import { ExpenseTrackerService } from '../services/expense-tracker.service';
import { Expensecategory } from '../model/expensecategory';

@Component({
 
  templateUrl: './expense-report.component.html',
  styleUrls: ['./expense-report.component.css']
})
export class ExpenseReportComponent implements OnInit {

  shopping: Expensecategory[];
  entertainment: Expensecategory[];
  food: Expensecategory[];
  traveling: Expensecategory[];
  others: Expensecategory[];
  totalShoppingAmount: number=0;
  totalFoodAmount: number=0;
  totalEntertainmentAmount: number=0;
  totalTravelingAmount: number=0;
  totalOthersAmount: number=0;
  shoppingLength: number;
  entertainmentLength: number;
  foodLength: number;
  travelingLength: number;
  othersLength: number;
  length: string;
  num: number;
  constructor(private router: Router, private httpClientService: ExpenseTrackerService) 
  {
    this.httpClientService.currentMessage1.subscribe(length => this.length=length);
      this.num=Number(this.length);
  }

  ngOnInit() {
   this.getShopping();
   this.getTraveling();
   this.getEntertainment();
   this.getFood();
   this.getOthers();
  }
  public getShopping()
{
  this.httpClientService.getShopping().subscribe(
    data => {this.shopping=data as Expensecategory[]},
    err => console.log(err),
    () => {
    console.log('shoppinh category loaded');
    this.shoppingLength=this.shopping.length;
    for(let i =0; i<this.shoppingLength;i++)
    {
this.totalShoppingAmount += this.shopping[i].amount;
    }
  }
  );
}
public getEntertainment()
{
  this.httpClientService.getEntertainment().subscribe(
    data => {this.entertainment=data as Expensecategory[]},
    err => console.log(err),
    () => {
      console.log('entertainment category loaded');
      this.entertainmentLength=this.entertainment.length;
      for(let i =0; i<this.entertainmentLength;i++)
      {
  this.totalEntertainmentAmount+=this.entertainment[i].amount;
      }
    }
  );
}
public getTraveling()
{
  this.httpClientService.getTraveling().subscribe(
    data => {this.traveling=data as Expensecategory[]},
    err => console.log(err),
    () =>{ 
      console.log('traveling category loaded');
      this.travelingLength=this.traveling.length;
      for(let i =0; i<this.travelingLength;i++)
      {
  this.totalTravelingAmount+=this.traveling[i].amount;
      }
    }
  );
}
public getFood()
{
  this.httpClientService.getFood().subscribe(
    data => {this.food=data as Expensecategory[]},
    err => console.log(err),
    () => {
      console.log('food category loaded');
      this.foodLength=this.food.length;
      for(let i =0; i<this.foodLength;i++)
      {
  this.totalFoodAmount+=this.food[i].amount;
      }
    }
  );
}
public getOthers()
{
  this.httpClientService.getOthers().subscribe(
    data => {this.others=data as Expensecategory[]},
    err => console.log(err),
    () => {
      console.log('others category loaded');
      this.othersLength=this.others.length;
      for(let i =0; i<this.othersLength; i++)
      {
  this.totalOthersAmount+=this.others[i].amount;
      }
    }
  );
}
  goHome()
  {
    this.router.navigate(['/expenseTracker'])
  }
 goBack()
 {
  this.router.navigate(['/expenseTracker'])
 }

}
