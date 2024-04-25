import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { Observable, takeUntil } from 'rxjs';
import { DestroyServiceService } from '../../destroy-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent extends DestroyServiceService implements OnInit {

  public isLoggedIn$: Observable<boolean> = new Observable<boolean>();
  public isAdmin$: Observable<boolean> = new Observable<boolean>();

  constructor(private authService: AuthService, private router: Router, ) {
    super();
    
  }

  ngOnInit(): void {
    this.isLoggedIn$ = this.authService.isUserLoggedIn();
    this.isAdmin$ = this.authService.isUserAdmin();
  }

  public logOut(): void {
    this.authService.logOut();
  }


  


}
