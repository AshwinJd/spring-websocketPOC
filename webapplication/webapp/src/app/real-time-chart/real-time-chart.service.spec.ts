import { TestBed } from '@angular/core/testing';

import { RealTimeChartService } from './real-time-chart.service';

describe('RealTimeChartService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RealTimeChartService = TestBed.get(RealTimeChartService);
    expect(service).toBeTruthy();
  });
});
