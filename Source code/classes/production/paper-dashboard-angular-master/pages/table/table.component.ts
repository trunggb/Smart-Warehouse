import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../shared/services/product.service";
import {Observable} from "rxjs";
import {Product} from "../../shared/models/product";

declare interface TableData {
  headerRow: string[];
  dataRows: string[][];
}

@Component({
  selector: 'table-cmp',
  moduleId: module.id,
  templateUrl: 'table.component.html',
  styleUrls: ['table.component.scss'],
})

export class TableComponent implements OnInit {
  products$: Observable<Product[]>;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.products$ = this.productService.getAllProducts();
  }
}
