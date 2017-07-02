import {platformBrowserDynamic} from "@angular/platform-browser-dynamic";
import {Ng2AppModule} from "./ng2app";
import {UpgradeModule} from "@angular/upgrade/static";
import {ng1App} from "./ng1app";

platformBrowserDynamic().bootstrapModule(Ng2AppModule).then(ref => {
    // Once Angular bootstrap is complete then we bootstrap the AngularJS module
    const upgrade = ref.injector.get(UpgradeModule) as UpgradeModule;
    upgrade.bootstrap(document.body, [ng1App.name]);
});