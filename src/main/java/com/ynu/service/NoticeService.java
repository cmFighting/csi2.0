package com.ynu.service;

import com.ynu.pojo.NoticeWithUser;
import com.ynu.pojo.Noticeinf;

import java.util.List;

public interface NoticeService {
    List<NoticeWithUser> getAllNotice();

    List<NoticeWithUser> getNoticeByTitileContent(String title,String content);

    Noticeinf getNoticeByID(int notice_id);

    boolean addNotice(Noticeinf noticeinf);

    boolean deleteNotice(int notice_id);

    boolean editNOtice(Noticeinf noticeinf);

    boolean delSomeNotice(int[] list);
}
