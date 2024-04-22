package th.ac.utcc.kradadtodapi.services;

import org.springframework.stereotype.Service;
import th.ac.utcc.kradadtodapi.dataTransfer.TransactionDTO;
import th.ac.utcc.kradadtodapi.models.Transaction;
import th.ac.utcc.kradadtodapi.models.TransactionCategory;
import th.ac.utcc.kradadtodapi.models.TransactionType;
import th.ac.utcc.kradadtodapi.repositories.TransactionCategoryRepository;
import th.ac.utcc.kradadtodapi.repositories.TransactionRepository;
import th.ac.utcc.kradadtodapi.repositories.TransactionTypeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionService(TransactionRepository transactionRepository, TransactionCategoryRepository transactionCategoryRepository,
                              TransactionTypeRepository transactionTypeRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionCategoryRepository = transactionCategoryRepository;
        this.transactionTypeRepository = transactionTypeRepository;
    }

    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionByMemberId(Long id) {
        List<Transaction> transactions = transactionRepository.findAllByMemberIdOrderByUploadDateDesc(id);
        return transactions.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionByMemberIdAndDate(Long id, LocalDate date) {
        List<Transaction> transactions = transactionRepository.findAllByMemberIdAndUploadDateGreaterThanEqualOrderByUploadDateDesc(id, date);
        return transactions.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<TransactionCategory> getTransactionCategory() {
        return transactionCategoryRepository.findAll();
    }

    public List<TransactionType> getTransactionType() {
        return transactionTypeRepository.findAll();
    }

    private TransactionDTO mapToDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getReceiverName(),
                transaction.getReceiverAccountId(),
                transaction.getReceiverBankCode(),
                transaction.getSenderName(),
                transaction.getSenderAccountId(),
                transaction.getSenderBankCode(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getUploadDate(),
                transaction.getUploadTime(),
                transaction.getTransactionCategory().getCategory(),
                transaction.getTransactionType().getType()
        );
    }
}
