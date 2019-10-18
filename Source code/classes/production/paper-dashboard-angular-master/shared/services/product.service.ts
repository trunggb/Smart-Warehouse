import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private API_BASE = 'http://localhost:8080/api/v1';
  private API_ENDPOINT = '/products';
  private HTTP_OPTIONS = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  get url(): string {
    return `${this.API_BASE}${this.API_ENDPOINT}`;
  }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url);
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.url}/${id}`);
  }

  addProduct(product: Product): void {
    this.http.post<Product>(this.url, product, this.HTTP_OPTIONS);
  }

  updateProduct(product: Product): void {
    this.http.put<Product>(this.url, product, this.HTTP_OPTIONS);
  }
}
