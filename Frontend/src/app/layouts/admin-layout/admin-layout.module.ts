import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {AdminLayoutRoutes} from './admin-layout.routing';
import {UserComponent} from '../../pages/user/user.component';
import {TableComponent} from '../../pages/table/table.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {OrdersComponent} from "../../pages/orders/orders.component";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    NgbModule
  ],
  declarations: [
    UserComponent,
    TableComponent,
    OrdersComponent,
  ]
})

export class AdminLayoutModule {
}
