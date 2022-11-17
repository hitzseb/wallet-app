package hitzseb.wallet.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hitzseb.wallet.model.AppUser;
import hitzseb.wallet.service.AppUserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AppUserController {
	private final AppUserService userService;

    @PostMapping("/api/v1/registration")
    public void signUp(@RequestBody AppUser user) {
        userService.signUpUser(user);
    }
}
