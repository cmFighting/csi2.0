package com.ynu.controller;

import com.ynu.pojo.NoticeWithUser;
import com.ynu.pojo.Noticeinf;
import com.ynu.service.NoticeService;
import com.ynu.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "所有公告", notes = "查询所有的公告信息", httpMethod = "GET")
    @RequestMapping(value = "/notices",method = RequestMethod.GET)
    List<NoticeWithUser> getAllNotices(){
        return noticeService.getAllNotice();
    }

    @ApiOperation(value = "公告模糊查询", notes = "通过标题和内容查询公告信息", httpMethod = "POST")
    @RequestMapping(value = "/noticesearch",method = RequestMethod.POST)
    List<NoticeWithUser> getNoticeByTitleContent(@RequestParam(value = "title",required = false) String title, @RequestParam(value = "content", required = false) String content){
        return noticeService.getNoticeByTitileContent(title,content);

    }

    @ApiOperation(value = "公告查询Id", notes = "通过ID查询公告信息", httpMethod = "POST")
    @RequestMapping(value = "/noticebyid",method = RequestMethod.POST)
    public Noticeinf getNoticeById(@RequestParam("notice_id") int notice_id){
         return noticeService.getNoticeByID(notice_id);
    }

    @ApiOperation(value = "增加公告", notes = "增加新的公告", httpMethod = "POST")
    @RequestMapping(value = "/2/addnotice",method = RequestMethod.POST)
    public Map<String,String> addNotice(@RequestParam("title") String title, @RequestParam("content") String content,@RequestParam("user_id") int user_id){
        //  用户ID其实可以通过session中来获取
        Noticeinf noticeinf = new Noticeinf();
        noticeinf.setContent(content);
        noticeinf.setTitle(title);
        noticeinf.setUser_id(user_id);
        boolean flag = noticeService.addNotice(noticeinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "删除公告", notes = "通过ID删除公告", httpMethod = "POST")
    @RequestMapping(value = "/2/delnotice",method = RequestMethod.POST)
    public Map<String,String> deleteNoticeById(@RequestParam("notice_id") int notice_id){
        boolean flag = noticeService.deleteNotice(notice_id);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "修改公告", notes = "修改公告信息", httpMethod = "POST")
    @RequestMapping(value = "/2/editnotice",method = RequestMethod.POST)
    public Map<String,String> editUser(@RequestParam("notice_id") int notice_id, @RequestParam(value = "title", required = false) String title, @RequestParam(value = "content", required = false) String content){
        Noticeinf noticeinf = noticeService.getNoticeByID(notice_id);
        if(title != null){
            noticeinf.setTitle(title);
        }
        if(content != null){
            noticeinf.setContent(content);
        }
        boolean flag = noticeService.editNOtice(noticeinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "删除公告", notes = "多选删除公告信息", httpMethod = "POST")
    @RequestMapping(value = "/2/delsomenotice",method = RequestMethod.POST)
    public Map<String,String> delSomeNotice(@RequestParam("notice_list") String list){
        boolean flag = noticeService.delSomeNotice(StringUtil.stringToInt(list));
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

}
