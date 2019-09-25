package com.ynu.controller;

import com.ynu.mapper.DocumentinfMapper;
import com.ynu.pojo.DocumentWithUser;
import com.ynu.pojo.Documentinf;
import com.ynu.service.DocumentService;
import com.ynu.utils.FileUpload;
import com.ynu.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Document;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @ApiOperation(value = "文档查找", notes = "返回所有的文档信息", httpMethod = "GET")
    @RequestMapping(value = "/alldocuments",method = RequestMethod.GET)
    public List<DocumentWithUser> getAllDocuments(){
        return documentService.getAllDocuments();
    }

    @ApiOperation(value = "文档查找Title", notes = "通过Title查找部门信息", httpMethod = "POST")
    @RequestMapping(value = "/docbytitle",method = RequestMethod.POST)
    public List<DocumentWithUser> getDocumentsBytitle(@RequestParam("title") String title){
        return documentService.getDocumentByTitle(title);
    }

    @ApiOperation(value = "文档查找Id", notes = "通过Id查找部门信息", httpMethod = "POST")
    @RequestMapping(value = "/docbyid",method = RequestMethod.POST)
    public Documentinf getDocumentById(@RequestParam("document_id") int document_id){
        return documentService.getDocumentById(document_id);
    }

    @ApiOperation(value = "文档添加", notes = "添加新的文档信息", httpMethod = "POST")
    @RequestMapping(value = "/2/adddoc",method = RequestMethod.POST)
    public Map<String,String> addDocument(@RequestParam("title") String title, @RequestParam("filename") String filename,
                                          @RequestParam("remark") String remark, @RequestParam("user_id") int user_id){
        Documentinf documentinf = new Documentinf();
        // 这不应该是通过文件上传来进行完成。
        documentinf.setFilename(filename);
        documentinf.setRemark(remark);
        documentinf.setTitle(title);
        documentinf.setUser_id(user_id);
        boolean flag = documentService.addDocument(documentinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }

    }

    @ApiOperation(value = "文档删除", notes = "通过ID删除文档", httpMethod = "POST")
    @RequestMapping(value = "/2/deldoc",method = RequestMethod.POST)
    public Map<String,String> deleteDocumentById(@RequestParam("document_id") int document_id){
        boolean flag = documentService.deleteDocument(document_id);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "文档修改", notes = "修改文档信息", httpMethod = "POST")
    @RequestMapping(value = "/2/editdoc",method = RequestMethod.POST)
    public Map<String,String> editDocument(@RequestParam(value = "title",required = false) String title, @RequestParam(value = "filename",required = false) String filename,
                                           @RequestParam(value = "remark",required = false) String remark, @RequestParam(value = "user_id") int user_id,
                                           @RequestParam("document_id") int document_id){
        Documentinf documentinf = documentService.getDocumentById(document_id);
        if(title != null){
            documentinf.setTitle(title);
        }
        if(filename != null){
            documentinf.setFilename(filename);
        }
        if (remark != null){
            documentinf.setRemark(remark);
        }
        documentinf.setUser_id(user_id);
        boolean flag = documentService.editDocument(documentinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "文档上传", notes = "上传文档", httpMethod = "POST")
    @RequestMapping(value = "/2/upload",method = RequestMethod.POST)
    public Map<String, String> upload(@RequestParam("file_name") String fileName, @RequestParam("fileStream")InputStream inputStream){
//    public Map<String, String> upload(@RequestParam("file_name") String fileName, MultipartFile inputStream){

//        String uri = FileUpload.upload(fileName,inputStream);
        String uri = "";
        boolean flag = true;
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("filename", uri);
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "文档删除", notes = "多选删除", httpMethod = "POST")
    @RequestMapping(value = "/2/delsomedocs",method = RequestMethod.POST)
    public Map<String,String> delSomeDocs(@RequestParam("doc_list") String doc_list){
        boolean flag = documentService.delSomeDocs(StringUtil.stringToInt(doc_list));
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @RequestMapping(value="/2/uploadx",method=RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);
        String fileName = file.getOriginalFilename();
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        file.transferTo(dir);
        System.out.println(fileName);
        String url = FileUpload.upload(path+ "/" + fileName);
        return url;
    }
}
