import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OwnerComponent } from './owner/owner.component';
import { HomeComponent } from './home/home.component';
import { OwnerloginComponent } from './owner/ownerlogin/ownerlogin.component';
import { OwnerregisterComponent } from './owner/ownerregister/ownerregister.component';
import { IndexPageComponent } from './index-page/index-page.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TenantloginComponent } from './tenant/tenantlogin/tenantlogin.component';
import { TenantregisterComponent } from './tenant/tenantregister/tenantregister.component';
import { ErrorpageComponent } from './errorpage/errorpage.component';
import { TenantComponent } from './tenant/tenant.component';

@NgModule({
  declarations: [
    AppComponent,
    OwnerComponent,
    HomeComponent,
    OwnerloginComponent,
    OwnerregisterComponent,
    IndexPageComponent,
    TenantloginComponent,
    TenantregisterComponent,
    ErrorpageComponent,
    TenantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
