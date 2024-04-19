package th.ac.utcc.kradadtodapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.utcc.kradadtodapi.models.TransactionType;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
