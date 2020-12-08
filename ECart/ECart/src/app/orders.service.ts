import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Order} from '../app/orders/Order';
@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private http: HttpClient) { 
  }

  getOrders(userId)
  {
    return this.http.get<Order[]>("http://localhost:4444/"+userId+"/orders");
  }
}
