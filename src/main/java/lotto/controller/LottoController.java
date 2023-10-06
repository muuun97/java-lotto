package lotto.controller;

import lotto.service.LottoService;
import lotto.service.dto.PurchaseResult;
import lotto.service.dto.WinLotto;
import lotto.view.PrintView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    private final LottoService lottoService;
    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        PurchaseResult purchasedLotto = purchaseLotto();
        WinLotto createdWinningLotto = createWinningLotto();
        result(purchasedLotto, createdWinningLotto);
    }

    private PurchaseResult purchaseLotto() {
        PrintView.printEnterAmountOfPurchase();
        PurchaseResult purchasedLotto = lottoService.purchases(readLine());
        PrintView.printNumberOfPurchasesAndLottoNumbers(
                purchasedLotto.getQuantity(), purchasedLotto.getLottos());
        return purchasedLotto;
    }

    private WinLotto createWinningLotto() {
        PrintView.printEnterWinningNumber();
        String inputWinLotto = readLine();
        PrintView.printEnterBonusNumber();
        String inputBonusNumber = readLine();
        return lottoService.createWinLotto(inputWinLotto, inputBonusNumber);
    }

    private void result(PurchaseResult purchasedLotto, WinLotto createdWinningLotto) {
        PrintView.winSatistics(
                lottoService.winLottery(purchasedLotto, createdWinningLotto));
    }
}
