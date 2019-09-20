import { Component, OnInit, Injectable, OnDestroy } from '@angular/core';
import { ExpenseTrackerService } from '../services/expense-tracker.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
@Component({
 
  templateUrl: './expense-tracker.component.html',
  styleUrls: ['./expense-tracker.component.css']
})
export class ExpenseTrackerComponent implements OnInit,OnDestroy {
  
userName: string='Manoj Kumar';
today: number=Date.now();
public expCategory;
private subscription: Subscription;
message: string='';

  constructor(private httpClientService: ExpenseTrackerService, private route: ActivatedRoute) {
this.message=this.route.snapshot.fragment;
   }
  ngOnInit() {
    this.getCategory();
  }
 
public getCategory()
{
  this.subscription = this.httpClientService.getCategory().subscribe(
    data => {this.expCategory=data},
    err => console.log(err),
    () => console.log('category loaded')
  );
}
onclick(temp: string)
{
this.httpClientService.expClickButton(temp);

}  
onClick1(num: string)
{
this.httpClientService.reportClickButton(num);
}
ngOnDestroy(): void {
 this.subscription.unsubscribe();
}
}
