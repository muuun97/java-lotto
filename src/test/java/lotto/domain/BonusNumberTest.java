package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 번호가 중복된 숫자이거나 유효하지 않은 숫자이면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new BonusNumber(1, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 중복되지 않은 숫자여야 합니다.");
    }
}