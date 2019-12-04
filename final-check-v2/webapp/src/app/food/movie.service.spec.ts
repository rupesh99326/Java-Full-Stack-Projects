import { TestBed } from '@angular/core/testing';

import {  MovieService } from './movie.service';

describe('FoodService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MovieService = TestBed.get(MovieService);
    expect(service).toBeTruthy();
  });
});
