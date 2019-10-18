import {Component, OnInit} from '@angular/core';


export interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  {path: '/products', title: 'Product List', icon: 'nc-tile-56', class: ''},
  {path: '/orders', title: 'Order List', icon: 'nc-tile-56', class: ''},
  {path: '/users', title: 'User Profile', icon: 'nc-single-02', class: ''},
];

@Component({
  moduleId: module.id,
  selector: 'sidebar-cmp',
  templateUrl: 'sidebar.component.html',
})

export class SidebarComponent implements OnInit {
  public menuItems: RouteInfo[];

  ngOnInit() {
    this.menuItems = [...ROUTES];
  }
}
