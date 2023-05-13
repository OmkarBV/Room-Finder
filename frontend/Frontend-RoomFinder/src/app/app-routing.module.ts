import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OwnerloginComponent } from './owner/ownerlogin/ownerlogin.component';
import { OwnerregisterComponent } from './owner/ownerregister/ownerregister.component';
import { IndexPageComponent } from './index-page/index-page.component';
import { HomeComponent } from './home/home.component';
import { TenantloginComponent } from './tenant/tenantlogin/tenantlogin.component';
import { TenantregisterComponent } from './tenant/tenantregister/tenantregister.component';
import { ErrorpageComponent } from './errorpage/errorpage.component';
import { OwnerComponent } from './owner/owner.component';
import { TenantComponent } from './tenant/tenant.component';

const routes: Routes = [  
  {
    path: "", component: IndexPageComponent
  },
  {
    path: "home/:username/:isowner", component: HomeComponent
  },
  {
    path: "ownerlogin", component: OwnerloginComponent
  }, {
    path: 'ownerregister', component: OwnerregisterComponent
  },
  {
    path: 'owner/:username', component: OwnerComponent
  }, {
    path: 'tenant/:username', component: TenantComponent
  },
  {
    path: "tenantlogin", component: TenantloginComponent
  }, {
    path: 'tenantregister', component: TenantregisterComponent
  },
  {
    path: 'errorpage', component: ErrorpageComponent
  },
  {
    path: '**', component: ErrorpageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
