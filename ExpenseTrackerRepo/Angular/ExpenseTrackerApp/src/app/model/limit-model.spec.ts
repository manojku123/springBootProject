import { LimitModel } from './limit-model';

describe('LimitModel', () => {
  it('should create an instance', () => {
    expect(new LimitModel(1,'category')).toBeTruthy();
  });
});
