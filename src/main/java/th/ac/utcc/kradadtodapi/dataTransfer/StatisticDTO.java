package th.ac.utcc.kradadtodapi.dataTransfer;

import java.math.BigDecimal;

public class StatisticDTO {

    private BigDecimal totalOutcome;
    private BigDecimal totalIncome;
    private BigDecimal currentTotal;

    public BigDecimal getTotalOutcome() {
        return totalOutcome;
    }

    public void setTotalOutcome(BigDecimal totalOutcome) {
        this.totalOutcome = totalOutcome;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(BigDecimal currentTotal) {
        this.currentTotal = currentTotal;
    }
}
