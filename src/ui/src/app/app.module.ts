import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FeedComponent } from './feed/feed.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { PostComponent } from './post/post.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { SettingsComponent } from './settings/settings.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ResetCredentialsComponent } from './reset-credentials/reset-credentials.component';
//import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    FeedComponent,
    UserProfileComponent,
    PostComponent,
    PostDetailComponent,
    SettingsComponent,
    NavbarComponent,
    LoginRegisterComponent,
    ResetCredentialsComponent,
   // RegisterComponent
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
