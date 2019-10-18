import {Location} from './location';

export interface Bot {
  id: number;
  name: string;
  currentLocation: Location;
  initLocation: Location;
}

