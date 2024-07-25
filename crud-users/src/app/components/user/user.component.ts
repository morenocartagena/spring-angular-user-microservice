import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserModel } from 'src/app/model/user-model';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.sass']
})
export class UserComponent implements OnInit {

  listUsers: UserModel [] = [];
  formUser: FormGroup = new FormGroup({});
  isUpdate: boolean = false;

  constructor(private userService: UserService){ }

  ngOnInit(): void {   
    this.list(); 
    this.formUser = new FormGroup({
      id: new FormControl(''),
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      phone: new FormControl(''),
      status: new FormControl('1')
    });
  }

  list(){
    this.userService.getUsers().subscribe(resp =>{
      if(resp){
        this.listUsers = resp;
      }
    });
  }

  save(){
    this.formUser.controls['status'].setValue('1');
    this.userService.saveUser(this.formUser.value).subscribe(resp =>{
      if(resp){
        this.list();
        this.formUser.reset(); 
      }     
    });
  }

  update(){
      this.formUser.controls['status'].setValue('1');
      this.userService.updateUser(this.formUser.value).subscribe(resp =>{
      if(resp){
        this.list();
        this.formUser.reset(); 
      }     
    });
  }

  delete(id: any){
    this.userService.deleteUser(id).subscribe(resp =>{
    if(resp){
      this.list();
    }     
  });
}

  newUser(){
    this.isUpdate = false;
    this.formUser.reset();
  }

  selectItem(item: any){
    this.isUpdate = true;
    this.formUser.controls['id'].setValue(item.id);
    this.formUser.controls['firstName'].setValue(item.firstName);
    this.formUser.controls['lastName'].setValue(item.lastName);
    this.formUser.controls['phone'].setValue(item.phone);    
  }

}
