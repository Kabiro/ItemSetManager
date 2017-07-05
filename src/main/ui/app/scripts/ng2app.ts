import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {UpgradeModule} from "@angular/upgrade/static";
import {CoreModule} from "./core/CoreModule";
import {UpgradeAdapter} from "@angular/upgrade";


@NgModule({
    imports: [
        BrowserModule,
        UpgradeModule,
        CoreModule
    ]
})
export class Ng2AppModule {
    ngDoBootstrap() {
    }
}
export const upgradeAdapter = new UpgradeAdapter(Ng2AppModule);
