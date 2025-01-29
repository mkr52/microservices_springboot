package com.food.ordering.system.domain.valueobject;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    // Delegate some business logic to value objects as well
    public boolean isGreaterThanZero() {
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(Money money) {
        return this.amount != null && money != null && this.amount.compareTo(money.amount) > 0;
    }

    public Money add(Money money) {
        return this.amount !=null && money != null ? new Money(setScale(this.amount.add(money.getAmount()))): null;
    }

    public Money subtract(Money money) {
        return this.amount !=null && money != null ? new Money(setScale(this.amount.subtract(money.getAmount()))): null;
    }

    public Money multiply(BigDecimal value) {
        return this.amount !=null && value != null ? new Money(setScale(this.amount.multiply(value))): null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }

    private BigDecimal setScale(BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
