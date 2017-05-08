export class Utils {
    static isNullOfUndefined(elem: any) {
        return elem == undefined || elem == null;
    }

    static isDefined(elem: any) {
        return !this.isNullOfUndefined(elem);
    }

    static isEmpty(elem: any) {
        return this.isNullOfUndefined(elem) || elem === '';
    }
}