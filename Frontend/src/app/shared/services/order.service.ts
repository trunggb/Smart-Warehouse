import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Order} from "../models/order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private API_BASE = 'http://localhost:8080/api/v1';
  private API_ENDPOINT = '/orders';
  private HTTP_OPTIONS = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  get url(): string {
    return `${this.API_BASE}${this.API_ENDPOINT}`;
  }

  getAll(): Observable<Order[]> {
    return this.http.get<Order[]>(this.url);
  }

  getOne(id: number): Observable<Order> {
    return this.http.get<Order>(`${this.url}/${id}`);
  }

  add(order: Order): void {
    this.http.post<Order>(this.url, order, this.HTTP_OPTIONS);
  }

  update(order: Order): void {
    this.http.put<Order>(this.url, order, this.HTTP_OPTIONS);
  }
}
