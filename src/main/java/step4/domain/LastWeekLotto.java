package step4.domain;

import step4.exception.BonusNumberDuplicateNumber;

import java.util.Objects;

public class LastWeekLotto {

    private final Lotto lastWeekLotto;
    private final LottoNumber bonusNumber;

    private LastWeekLotto(Lotto lastWeekLotto, LottoNumber bonusNumber) {
        this.lastWeekLotto = lastWeekLotto;
        this.bonusNumber = bonusNumber;
    }


    public static LastWeekLotto of(Lotto lotto, LottoNumber bonusNumber) {
        validBonusNumber(lotto , bonusNumber);

        return new LastWeekLotto(lotto, bonusNumber);
    }
    private static void validBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if(lotto.has(bonusNumber)){
            throw new BonusNumberDuplicateNumber();
        }
    }


    public LottoRank getRanking(Lotto lotto) {
        return LottoRank.valueOf(lastWeekLotto.matchLottoNumbers(lotto), lotto.has(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastWeekLotto that = (LastWeekLotto) o;
        return Objects.equals(lastWeekLotto, that.lastWeekLotto) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastWeekLotto, bonusNumber);
    }
}