import {NgModule} from "@angular/core";
import {LolImageComponent} from "./lolimage/LolImageComponent";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
    imports: [CommonModule, HttpClientModule],
    declarations: [LolImageComponent],
    entryComponents: [LolImageComponent]
})
export class CoreModule {

}
