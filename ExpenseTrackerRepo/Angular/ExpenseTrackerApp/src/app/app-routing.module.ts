import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './home/welcome.component';
import { ExpenseTrackerComponent } from './expense-tracker/expense-tracker.component';
import { DailyExpenseComponent } from './daily-expense/daily-expense.component';
import { BudgetLimitComponent } from './budget-limit/budget-limit.component';
import { ExpenseReportComponent } from './expense-report/expense-report.component';


const routes: Routes = [
  {path:'home', component:WelcomeComponent},
  {path:'expenseTracker', component: ExpenseTrackerComponent},
  { path: 'expense', component: DailyExpenseComponent },
  { path: 'limit', component: BudgetLimitComponent },
  { path: 'report', component: ExpenseReportComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {path: '**', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
