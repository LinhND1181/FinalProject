import { Injectable, OnDestroy } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DestroyServiceService implements OnDestroy{

  protected destroy$ = new Subject<void>();

  constructor() { }
  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

}
