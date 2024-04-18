package th.ac.utcc.kradadtodapi.dataTransfer;

import java.math.BigDecimal;

public class TransactionDTO {
    private Long id;
    private String receiverName;
    private String receiverNameTh;
    private String senderName;
    private String senderNameTh;
    private BigDecimal amount;
    private String currency;
    private String uploadDate;
    private String uploadTime;
    private String category;
    private String type;

    public TransactionDTO(Long id, String receiverName, String receiverNameTh, String senderName, String senderNameTh, BigDecimal amount, String currency, String uploadDate, String uploadTime, String category, String type) {
        this.id = id;
        this.receiverName = receiverName;
        this.receiverNameTh = receiverNameTh;
        this.senderName = senderName;
        this.senderNameTh = senderNameTh;
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

    public String getReceiverNameTh() {
        return receiverNameTh;
    }

    public void setReceiverNameTh(String receiverNameTh) {
        this.receiverNameTh = receiverNameTh;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderNameTh() {
        return senderNameTh;
    }

    public void setSenderNameTh(String senderNameTh) {
        this.senderNameTh = senderNameTh;
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

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
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