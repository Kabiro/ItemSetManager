export interface StaticChampions {
    data: {[k in string]: StaticChampion}
}

export interface StaticChampion {
    id: string
    key: string
    name: string
}
