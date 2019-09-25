package com.ynu.serviceImpl;

import com.ynu.mapper.NoticeinfMapper;
import com.ynu.pojo.NoticeWithUser;
import com.ynu.pojo.Noticeinf;
import com.ynu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionUsageException;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeinfMapper noticeinfMapper;

    @Override
    public List<NoticeWithUser> getAllNotice() {
        return noticeinfMapper.getAllNoticwithuser();
    }

    @Override
    public List<NoticeWithUser> getNoticeByTitileContent(String title, String content) {
        return noticeinfMapper.selectNoticeinfByTitileAndContent(title, content);
    }

    @Override
    public Noticeinf getNoticeByID(int notice_id) {
        return noticeinfMapper.selectNoticeinfById(notice_id);
    }

    @Override
    public boolean addNotice(Noticeinf noticeinf) {
        noticeinfMapper.addNotice(noticeinf);
        return true;
    }

    @Override
    public boolean deleteNotice(int notice_id) {
        noticeinfMapper.deleteNoticeById(notice_id);
        return true;
    }

    @Override
    public boolean editNOtice(Noticeinf noticeinf) {
        noticeinfMapper.updateNoticeinf(noticeinf);
        return true;
    }

    @Override
    public boolean delSomeNotice(int[] list) {
        noticeinfMapper.delSomeNotices(list);
        return true;
    }
}
