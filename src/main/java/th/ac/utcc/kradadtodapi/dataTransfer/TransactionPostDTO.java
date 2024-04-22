package th.ac.utcc.kradadtodapi.dataTransfer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionPostDTO {
    private Long memberId;
    private String receiverName;
    private String receiverAccountId;
    private Long receiverBankCode;
    private String senderName;
    private String senderAccountId;
    private Long senderBankCode;
    private BigDecimal amount;
    private String currency;
    private LocalDate uploadDate;
    private LocalTime uploadTime;
    private Long transactionCategoryId;
    private Long transactionTypeId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public Long getTransactionCategoryId() {
        return transactionCategoryId;
    }

    public void setTransactionCategoryId(Long transactionCategoryId) {
        this.transactionCategoryId = transactionCategoryId;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }
}
