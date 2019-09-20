import { Budgetmodel } from './budget-model';

describe('BudgetModel', () => {
  it('should create an instance', () => {
    expect(new Budgetmodel(1,'item',100,'date')).toBeTruthy();
  });
});
