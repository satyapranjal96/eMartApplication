import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AddService {

  private baseUrl ='http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getCategoryList(): Observable<any>{
    return this.http.get(this.baseUrl+'/allCategory');
  }

  createProduct(data: any): Observable<any>{
    return this.http.post(this.baseUrl+'/createProduct',data);
  }
}
