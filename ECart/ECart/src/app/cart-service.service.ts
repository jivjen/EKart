import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CartItem } from './cart/CartItem';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { }

  getCartItems(userId){
    return this.http.get<CartItem[]>("http://localhost:4444/"+userId+"/cart");
  }
}
