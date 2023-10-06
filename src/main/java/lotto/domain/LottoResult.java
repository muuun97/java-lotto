package lotto.domain;

import lotto.common.Constants;

public class LottoResult {
    private int threeMatches;
    private int fourMatches;
    private int fiveMatches;
    private int fiveMatchesByBonus;
    private int sixMatches;
    private int purchaseMoney;
    private double benefitRating;

    public LottoResult(int threeMatches, int fourMatches, int fiveMatches, int fiveMatchesByBonus, int sixMatches, int purchaseMoney) {
        this.threeMatches = threeMatches;
        this.fourMatches = fourMatches;
        this.fiveMatches = fiveMatches;
        this.fiveMatchesByBonus = fiveMatchesByBonus;
        this.sixMatches = sixMatches;
        this.purchaseMoney = purchaseMoney;
        calculateBenefit();
    }

    private void calculateBenefit() {
        double totalMoney =
                    (threeMatches * Constants.THIRD_PLACE) +
                    (fourMatches * Constants.FOURTH_PLACE) +
                    (fiveMatches * Constants.FIFTH_PLACE) +
                    (fiveMatchesByBonus * Constants.FIFTH_BONUS_PLACE) +
                    (sixMatches * Constants.SIXTH_PLACE);

        benefitRating = Math.round(
                (totalMoney / (double) purchaseMoney) * 100) / 100.0;
    }

    public int getThreeMatches() {
        return threeMatches;
    }

    public int getFourMatches() {
        return fourMatches;
    }

    public int getFiveMatches() {
        return fiveMatches;
    }

    public int getFiveMatchesByBonus() {
        return fiveMatchesByBonus;
    }

    public int getSixMatches() {
        return sixMatches;
    }

    public double getBenefitRating() {
        return benefitRating;
    }
}
