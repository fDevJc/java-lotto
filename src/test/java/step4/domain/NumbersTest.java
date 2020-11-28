package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @ParameterizedTest
    @DisplayName("지난 당첨번호, 보너스 번호 빈 값인 경우 ")
    @ValueSource(strings = {"",})
    public void 로또_지난_당첨번호_null(String lottoNumbers) {
        assertThatThrownBy(() -> Numbers.of(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 1 ~ 45사이 아닌 숫자 예외")
    @ValueSource(strings = {"-1, 46, 47, 99,"})
    public void 로또_번호_45이상_숫자(String lottoNumbers) {
        assertThatThrownBy(() -> Numbers.of(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 ~ 45사이의 숫자여야 합니다.");
    }
}