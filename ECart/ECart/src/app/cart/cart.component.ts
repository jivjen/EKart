import { Component, OnInit } from '@angular/core';
import { CartService } from '../../app/cart-service.service';
import {CartItem} from '../cart/CartItem';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private cartService: CartService) { }
  cartItems: CartItem[];
  discountOffered: boolean;
  totalPrice: number = 0;
  totalDeliveryCharge: number = 0;
  grandTotal:number = 0;
  itemCount: number = 0;
  ngOnInit(): void {
    this.cartService.getCartItems(localStorage.getItem("userId")).subscribe((item) => {
      this.cartItems = item;
      this.cartItems.forEach((item) => {
        this.totalPrice += item.total;
        this.totalDeliveryCharge += item.deliveryCharge;
        this.grandTotal = this.totalPrice + this.totalDeliveryCharge;
      });
      this.itemCount = this.cartItems.length;
    })
  }

}
