import { Component, OnInit } from '@angular/core';
import { AddService } from './add.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  categoryList: any;
  productName:any;
  productPrice:any;
  productDescription:any;
  productCategory:any;
  brandName:any;
  imageUrl:any;
  date:any;
  mode:string = '';
  sideBarAddUpdateLabel = '';
  productCategoryId:any;
  electedProductCategory: any;

  constructor( private addService:AddService) { }

  ngOnInit(): void {
    this.getCategoryList();
    //this.insertProduct();
  }

  getCategoryList() {
   this.addService.getCategoryList().subscribe(
    response => { 
      this.categoryList=response;

    }
   )
  }

  

  insertProduct(){

    console.log(this.electedProductCategory);
    let formData: any = {};
    formData['productName'] = this.productName;
    formData['productPrice'] = this.productPrice;
    formData['productDescription'] = this.productDescription;
    formData['catId'] = this.electedProductCategory;
    formData['productBrand'] = this.brandName;
    formData['productImageUrl'] = this.imageUrl;
    formData['productDate'] = this.date;
   
    this.addService.createProduct(formData).subscribe(
      response => {
        // if (response.status == 1) {
        //   this.getEbookList();
        //   this.showEbookMesssage(true, response.message);
        //   this.opened = false;
       
        // } else {
        //   this.showEbookMesssage(false, response.message);
        // }
      });
  }
  // productStatus() {
  //   if (this.mode == 'ADD') {
  //     this.insertEbook();
  //   } else {
  //     this.updateEbook();
  //   }
  // }
  getType(){
    this.electedProductCategory=this.categoryList.filter((element: { id: any; })=>element.id==this.productCategoryId)[0];
  }
}
