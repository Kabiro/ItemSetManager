export class LoginService {
    static $inject = ['$cookies'];

    constructor(private $cookies: ng.cookies.ICookiesService) {
    }

    logIn(user: object): void {
        this.$cookies.putObject('user', user);
    }

    getUser(): object {
        return this.$cookies.getObject('user');
    }

    logout(): void {
        this.$cookies.remove('user');
    }
}