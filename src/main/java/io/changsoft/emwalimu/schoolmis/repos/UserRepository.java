package io.changsoft.emwalimu.schoolmis.repos;

import io.changsoft.emwalimu.schoolmis.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
