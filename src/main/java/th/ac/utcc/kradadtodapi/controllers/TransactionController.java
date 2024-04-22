package th.ac.utcc.kradadtodapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.utcc.kradadtodapi.dataTransfer.StatisticDTO;
import th.ac.utcc.kradadtodapi.dataTransfer.TransactionDTO;
import th.ac.utcc.kradadtodapi.dataTransfer.TransactionPostDTO;
import th.ac.utcc.kradadtodapi.models.Member;
import th.ac.utcc.kradadtodapi.models.Transaction;
import th.ac.utcc.kradadtodapi.models.TransactionCategory;
import th.ac.utcc.kradadtodapi.models.TransactionType;
import th.ac.utcc.kradadtodapi.models.slip.TransactionResponse;
import th.ac.utcc.kradadtodapi.repositories.MemberRepository;
import th.ac.utcc.kradadtodapi.repositories.TransactionCategoryRepository;
import th.ac.utcc.kradadtodapi.repositories.TransactionRepository;
import th.ac.utcc.kradadtodapi.repositories.TransactionTypeRepository;
import th.ac.utcc.kradadtodapi.services.SlipOKService;
import th.ac.utcc.kradadtodapi.services.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    private final MemberRepository memberRepository;
    private final SlipOKService slipOKService;

    public TransactionController(TransactionService transactionService, TransactionRepository transactionRepository, TransactionCategoryRepository transactionCategoryRepository, TransactionTypeRepository transactionTypeRepository, MemberRepository memberRepository, SlipOKService slipOKService) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
        this.transactionCategoryRepository = transactionCategoryRepository;
        this.transactionTypeRepository = transactionTypeRepository;
        this.memberRepository = memberRepository;
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

    @GetMapping("/getTransactionByMemberIdAndDateAfter")
    List<TransactionDTO> getTransactionByMemberIdAndDateAfter(@RequestParam Long id, @RequestParam LocalDate date) {
        return transactionService.getTransactionByMemberIdAndDate(id, date);
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
    public ResponseEntity<Transaction> addTransaction(@RequestBody TransactionPostDTO transaction) throws Exception {
        Member member = memberRepository.findById(transaction.getMemberId())
                .orElseThrow(() -> new Exception("Member not found with id: " + transaction.getMemberId()));

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(transaction.getTransactionCategoryId())
                .orElseThrow(() -> new Exception("Transaction category not found with id: " + transaction.getTransactionCategoryId()));

        TransactionType transactionType = transactionTypeRepository.findById(transaction.getTransactionTypeId())
                .orElseThrow(() -> new Exception("Transaction type not found with id: " + transaction.getTransactionTypeId()));

        Transaction t = new Transaction();
        t.setMember(member);
        t.setReceiverName(transaction.getReceiverName());
        t.setReceiverAccountId(transaction.getReceiverAccountId());
        t.setReceiverBankCode(transaction.getReceiverBankCode());
        t.setSenderName(transaction.getSenderName());
        t.setSenderAccountId(transaction.getSenderAccountId());
        t.setSenderBankCode(transaction.getSenderBankCode());
        t.setAmount(transaction.getAmount());
        t.setCurrency(transaction.getCurrency());
        t.setUploadDate(transaction.getUploadDate());
        t.setUploadTime(transaction.getUploadTime());
        t.setTransactionCategory(transactionCategory);
        t.setTransactionType(transactionType);

        Transaction savedTransaction = transactionRepository.save(t);

        return ResponseEntity.ok(savedTransaction);
    }

    @GetMapping("/getStatistics")
    public ResponseEntity<StatisticDTO> getStatistics(@RequestParam Long id, @RequestParam LocalDate date) {
        List<Transaction> incomeTransactions = transactionRepository.findAllByMemberIdAndTransactionTypeIdAndUploadDateGreaterThanEqual(id, 1L, date);
        List<Transaction> outcomeTransactions = transactionRepository.findAllByMemberIdAndTransactionTypeIdAndUploadDateGreaterThanEqual(id, 2L, date);

        BigDecimal totalIncome = incomeTransactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalOutcome = outcomeTransactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        StatisticDTO statisticDTO = new StatisticDTO();

        statisticDTO.setTotalIncome(totalIncome);
        statisticDTO.setTotalOutcome(totalOutcome);
        statisticDTO.setCurrentTotal(totalIncome.subtract(totalOutcome));

        return new ResponseEntity<>(statisticDTO, HttpStatus.OK);
    }
}
