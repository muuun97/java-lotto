package lotto.service.dto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class WinLotto {
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public WinLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinLotto from(Lotto lotto, BonusNumber bonusNumber) {
        return new WinLotto(lotto, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
