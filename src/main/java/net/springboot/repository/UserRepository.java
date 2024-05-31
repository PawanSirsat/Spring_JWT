package net.springboot.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import net.springboot.model.Users;


public interface UserRepository extends JpaRepository<Users, String> {
	
	public Optional<Users> findByEmail(String email);

}