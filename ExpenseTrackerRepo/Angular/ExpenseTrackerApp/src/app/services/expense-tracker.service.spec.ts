import { TestBed } from '@angular/core/testing';

import { ExpenseTrackerService } from './expense-tracker.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
describe('ExpenseTrackerService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule
    ],
  }));

  it('should be created', () => {
    const service: ExpenseTrackerService = TestBed.get(ExpenseTrackerService);
    expect(service).toBeTruthy();
  });
});
