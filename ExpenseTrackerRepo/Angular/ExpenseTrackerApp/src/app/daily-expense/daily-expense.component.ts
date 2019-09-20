import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Router} from '@angular/router'
import { ExpenseTrackerService } from '../services/expense-tracker.service';
import { Dailyexpense } from '../model/dailyexpense';
import { Expensecategory } from '../model/expensecategory';
import { Budgetmodel } from '../model/budget-model';


 
@Component({
  selector: 'app-daily-expense',
  templateUrl: './daily-expense.component.html',
  styleUrls: ['./daily-expense.component.css']
})
export class DailyExpenseComponent implements OnInit {


  getIndex: Expensecategory[];
  index: number=0;
  hide: boolean=false;
  addMoreItem = [];
  catName: string;
  date: string= new Date().toDateString();
  public categoryWise;
  expenseModel: Dailyexpense[]= [new Dailyexpense(this.index,'item0', 0, this.date)] ;
  cond: boolean = true;
  message: string='';
  categoryWiseExpenseList: Expensecategory[];
  categoryWiseTotalAmount: number = 0;
  budgetList: Budgetmodel[];
  j: number=0;
  item0123: string;
  amount0123: string;


  constructor(private router: Router, private httpClientService: ExpenseTrackerService) { 
    this.getBudget();
  
  }

  ngOnInit() {
    this.httpClientService.currentMessage.subscribe(catName => this.catName=catName);
    this.toPrintCategoryWise();
  }

  private toPrintCategoryWise()
  {
    this.httpClientService.toPrintCategory().subscribe(
     data => {this.categoryWise=data},
     err => console.log(err),
     () => console.log('category wise loaded')
    );
  }
  
addMore()
{
  this.index++;
  console.log('index1'+ this.index)
  this.j+=1;
  this.item0123=('item'+this.j);
  this.amount0123=('amount'+this.j);
  this.expenseModel.push(new Dailyexpense(this.index,this.item0123, 0, this.date));
  this.addMoreItem.push(this.addMoreItem.length+1);
  if(this.addMoreItem.length>0){
  this.hide=true;
  }
}

deleteItem(index: number){
this.addMoreItem.splice(index,1);
this.expenseModel.splice(this.expenseModel.length-1,1);
if(this.addMoreItem.length<1){
  this.hide=false;
  }
}
getBudget(){
  this.httpClientService.getBudget().subscribe(
    (data) => {this.budgetList = data as Budgetmodel[]},
    err => console.log(err),
    () => console.log('budget limit loaded')

  );
  
}
onSubmit()
{
  if(this.budgetList.length<=0)
  {
    alert('please set budget limit first')
    this.router.navigate(['/expenseTracker'])
  }
  else{
for(let i=0;i<this.budgetList.length;i++){
  if(this.catName==this.budgetList[i].item){
  this.httpClientService.addAllTypeExpense(this.expenseModel).subscribe(
    (data) => {this.categoryWiseExpenseList = data as Expensecategory[]},
    err => console.log(err),
    () => {
      for (let index = 0; index < this.categoryWiseExpenseList.length; index++) {
        this.categoryWiseTotalAmount += this.categoryWiseExpenseList[index].amount;
        }
        if(this.categoryWiseTotalAmount > this.budgetList[i].amount)
        {
          alert(this.budgetList[i].item+' limit exceeded')
        }
    }
      );
      break;
  }
}

this.router.navigate(['/expenseTracker'],
{fragment: (this.addMoreItem.length+1)+' item added to '+this.catName+' category successfully'})
 }//else end
}
}
