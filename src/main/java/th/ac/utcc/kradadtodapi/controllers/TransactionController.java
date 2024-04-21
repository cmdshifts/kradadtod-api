package th.ac.utcc.kradadtodapi.controllers;

import org.springframework.web.bind.annotation.*;
import th.ac.utcc.kradadtodapi.dataTransfer.TransactionDTO;
import th.ac.utcc.kradadtodapi.models.Transaction;
import th.ac.utcc.kradadtodapi.models.TransactionCategory;
import th.ac.utcc.kradadtodapi.models.TransactionType;
import th.ac.utcc.kradadtodapi.models.slip.TransactionResponse;
import th.ac.utcc.kradadtodapi.repositories.TransactionRepository;
import th.ac.utcc.kradadtodapi.services.SlipOKService;
import th.ac.utcc.kradadtodapi.services.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;
    private final SlipOKService slipOKService;

    public TransactionController(TransactionService transactionService, TransactionRepository transactionRepository, SlipOKService slipOKService) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
        this.slipOKService = slipOKService;
    }

    @GetMapping("/getAll")
    List<TransactionDTO> getAllTransaction() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/getAllByMemberId")
    List<TransactionDTO> getAllTransactionByMemberId(@RequestParam Long id) {
        return transactionService.getTransactionByMemberId(id);
    }

    @GetMapping("/getSlipData")
    public TransactionResponse getTransactionData(@RequestParam String value) {
        return slipOKService.fetchSlipOkData(value);
    }

    @GetMapping("/getCategory")
    List<TransactionCategory> getAllCategory() {
        return transactionService.getTransactionCategory();
    }

    @GetMapping("/getType")
    List<TransactionType> getAllType() {
        return transactionService.getTransactionType();
    }

    @PostMapping("/add")
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
