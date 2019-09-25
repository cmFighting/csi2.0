package com.ynu.mapper;

import com.ynu.pojo.DocumentWithUser;
import com.ynu.pojo.Documentinf;
import org.apache.ibatis.annotations.Param;

import javax.swing.text.Document;
import java.util.List;

public interface DocumentinfMapper {
    List<Documentinf> getAllDocumentinf();

    void addDocument(Documentinf documentinf);

    void deleteDocumentById(@Param("document_id") int document_id);

    void updateDocument(Documentinf documentinf);

    List<DocumentWithUser> getAllDocumentWithUsers();

    Documentinf selectDocumentById(@Param("document_id") int document_id);

    List<DocumentWithUser> selectDocumentByTitle(@Param("title") String title);

    void deleteSomeDoc(@Param("list") int[] idList);

}
