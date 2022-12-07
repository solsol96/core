package hello.core.discount;

import hello.core.Member;
import hello.core.member.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    public void test1() {
        // given
        Member member = new Member(1L, "A", Grade.VIP);

        // when
        int result = discountPolicy.discount(member, 1000);

        // then
        assertThat(result).isEqualTo(100);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않는다.")
    public void test2() {
        // given
        Member member = new Member(1L, "A", Grade.Basic);

        // when
        int result = discountPolicy.discount(member, 1000);

        // then
        assertThat(result).isEqualTo(0);
    }
}