package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class PrintView {
    public static void printEnterAmountOfPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberOfPurchasesAndLottoNumbers(int number, List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(number).append("개를 구매했습니다.").append("\n");
        sb.append(printLottoNumbers(lottos));
        System.out.println(sb);
    }

    private static String printLottoNumbers(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append("[");
            for (int number : lotto.getNumbers()) {
                sb.append(number + ", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void printEnterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printEnterBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요");
    }

    public static void winSatistics(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계").append("\n");
        sb.append("----").append("\n");
        sb.append("3개 일치").append(" (5,000원) - ").append(lottoResult.getThreeMatches()).append("\n");
        sb.append("4개 일치").append(" (50,000원) - ").append(lottoResult.getFourMatches()).append("\n");
        sb.append("5개 일치").append(" (1,500,00원) - ").append(lottoResult.getFiveMatches()).append("\n");
        sb.append("5개 일치, 보너스 불 일치").append(" (30,000,000원) - ").append(lottoResult.getFiveMatchesByBonus()).append("\n");
        sb.append("6개 일치").append(" (2,000,000,000원) - ").append(lottoResult.getSixMatches()).append("\n");
        sb.append("총 수익률은 ").append(lottoResult.getBenefitRating()).append("%입니다.");
        System.out.println(sb);
    }
}
