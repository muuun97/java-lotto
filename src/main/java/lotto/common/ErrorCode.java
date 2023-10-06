package lotto.common;

public enum ErrorCode {

    INVALID_LOTTO_OVER_SIZE("로또는 6개의 숫자로 구성됩니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_DUPLICATE_NUMBER("로또 번호는 중복되지 않습니다."),
    INVALID_BONUS_NUMBER_RANGE_OR_DUPLICATE("보너스 번호는 1부터 45 사이의 중복되지 않은 숫자여야 합니다."),
    INVALID_NOT_DIVIDE_MONEY("입력하신 금액은 1,000원으로 나누어지지 않습니다.");

    private String message;

    ErrorCode(String message) {
        this.message = "[ERROR] " + message;
    }

    @Override
    public String toString() {
        return message;
    }
}
