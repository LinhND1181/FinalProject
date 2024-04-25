import { Component, Inject, OnInit } from '@angular/core';
import { ErrorMessage } from '../../shared/basedUrls';
import { AuthService } from '../../services/auth.service';
import { FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { Router } from '@angular/router';
import { CoreService } from '../../core/core.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';


/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})

export class LoginComponent implements OnInit {

  errorMessage: string = '';
  loginForm: FormGroup;

  matcher = new MyErrorStateMatcher();

  constructor(private _fb: FormBuilder,
    private authService: AuthService,
    private router: Router) {
    this.loginForm = this._fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(3)]],
    })

  }

  onFormSubmit(): void {

    if (this.loginForm.valid) {
      this.login();
    }
  }

  public $error: Array<ErrorMessage> = [{}, {}];
  // public username: string = '';
  // public password: string = '';


  public username = new FormControl('', [Validators.required, Validators.minLength(3)]);
  public password = new FormControl('', [Validators.required, Validators.minLength(3)]);



  ngOnInit(): void {
  }

  getErrorMessage() {

    if (this.username.hasError('required')) {
      return 'Username is required';
    }
    if (this.username.hasError('minlength')) {
      return 'Username is not valid';
    }
    if (this.password.hasError('required')) {
      return 'Password is required';
    }
    if (this.password.hasError('minlength')) {
      return 'Password is not valid';
    }
    return '';
  }

  public login(): void {
    const username: string | null = this.loginForm.get('username')?.value;
    const password: string | null = this.loginForm.get('password')?.value;

    if (username && password) {
      this.authService.login(username, password).subscribe(
        (response) => {
          alert('Login succesfully');
          this.router.navigate(['/']);
        },
        (error) => {
          this.errorMessage = 'Login failed. Please check your username and password.';
          alert(this.errorMessage);
        }
      );
    }

    else {
      this.$error = this.authService.getErrorMessage();
    }
  }


}
