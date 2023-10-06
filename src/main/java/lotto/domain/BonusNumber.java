package lotto.domain;

import lotto.common.ErrorCode;

import java.util.Objects;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto lotto) {
        validate(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto lotto) {
        if (!((bonusNumber >= 1 && bonusNumber <= 45)
                && !lotto.getNumbers().contains(bonusNumber))) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER_RANGE_OR_DUPLICATE.toString());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
