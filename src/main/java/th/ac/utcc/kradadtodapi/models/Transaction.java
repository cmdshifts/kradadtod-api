package th.ac.utcc.kradadtodapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "transaction")
@SecondaryTable(name = "member", pkJoinColumns = @PrimaryKeyJoinColumn(name = "member_id"))
@SecondaryTable(name = "transaction_category", pkJoinColumns = @PrimaryKeyJoinColumn(name = "transaction_category_id"))
@SecondaryTable(name = "transaction_type", pkJoinColumns = @PrimaryKeyJoinColumn(name = "transaction_type_id"))
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", table = "transaction")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Member member;
    @Column(name = "receiver_name", table = "transaction")
    private String receiverName;
    @Column(name = "receiver_account_id", table = "transaction")
    private String receiverAccountId;
    @Column(name = "receiver_bank_code", table = "transaction")
    private Long receiverBankCode;
    @Column(name = "sender_name", table = "transaction")
    private String senderName;
    @Column(name = "sender_account_id", table = "transaction")
    private String senderAccountId;
    @Column(name = "sender_bank_code", table = "transaction")
    private Long senderBankCode;
    @Column(name = "amount", table = "transaction")
    private BigDecimal amount;
    @Column(name = "currency", table = "transaction")
    private String currency;
    @Column(name = "upload_date", table = "transaction")
    private LocalDate uploadDate;
    @Column(name = "upload_time", table = "transaction")
    private LocalTime uploadTime;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TransactionCategory transactionCategory;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_type_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TransactionType transactionType;

    public Transaction(Member member, String receiverName, String receiverAccountId, Long receiverBankCode, String senderName, String senderAccountId, Long senderBankCode, BigDecimal amount, String currency, LocalDate uploadDate, LocalTime uploadTime, TransactionCategory transactionCategory, TransactionType transactionType) {
        this.member = member;
        this.receiverName = receiverName;
        this.receiverAccountId = receiverAccountId;
        this.receiverBankCode = receiverBankCode;
        this.senderName = senderName;
        this.senderAccountId = senderAccountId;
        this.senderBankCode = senderBankCode;
        this.amount = amount;
        this.currency = currency;
        this.uploadDate = uploadDate;
        this.uploadTime = uploadTime;
        this.transactionCategory = transactionCategory;
        this.transactionType = transactionType;
    }

    public Transaction() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(String receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public Long getReceiverBankCode() {
        return receiverBankCode;
    }

    public void setReceiverBankCode(Long receiverBankCode) {
        this.receiverBankCode = receiverBankCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(String senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public Long getSenderBankCode() {
        return senderBankCode;
    }

    public void setSenderBankCode(Long senderBankCode) {
        this.senderBankCode = senderBankCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public LocalTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
