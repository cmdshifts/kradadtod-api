package th.ac.utcc.kradadtodapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.utcc.kradadtodapi.models.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByMemberId(Long id);
    List<Transaction> findAllByMemberIdOrderByUploadDateDesc(Long id);
    List<Transaction> findAllByMemberIdAndUploadDateGreaterThanEqualOrderByUploadDateDesc(Long id, LocalDate date);
}
