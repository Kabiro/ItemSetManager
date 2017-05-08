export class ValidateModalController {
    static $inject = ['$uibModalInstance', 'text'];

    constructor(private $modalInstance: ng.ui.bootstrap.IModalInstanceService, private text: String) {
    }

    ok(): void {
        this.$modalInstance.close();
    }

    cancel(): void {
        this.$modalInstance.dismiss();
    }

}