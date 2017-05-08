export class AddItemSetModelController {
    static $inject = ["$modalInstance", "ItemSet"];

    constructor(private $modalInstance: angular.ui.bootstrap.IModalInstanceService, public itemSet: object) {}

    ok(): void {
        this.$modalInstance.close(this.itemSet);
    }

    cancel(): void {
        this.$modalInstance.dismiss();
    }

}