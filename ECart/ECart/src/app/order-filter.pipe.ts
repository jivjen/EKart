import { Pipe, PipeTransform } from '@angular/core';
import { Order } from '../app/orders/Order';

@Pipe({
  name: 'orderFilter'
})

export class OrderFilterPipe implements PipeTransform {
  transform( orders: Order[], criteria:string): unknown {
    
    if(criteria === 'delivered')
    {
      return orders.filter((order) => order.status === 'DELIVERED');
    }
    else if(criteria === 'cancelled')
    {
      return orders.filter((order) => order.status === 'CANCELLED');
    }
    else if(criteria === 'returned')
    {
      return orders.filter((order) =>{order.status === 'RETURNED'});
    }
    else{
      return orders;
    }

}
}
