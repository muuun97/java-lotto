package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.Constants;
import lotto.common.ErrorCode;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.dto.PurchaseResult;
import lotto.service.dto.WinLotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    public LottoResult winLottery(PurchaseResult purchasedLotto, WinLotto winningLotto) {
        Set<Integer> win = new HashSet<>(winningLotto.getLotto().getNumbers());
        int[] winList = new int[5];

        for (int i = 0; i < purchasedLotto.getQuantity(); i++) {
            int hit = getHit(win, purchasedLotto, i);
            if (isThird(hit, winList) || isFourth(hit, winList) ||
                    isFifthAndFifthBonus(win, hit, winList,winningLotto.getBonusNumber()) ||
                    isSixth(hit, winList)) {
                continue;
            }
        }

        return new LottoResult(winList[0], winList[1], winList[2], winList[3], winList[4],
                purchasedLotto.getQuantity() * 1000);
    }

    private boolean isSixth(int hit, int[] winList) {
        if (hit == Constants.LOTTO_SIX_CORRECT) {
            winList[4]++;
            return true;
        }
        return false;
    }

    private boolean isFifthAndFifthBonus(Set<Integer> win, int hit, int[] winList, BonusNumber bonusNumber) {
        if (hit == Constants.LOTTO_FIVE_CORRECT) {
            if (win.contains(bonusNumber.getBonusNumber())) {
                winList[2]++;
                return true;
            }
            winList[3]++;
            return true;
        }
        return false;
    }

    private boolean isFourth(int hit, int[] winList) {
        if (hit == Constants.LOTTO_FOUR_CORRECT) {
            winList[1]++;
            return true;
        }
        return false;
    }

    private boolean isThird(int hit, int[] winList) {
        if (hit == Constants.LOTTO_THREE_CORRECT) {
            winList[0]++;
            return true;
        }
        return false;
    }

    private int getHit(Set<Integer> win, PurchaseResult purchasedLotto, int idx) {
        int count = 0;
        for (int number : purchasedLotto.getLottos().get(idx).getNumbers()) {
            if (win.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public WinLotto createWinLotto(String inputWinLotto, String inputBonusNumber) {
        Lotto createdLotto = creatWinNumbers(inputWinLotto);
        BonusNumber createdBonus = createbonusNumber(inputBonusNumber, createdLotto);
        return WinLotto.from(createdLotto, createdBonus);
    }

    private BonusNumber createbonusNumber(String inputBonusNumber, Lotto lotto) {
        return new BonusNumber(Integer.parseInt(inputBonusNumber), lotto);
    }

    private Lotto creatWinNumbers(String inputWinNumbers) {
        Lotto lotto = new Lotto(Arrays.stream(inputWinNumbers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
        return lotto;
    }

    public PurchaseResult purchases(String money) {
        int quantity = numberOfPurchase(money);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(createLottoNumbers());
        }
        return PurchaseResult.from(quantity, lottos);
    }

    public int numberOfPurchase(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        if (money % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NOT_DIVIDE_MONEY.toString());
        }
        return money / Constants.LOTTO_PRICE;
    }

    public Lotto createLottoNumbers() {
        List<Integer> createNumbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_START_RANGE,
                Constants.LOTTO_END_RANGE,
                Constants.LOTTO_SIZE);

        Collections.sort(createNumbers);
        return new Lotto(createNumbers);
    }
}
