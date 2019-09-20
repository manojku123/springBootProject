import { Expensecategory } from './expensecategory';

describe('Expensecategory', () => {
  it('should create an instance', () => {
    expect(new Expensecategory(1,'test',100,'currentdate')).toBeTruthy();
  });
});
