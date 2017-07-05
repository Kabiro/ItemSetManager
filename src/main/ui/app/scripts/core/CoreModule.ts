import {NgModule} from "@angular/core";
import {LolImageComponent} from "./lolimage/LolImageComponent";
import {CommonModule} from "@angular/common";
import {HttpModule} from "@angular/http";

@NgModule({
    imports: [CommonModule, HttpModule],
    declarations: [LolImageComponent],
    entryComponents: [LolImageComponent]
})
export class CoreModule {

}
