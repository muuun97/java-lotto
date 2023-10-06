package lotto.service.dto;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Objects;

public class PurchaseResult {
    private int quantity;
    private List<Lotto> numbers;

    public PurchaseResult(int quantity, List<Lotto> numbers) {
        this.quantity = quantity;
        this.numbers = numbers;
    }

    public static PurchaseResult from(int quantity, List<Lotto> numbers) {
        return new PurchaseResult(quantity, numbers);
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Lotto> getLottos() {
        return numbers;
    }
}
