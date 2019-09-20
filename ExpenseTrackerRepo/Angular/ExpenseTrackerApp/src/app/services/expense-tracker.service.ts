import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, Subject, Subscription, BehaviorSubject} from 'rxjs';
import { Dailyexpense } from '../model/dailyexpense';
import { Budgetmodel } from '../model/budget-model';
const httpOptions={
  headers: new HttpHeaders({'content-type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class ExpenseTrackerService {

  private messageSource = new BehaviorSubject('');
  currentMessage = this.messageSource.asObservable();
  private messageSource1 = new BehaviorSubject('');
  currentMessage1 = this.messageSource1.asObservable();
  message: string;
  constructor(private http: HttpClient) 
  {
    this.currentMessage.subscribe(message => this.message=message);
   }

  getCategory(): Observable<Object>
  {
    return this.http.get('/server/expense/category');
  }

  toPrintCategory()
  {
    
    return this.http.get('/server/expense/'+this.message);
  }

  addAllTypeExpense(shopping: Dailyexpense[])
  {
    let body=JSON.stringify(shopping);
    return this.http.post('/server/expense/'+this.message, body, httpOptions);
  }
  
  addBudget(budget: Budgetmodel[])
  {
    let body=JSON.stringify(budget);
    return this.http.post('/server/expense/addbudget', body, httpOptions);
  }
  getShopping(): Observable<Object>
  {
    return this.http.get('/server/expense/shopping');
  }
  
  getEntertainment()
  {
    return this.http.get('/server/expense/entertainment');
  }
  getTraveling()
  {
    return this.http.get('/server/expense/traveling');
  }
  getFood()
  {
    return this.http.get('/server/expense/food');
  }
  getOthers()
  {
    return this.http.get('/server/expense/others');
  }
  getRegister()
  {
    return this.http.get('/server/expense/register');
  }
  getBudget()
  {
    return this.http.get('/server/expense/budget');
  }
  truncate()
  {
    return this.http.get('/server/expense/truncate')
  }
expClickButton(message: string)
{
  this.messageSource.next(message);
}
reportClickButton(num: string)
{
this.messageSource1.next(num);
}
}
