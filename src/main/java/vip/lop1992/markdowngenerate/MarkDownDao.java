package vip.lop1992.markdowngenerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: lop1992
 * @Date: 2019/4/4 9:39
 * 毕竟写代码才不花钱啊
 **/
@Repository
public interface MarkDownDao  extends JpaRepository<MarkDown, Long> {

    @Query(value = "select `id`,`name` ,null as content ,null  as  content_html ,null as create_time,null as create_user,?1 as pid from mark_down where pid = ?1", nativeQuery = true)
    List<MarkDown> findIdNameBypid(long pid);
}
