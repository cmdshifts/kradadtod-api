package th.ac.utcc.kradadtodapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.utcc.kradadtodapi.models.TransactionCategory;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {

}
