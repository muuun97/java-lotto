package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("수익률은 소수점 둘째 자리에서 반올림 한다.")
    @Test
    void calculateBenefit() {
        int threeMatches = 1;
        int purchaseMoney = 1000;
        int matchesValue = 5000;
        assertThat(new LottoResult(threeMatches, 0, 0, 0, 0,
                purchaseMoney).getBenefitRating())
                .isEqualTo(
                        Math.round((matchesValue / purchaseMoney) * 100) / 100.0);

    }
}