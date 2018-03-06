package datagenerator.model.transfer;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Transfer {
    /*
     * making class immutable:
     * - private fields no setters
     * - mutable fields make final
     * - populate fields by constructor
     * - make class final to prevent inheritance
     *
     * */

    private final int id;
    private final int accountId;
    private final BigDecimal moneyValue;
    private final LocalDate transferDate;
    private final String message;

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public BigDecimal getMoneyValue() {
        return moneyValue;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public Transfer(int id, int accountId, String message, BigDecimal moneyValue, LocalDate transferDate) {
        this.id = id;
        this.accountId = accountId;
        this.moneyValue = moneyValue;
        this.transferDate = transferDate;
        this.message = message;
    }
}
