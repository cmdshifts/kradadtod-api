package th.ac.utcc.kradadtodapi.models.slip;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Receiver {
    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("proxy")
    private Proxy proxy;

    @JsonProperty("account")
    private Account account;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
