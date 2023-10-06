package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService service = new LottoService();
        LottoController controller = new LottoController(service);
        controller.start();
    }
}
