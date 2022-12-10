import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  productList: any;
  constructor( 
    private homeService:HomeService,
    private router: Router
    ) {}

  ngOnInit(): void {
    this.getProductList();
  }

  getProductList() {
   this.homeService.getProductList().subscribe(
    response => { 
      this.productList=response;

    }
   )
  }

  insertUpdateProduct() {
    
    this.router.navigate(['/addProduct']);
};
}
