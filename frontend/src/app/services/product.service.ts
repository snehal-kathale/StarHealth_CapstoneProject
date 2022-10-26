import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {ProductInfo} from '../models/productInfo';
import {apiUrl} from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    private productUrl = `${apiUrl}/product`;
    private categoryUrl = `${apiUrl}/category`;

    constructor(private http: HttpClient) {
    }



    getCategoryInPage(categoryType: number, page: number, size: number): Observable<any> {
        const url = `${this.categoryUrl}/`;
        return this.http.get(url).pipe(
            // tap(data => console.log(data))
        );
    }

    update(productInfo: ProductInfo): Observable<ProductInfo> {
        const url = `${apiUrl}/update/${productInfo.productId}`;
        return this.http.put<ProductInfo>(url, productInfo);
    }

    create(productInfo: ProductInfo): Observable<ProductInfo> {
        const url = `${apiUrl}/add`;
        return this.http.post<ProductInfo>(url, productInfo);
    }



    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

            console.error(error); // log to console instead

            // Let the app keep running by returning an empty result.
            return of(result as T);
        };
    }
}
