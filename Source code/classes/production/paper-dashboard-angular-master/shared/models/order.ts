import {LoginUser} from './login-user';

export interface Order {
  id: number;
  status: OrderStatus;
  total: number;
  user: LoginUser;
  comment: string;
}

enum OrderStatus {
  IN_CREATED = 'IN_CREATED',
  OUT_CREATED = 'OUT_CREATED',
  RUNNING = 'RUNNING',
  DONE = 'DONE',
  FAILURE = 'FAILURE',
}
