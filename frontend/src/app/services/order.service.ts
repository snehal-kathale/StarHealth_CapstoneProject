import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, of} from "rxjs";
import {Order} from "../models/Order";
import {apiUrl} from "../../environments/environment";

@Injectable({
    providedIn: 'root'
})
export class OrderService {

    private orderUrl = `${apiUrl}/order`;

    constructor(private http: HttpClient) {
    }

    getPage(page = 1, size = 10): Observable<any> {
        return this.http.get(`${this.orderUrl}/`).pipe();
    }

    show(id): Observable<Order> {
        return this.http.get<Order>(`${this.orderUrl}/create-checkout-session`).pipe(
            catchError(_ => of(null))
        );
    }

    placeOrder(id): Observable<Order> {
        return this.http.patch<Order>(`${this.orderUrl}/add`, null).pipe(
            catchError(_ => of(null))
        );
    }

    getAllOrders(id): Observable<Order> {
        return this.http.patch<Order>(`${this.orderUrl}/`, null).pipe(
            catchError(_ => of(null))
        );
    }
}
