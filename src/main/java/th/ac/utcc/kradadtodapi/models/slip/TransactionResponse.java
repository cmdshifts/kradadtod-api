package th.ac.utcc.kradadtodapi.models.slip;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResponse {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("data")
    private TransactionData data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public TransactionData getData() {
        return data;
    }

    public void setData(TransactionData data) {
        this.data = data;
    }
}
