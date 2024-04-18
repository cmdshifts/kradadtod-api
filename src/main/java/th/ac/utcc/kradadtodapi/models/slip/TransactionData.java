package th.ac.utcc.kradadtodapi.models.slip;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionData {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("language")
    private String language;

    @JsonProperty("transRef")
    private String transRef;

    @JsonProperty("sendingBank")
    private String sendingBank;

    @JsonProperty("receivingBank")
    private String receivingBank;

    @JsonProperty("transDate")
    private String transDate;

    @JsonProperty("transTime")
    private String transTime;

    @JsonProperty("transTimestamp")
    private String transTimestamp;

    @JsonProperty("sender")
    private Sender sender;

    @JsonProperty("receiver")
    private Receiver receiver;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("paidLocalAmount")
    private double paidLocalAmount;

    @JsonProperty("paidLocalCurrency")
    private String paidLocalCurrency;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("transFeeAmount")
    private double transFeeAmount;

    @JsonProperty("ref1")
    private String ref1;

    @JsonProperty("ref2")
    private String ref2;

    @JsonProperty("ref3")
    private String ref3;

    @JsonProperty("toMerchantId")
    private String toMerchantId;

    @JsonProperty("qrcodeData")
    private String qrcodeData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTransRef() {
        return transRef;
    }

    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }

    public String getSendingBank() {
        return sendingBank;
    }

    public void setSendingBank(String sendingBank) {
        this.sendingBank = sendingBank;
    }

    public String getReceivingBank() {
        return receivingBank;
    }

    public void setReceivingBank(String receivingBank) {
        this.receivingBank = receivingBank;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getTransTimestamp() {
        return transTimestamp;
    }

    public void setTransTimestamp(String transTimestamp) {
        this.transTimestamp = transTimestamp;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPaidLocalAmount() {
        return paidLocalAmount;
    }

    public void setPaidLocalAmount(double paidLocalAmount) {
        this.paidLocalAmount = paidLocalAmount;
    }

    public String getPaidLocalCurrency() {
        return paidLocalCurrency;
    }

    public void setPaidLocalCurrency(String paidLocalCurrency) {
        this.paidLocalCurrency = paidLocalCurrency;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getTransFeeAmount() {
        return transFeeAmount;
    }

    public void setTransFeeAmount(double transFeeAmount) {
        this.transFeeAmount = transFeeAmount;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public String getRef3() {
        return ref3;
    }

    public void setRef3(String ref3) {
        this.ref3 = ref3;
    }

    public String getToMerchantId() {
        return toMerchantId;
    }

    public void setToMerchantId(String toMerchantId) {
        this.toMerchantId = toMerchantId;
    }

    public String getQrcodeData() {
        return qrcodeData;
    }

    public void setQrcodeData(String qrcodeData) {
        this.qrcodeData = qrcodeData;
    }
}
