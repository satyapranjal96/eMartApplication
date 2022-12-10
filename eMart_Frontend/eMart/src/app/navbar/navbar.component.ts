import { Component, OnInit } from '@angular/core';
import { NavbarService } from './navbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  categoryList: any;

  constructor( private navbarService:NavbarService) { }

  ngOnInit(): void {
    this.getProductList();
  }

  getProductList() {
   this.navbarService.getCategoryList().subscribe(
    response => { 
      this.categoryList=response;

    }
   )
  }
}
