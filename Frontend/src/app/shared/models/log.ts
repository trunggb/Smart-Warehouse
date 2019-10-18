import {LoginUser} from './login-user';

export interface Log {
  id: number;
  action: Action;
  user: LoginUser;
  createDate: Date;
  oldData: string;
  newData: string;
  beProduct: boolean;
  beUser: boolean;
  beTypeProduct: boolean;
  beOrder: boolean;
  beOrderDetail: boolean;
  beBot: boolean;
}

export enum Action {
  ADD = 'ADD',
  UPDATE = 'UPDATE',
  DELETE = 'DELETE'
}

