package th.ac.utcc.kradadtodapi.dataTransfer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionDTO {
    private Long id;
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
    private String category;
    private String type;

    public TransactionDTO(Long id, String receiverName, String receiverAccountId, Long receiverBankCode, String senderName, String senderAccountId, Long senderBankCode, BigDecimal amount, String currency, LocalDate uploadDate, LocalTime uploadTime, String category, String type) {
        this.id = id;
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
        this.category = category;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}