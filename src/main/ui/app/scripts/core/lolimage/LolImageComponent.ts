import {Component, Inject, Input, OnInit} from "@angular/core";
import {ChampionsService} from "../../srv/ChampionsService";

type Image = "profile" | "championSplash" | "championLoading" | "championSquare" | "item";
interface ImageConfig {
    version: boolean
    prefix: string
    suffix: string
    transformFunction: any
}

@Component({
    selector: "ism-lol-image",
    templateUrl: "./core/lolimage/lol-image.component.html"
})
export class LolImageComponent implements OnInit {
    @Input() id: string;
    @Input() type: Image;

    private baseUrl = 'https://ddragon.leagueoflegends.com/cdn/';
    private lolVersion = '11.10.1';
    private imageUrl: string = null;

    private configs:{ [K in Image]: ImageConfig } = {
        profile: {
            version: true,
            prefix: 'img/profileicon/',
            suffix: '.png',
            transformFunction: this.identity
        },
        championSplash: {
            version: false,
            prefix: 'img/champion/splash/',
            suffix: '_0.jpg',
            transformFunction: this.championIdToChampionKey
        },
        championLoading: {
            version: false,
            prefix: 'img/champion/loading/',
            suffix: '_0.jpg',
            transformFunction: this.championIdToChampionKey
        },
        championSquare: {
            version: true,
            prefix: 'img/champion/',
            suffix: '.png',
            transformFunction: this.championIdToChampionKey
        },
        item: {
            version: true,
            prefix: 'img/item/',
            suffix: '.png',
            transformFunction: this.identity
        }
    };

    private championIdToChampionKey(id: string, champions: any): string {
        return champions[id].id;
    }

    private identity(id: string): string {
        return id;
    }

    constructor(@Inject(ChampionsService) private championService: ChampionsService) {
    }

    ngOnInit(): void {
        this.championService.championsByKey.then((result) => {
            const champions = result;
            this.imageUrl = this.baseUrl;
            const config = this.configs[this.type];
            if (config.version) {
                this.imageUrl += this.lolVersion + '/';
            }
            this.imageUrl += config.prefix + config.transformFunction(this.id, champions) + config.suffix;
        }, () => {});
    }
}
