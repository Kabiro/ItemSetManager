import * as angular from "angular";
import {upgradeAdapter} from "./ng2app";
import {ng1App} from "./ng1app";


angular.element(document).ready(function () {
    upgradeAdapter.bootstrap(document.body,[ng1App.name], {strictDi:true})
});
