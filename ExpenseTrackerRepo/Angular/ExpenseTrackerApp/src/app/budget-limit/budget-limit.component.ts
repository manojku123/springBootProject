import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ExpenseTrackerService } from '../services/expense-tracker.service';
import { LimitModel } from '../model/limit-model';
import { Budgetmodel } from '../model/budget-model';

@Component({
  
  templateUrl: './budget-limit.component.html',
  styleUrls: ['./budget-limit.component.css']
})
export class BudgetLimitComponent implements OnInit {

  public expenseCategory: LimitModel[];
  date= new Date().toDateString();
  budgetLimit: Budgetmodel[]=[];
  tResponse: Object;
  amount: number=0;


 
  constructor(private router: Router,private httpClientService: ExpenseTrackerService) { 
  }

  ngOnInit() {
  
    this.getCategoryName();
    this.truncate();

  }
  truncate()
  {
this.httpClientService.truncate().subscribe(data => this.tResponse = data);
  }
 getCategoryName()
 {
   this.httpClientService.getCategory().subscribe(
     data => {this.expenseCategory = data as LimitModel[]},
     err => console.log(err),
     () => {
       console.log('category loaded'+ this.expenseCategory[0].category);
for (let i = 0; i < this.expenseCategory.length; i++) {
  console.log('inside for')
  let j=i+1;
 this.budgetLimit.push(new Budgetmodel(j,this.expenseCategory[i].category,0,this.date));
 console.log('amount'+this.budgetLimit[0].amount)
}


     }
   )
 }
 response: any;
 onSubmit()
 {
  this.httpClientService.addBudget(this.budgetLimit).subscribe(
    (data) => {
      this.response=data},
      err => console.log(err),
      () => console.log('budget loaded')
  );
  this.router.navigate(['/expenseTracker'],
  {fragment: 'Budget limit successfully set'});
 }

}
