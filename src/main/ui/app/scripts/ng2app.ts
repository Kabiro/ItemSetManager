import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {UpgradeModule} from "@angular/upgrade/static";
import {CoreModule} from "./core/CoreModule";
import {UpgradeAdapter} from "@angular/upgrade";
import {ChampionsService} from "./srv/ChampionsService";
import {GameService} from "./srv/GameService";
import {ItemsSetService} from "./srv/ItemsSetService";
import {LoginService} from "./srv/LoginService";
import {SummonerService} from "./srv/SummonerService";
import {HttpModule} from "@angular/http";
import {CookieService} from "angular2-cookie";

@NgModule({
    imports: [
        BrowserModule,
        UpgradeModule,
        CoreModule,
        HttpModule
    ],
    providers: [
        ChampionsService,
        GameService,
        ItemsSetService,
        LoginService,
        SummonerService,
        CookieService
    ]
})
export class Ng2AppModule {
    ngDoBootstrap() {
    }
}
export const upgradeAdapter = new UpgradeAdapter(Ng2AppModule);
