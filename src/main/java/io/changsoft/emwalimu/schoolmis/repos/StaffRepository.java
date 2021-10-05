package io.changsoft.emwalimu.schoolmis.repos;

import io.changsoft.emwalimu.schoolmis.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff, Long> {
}
