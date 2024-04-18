package th.ac.utcc.kradadtodapi.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import th.ac.utcc.kradadtodapi.dataTransfer.TransactionDTO;
import th.ac.utcc.kradadtodapi.models.Transaction;
import th.ac.utcc.kradadtodapi.repositories.TransactionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionByMemberId(Long id) {
        List<Transaction> transactions = transactionRepository.findByMemberId(id);
        return transactions.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO mapToDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getReceiverName(),
                transaction.getReceiverNameTh(),
                transaction.getSenderName(),
                transaction.getSenderNameTh(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getUploadDate(),
                transaction.getUploadTime(),
                transaction.getTransactionCategory().getCategory(),
                transaction.getTransactionType().getType()
        );
    }
}
