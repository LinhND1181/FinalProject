import { Component, Inject, OnInit } from '@angular/core';
import { DateAdapter, MAT_DATE_FORMATS } from '@angular/material/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../../../../models/user';
import { UserService } from '../../../../services/user.service';
import { DialogRef } from '@angular/cdk/dialog';
import { MyErrorStateMatcher } from '../../../login/login.component';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CoreService } from '../../../../core/core.service';

@Component({
  selector: 'app-user-add-edit',
  templateUrl: './user-add-edit.component.html',
  styleUrl: './user-add-edit.component.scss'
})
export class UserAddEditComponent implements OnInit {

  selected: string = "male";

  userForm: FormGroup;

  matcher: MyErrorStateMatcher = new MyErrorStateMatcher();

  selectedFile!: File;

  phoneNumberRegEx = /^(\+?84|0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-6|8-9]|9\d)([0-9]{7})$/;

  constructor(private _fb: FormBuilder,
    private userService: UserService,
    private _dialogRef: MatDialogRef<UserAddEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private coreService: CoreService) {
    this.userForm = this._fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      fullName: ['', [Validators.required, Validators.minLength(3)]],
      birthday: ['', Validators.required],
      address: ['', [Validators.required, Validators.minLength(5)]],
      phoneNumber: ['', [Validators.required, Validators.pattern(this.phoneNumberRegEx)]],
      gender: ['', Validators.required],

    })

  }
  ngOnInit(): void {
    if (this.data !== null) {

      // hiển thị ngày tháng trong input của birthday
      const birthdayValue: Date = new Date(this.data.birthday);
      this.userForm.patchValue(this.data);
      this.userForm.get('birthday')?.patchValue(birthdayValue);
      
      // hiển thị ảnh ở ô input mỗi khi người dùng chọn ảnh
      if (this.data.avatar !== null) {
        this.getUserAvatar(this.data.avatar);
      }
    }
  }

  getUserAvatar(userAvatar: string) {
    const preview = document.getElementById("imagePreview");
    if (preview !== null) {
      const img = document.createElement("img");
      img.id = 'userAvatar';
      img.alt = "User's avatar";
      img.src = userAvatar;
      img.style.maxWidth = "100%";
      preview.innerHTML = "";
      preview.appendChild(img);
    }
  }

  previewImage(input: any): void {
    const preview = document.getElementById("imagePreview");

    if (input.files && input.files[0]) {
      this.selectedFile = input.files[0];
      const reader = new FileReader();

      reader.onload = async function (e) {
        if (e && e.target && e.target.result && typeof e.target.result === 'string' && preview !== null) {
          const preImg: HTMLImageElement | null = document.getElementById('userAvatar') as HTMLImageElement;
          if (preImg === null) {
            const img = document.createElement("img");
            img.src = e.target.result;
            img.style.maxWidth = "100%";
            preview.innerHTML = "";
            preview.appendChild(img);
          }
          else {
            preImg.src = e.target.result;
            preImg.style.maxWidth = "100%";
          }
        } else {
          console.error('Failed to read the file or event object is null.');
        }
      };

      reader.readAsDataURL(input.files[0]);
    }
  }

  onFormSubmit(): void {
    const username: string | null = this.userForm.get('username')?.value;
    if (this.userForm.valid) {
      if (!this.data) {
        this.userService.createUser(this.userForm.value, this.selectedFile).subscribe({
          next: (val: any) => {
            this.coreService.openSnackBar('User added successfully', 'Done');
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.log(err);
          }
        })
      }
      else {
        this.userService.updateUser(this.userForm.value, this.selectedFile, this.data.id).subscribe({
          next: (val: any) => {
            this.coreService.openSnackBar('User Updated', 'Done');
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.log(err);
          }
        })
      }
    }
  }


}
