package com.ynu.mapper;

import com.ynu.pojo.NoticeWithUser;
import com.ynu.pojo.Noticeinf;
import com.ynu.pojo.UserWithNotice;
import com.ynu.pojo.Userinf;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface NoticeinfMapper {
    List<Noticeinf> getAllNoticeinf();

    List<UserWithNotice> getAllUserWithNotice();

    void addNotice(Noticeinf noticeinf);

    void deleteNoticeById(@Param("notice_id") int notic_id);

    void updateNoticeinf(Noticeinf noticeinf);

    // 查询的这块事务全部改成了联合查询，其实1对多的关系，你反过来看，单边的话就是1对1
    List<NoticeWithUser> getAllNoticwithuser();

    Noticeinf selectNoticeinfById(@Param("notice_id") int notice_id);

    List<NoticeWithUser> selectNoticeinfByTitileAndContent(@Param("title") String title, @Param("content") String Content);

    void delSomeNotices(@Param("list") int[] list);

}
