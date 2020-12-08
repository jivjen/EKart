import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../orders.service';
import { Order } from './Order';
@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders: Order[];
  constructor(private orderService: OrdersService) { }

  errorMessage="";
  filterCriteria="";
  
  ngOnInit(): void {
   this.orderService.getOrders(localStorage.getItem("userId")).subscribe((o) =>{
      this.orders = o;
     },(err)=>this.errorMessage=err); 
  }

  toggleCriteria(criteria)
  {
    this.filterCriteria=criteria;
  }


}
