package hitzseb.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hitzseb.wallet.model.AppUser;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	Optional<AppUser> findByEmail(String email);
	
	@Transactional
    @Modifying
    @Query("UPDATE AppUser u " + "SET u.enabled = TRUE WHERE u.email = ?1")
    int enableUser(String email);
}
