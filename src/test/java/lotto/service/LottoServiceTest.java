package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.dto.PurchaseResult;
import lotto.service.dto.WinLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoServiceTest {

    LottoService service;

    @BeforeEach
    void setup() {
        service = new LottoService();
    }

    @DisplayName("랜덤한 6개의 숫자의 로또를 한개 생성한다.")
    @Test
    void createLottoOfOne() {
        assertEquals(6, service.createLottoNumbers().getNumbers());
    }

    @DisplayName("로또는 한장에 1000원이고 나누어지지 않을 시 예외가 발생한다.")
    @Test
    void numbersOfPurchase() {
        String money = "14000";
        assertEquals(14, service.numberOfPurchase(money));

        String money2 = "8888";
        assertThatThrownBy(() -> service.numberOfPurchase(money2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 금액은 1,000원으로 나누어지지 않습니다.");
    }

    @DisplayName("로또의 갯수와 로또 번호를 반환한다.")
    @Test
    void getLottoAndNumbers() {
        PurchaseResult from = PurchaseResult.from(1, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        assertThat(from.getQuantity()).isEqualTo(1);
        assertThat(from.getLottos().get(0)).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("수익률은 소수점 두번쨰 자리에서 반올림 한다.")
    @Test
    void getBenefitRatingRoundingToSecondDecimalDigit() {
        LottoResult lottoResult = service.winLottery(
                new PurchaseResult(1, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))),
                new WinLotto(new Lotto(List.of(1, 2, 3, 33, 44, 45)),
                        new BonusNumber(35, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
        );

        assertThat(lottoResult.getBenefitRating())
                .isEqualTo(Math.round(5000 / 1000 * 100) / 100.0);
    }
}