package vip.lop1992.DBdesiner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vip.lop1992.DBdesiner.bean.DbDesinerBean;

import java.util.List;

/**
 * lop1992
 */
@Repository
public interface DbDesinerDao extends JpaRepository<DbDesinerBean, Long> {
    @Query(value = "select `id`,`name` ,null as data ,null as credate_time from db_desiner ", nativeQuery = true)
    List<DbDesinerBean> findIndex();
}
