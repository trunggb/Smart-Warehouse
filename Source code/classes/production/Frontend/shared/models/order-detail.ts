import {Product} from './product';
import {Bot} from './bot';
import {Cluster} from './cluster';
import {Order} from './order';

export interface OrderDetail {
  id: number;
  product: Product;
  order: Order;
  bot: Bot;
  cluster: Cluster;
  dateCreated: Date;
  dateStart: Date;
}

