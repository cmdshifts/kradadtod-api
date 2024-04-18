package th.ac.utcc.kradadtodapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.utcc.kradadtodapi.models.Achievement;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByMemberId(Long id);
}
