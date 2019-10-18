import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../shared/services/order.service";
import {Observable} from "rxjs";
import {Order} from "../../shared/models/order";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {
  order$: Observable<Order[]>

  constructor(private orderService: OrderService) {
  }

  ngOnInit() {
    this.order$ = this.orderService.getAll();
  }

}
