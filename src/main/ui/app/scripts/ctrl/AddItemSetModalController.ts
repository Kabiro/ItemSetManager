export class AddItemSetModalController {
    static $inject = ["$uibModalInstance", "itemSet"];

    constructor(private $modalInstance: angular.ui.bootstrap.IModalInstanceService, public itemSet: object) {}

    ok(): void {
        this.$modalInstance.close(this.itemSet);
    }

    cancel(): void {
        this.$modalInstance.dismiss();
    }

}