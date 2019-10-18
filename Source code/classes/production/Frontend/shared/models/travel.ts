import {Bot} from './bot';
import {OrderDetail} from './order-detail';

export interface Travel {
  id: number;
  bot: Bot;
  orderDetail: OrderDetail;
  from: Location;
  to: Location;
  start: Date;
  end: Date;
}
