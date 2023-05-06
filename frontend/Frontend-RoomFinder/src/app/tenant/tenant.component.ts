import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { TenantService } from "../utility/tenant.service";

@Component({
    selector: 'app-tenant',
    templateUrl: './tenant.component.html',
    styleUrls: ['./tenant.component.css']
})
export class TenantComponent implements OnInit {
    username?: string
    tenant = {
        email: ''
        , name: ''
        , number: ''
    }
    constructor(private aroutes: ActivatedRoute, private service: TenantService, private router: Router) { }

    ngOnInit(): void {
        this.getUserName()
        this.getTenant()
    }
    getUserName() {
        this.aroutes.paramMap.
            subscribe((param) => {
                this.username = param.get('username') as string
                console.log(this.username);

            })
    }
    getTenant() {
        this.service.getTenant(this.username).
            subscribe((responce: any) => {
                this.tenant = responce
            }, (error) => {
                console.log(error);
                this.router.navigate(['/errorpage'])
            })
    }
}