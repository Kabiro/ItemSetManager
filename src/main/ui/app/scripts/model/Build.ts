export interface Build {
    id: number;
    champions: Champion[];
    itemSet: ItemSet;
}

export interface Champion {
    key: string;
    name: string;
    title: string;
    id: number;
}

export interface ItemSet {
    title: string ;
    type: string;
    map: string;
    mode: string;
    priority: boolean;
    sortrank: number;
    blocks: Block[];
}

export interface Block {
    type: string;
    recMath: boolean;
    minSummonerLevel: number;
    maxSummonerLevel: number;
    showIfSummonerSpell: string;
    hideIfSummonerSpell: string;
    items: Item[];
}

export interface Item {
    id: number;
    count: number;
}
