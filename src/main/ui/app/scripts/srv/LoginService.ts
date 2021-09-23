import {Injectable} from "@angular/core";
import {CookieService} from "angular2-cookie";

@Injectable()
export class LoginService {
    constructor(private cookiesService: CookieService) {
    }

    logIn(user: object): void {
        this.cookiesService.put('user', JSON.stringify(user));
    }

    getUser(): object {
        const user = this.cookiesService.get('user');
        return user ? JSON.parse(user) : null;
    }

    logout(): void {
        this.cookiesService.remove('user');
    }
}
