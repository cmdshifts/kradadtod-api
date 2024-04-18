package th.ac.utcc.kradadtodapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utcc.kradadtodapi.dataTransfer.TransactionDTO;
import th.ac.utcc.kradadtodapi.models.slip.TransactionResponse;
import th.ac.utcc.kradadtodapi.services.SlipOKService;
import th.ac.utcc.kradadtodapi.services.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final SlipOKService slipOKService;

    public TransactionController(TransactionService transactionService, SlipOKService slipOKService) {
        this.transactionService = transactionService;
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
}
