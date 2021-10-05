package io.changsoft.emwalimu.schoolmis.repos;

import io.changsoft.emwalimu.schoolmis.domain.FeePayment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeePaymentRepository extends JpaRepository<FeePayment, Long> {
}
