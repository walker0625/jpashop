package jpabook.jpashop.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// 다른 Entity에서 공유해서 사용하는 경우 인스턴스를 복사(new)해서 사용해야 함(같은 인스턴스를 사용 후 수정하면 update가 n번 실행됨)
// 생성자로만 인스턴스를 만들 수 있게 하고(일부 수정시 생성자로 재생성하여 교체), setter를 금지하여 불변객체로 사용
@EqualsAndHashCode
@Setter(AccessLevel.PRIVATE) // 생략해도 무방
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(length = 10)
    private String city;
    @Column(length = 30)
    private String street;
    @Column(length = 5)
    private String zipcode;

    // 유용한 메소드 정의해서 사용
    public String fullAddress() {
        return new StringBuilder().append(getCity())
                                  .append(" ")
                                  .append(getStreet())
                                  .append(" ")
                                  .append(getZipcode())
                                  .toString();
    }

}
