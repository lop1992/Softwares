package vip.lop1992.mind;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vip.lop1992.mind.bean.MyMind;

import java.util.List;

/**
 * lop1992
 */
@Repository
public interface MyMindDao extends JpaRepository<MyMind, Long> {
    @Query(value = "select `id`,`name` ,null as data ,null as credate_time from my_mind ", nativeQuery = true)
    List<MyMind> findIndex();
}
