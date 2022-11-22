package hitzseb.wallet.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hitzseb.wallet.model.AppUser;
import hitzseb.wallet.model.Role;
import hitzseb.wallet.repository.AppUserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
	private final static String USER_NOT_FOUND_MSG = "user with name %s not found";
	private final AppUserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(
						String.format(USER_NOT_FOUND_MSG, username)));
	}
	
	public void signUpUser(AppUser user) {
        boolean userExists = userRepository.findByUsername(user.getUsername()).isPresent();
        if (userExists) {
            throw new IllegalStateException("username already taken");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(Role.USER);
        userRepository.save(user);
    }
    
    public AppUser getCurrentUser() {
		return (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}  
}
