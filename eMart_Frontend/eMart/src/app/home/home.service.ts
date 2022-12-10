import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private baseUrl ='http://localhost:8080/api';

constructor(private http: HttpClient) {}

getProductList(): Observable<any>{
    return this.http.get(this.baseUrl+'/allProducts');
  }

  getCategoryList(): Observable<any>{
    return this.http.get(this.baseUrl+'/allCategory');
  }

  // getEbookList(): Observable<any>{
  //   return this.http.get(this.baseUrl+'/employees');
  // }
}
