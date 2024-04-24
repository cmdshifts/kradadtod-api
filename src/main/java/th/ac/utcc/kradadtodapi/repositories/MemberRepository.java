package th.ac.utcc.kradadtodapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.utcc.kradadtodapi.models.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByEmailEqualsAndPassword(String identity, String password);
    List<Member> findAllByUsernameEqualsAndPassword(String identity, String password);
}
