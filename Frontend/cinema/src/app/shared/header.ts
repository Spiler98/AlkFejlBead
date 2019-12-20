import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Header {
    public get options() {
        const headers = {
          'authorization': 'Basic YWRtaW46cGFzc3dvcmQ=',
          'Content-Type': 'application/json'
        };
    
        if (window.localStorage.getItem('token')) {
          headers['Authorization'] = `Basic ${window.localStorage.getItem('token')}`;
        }
    
        return {
          headers: new HttpHeaders(headers)
        }
    };
}
