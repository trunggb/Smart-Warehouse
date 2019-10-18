import {Routes} from '@angular/router';
import {UserComponent} from '../../pages/user/user.component';
import {TableComponent} from '../../pages/table/table.component';
import {OrdersComponent} from "../../pages/orders/orders.component";

export const AdminLayoutRoutes: Routes = [
  {path: 'users', component: UserComponent},
  {path: 'products', component: TableComponent},
  {path: 'orders', component: OrdersComponent}
];
