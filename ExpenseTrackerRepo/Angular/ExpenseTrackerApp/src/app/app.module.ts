import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms'
import { DailyExpenseComponent } from './daily-expense/daily-expense.component';
import { ExpenseTrackerComponent } from './expense-tracker/expense-tracker.component';
import { BudgetLimitComponent } from './budget-limit/budget-limit.component';
import { ExpenseReportComponent } from './expense-report/expense-report.component';
import {RouterModule,Router} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { WelcomeComponent } from './home/welcome.component';
import { ExpenseTrackerService } from './services/expense-tracker.service';


@NgModule({
  declarations: [
    AppComponent,
    DailyExpenseComponent,
    ExpenseTrackerComponent,
    BudgetLimitComponent,
    ExpenseReportComponent,
    WelcomeComponent, 
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    RouterModule
  ],
 
  providers: [ExpenseTrackerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
