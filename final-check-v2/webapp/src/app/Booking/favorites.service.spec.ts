import { TestBed } from '@angular/core/testing';

import { FavoritesService} from './favorites.service';

describe('FavoritesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FavoritesService = TestBed.get(FavoritesService);
    expect(service).toBeTruthy();
  });
});
