package com.ynu.service;

import com.ynu.pojo.DocumentWithUser;
import com.ynu.pojo.Documentinf;

import javax.swing.text.Document;
import java.util.List;

public interface DocumentService {
    List<DocumentWithUser> getAllDocuments();

    List<DocumentWithUser> getDocumentByTitle(String title);

    Documentinf getDocumentById(int document_id);

    boolean addDocument(Documentinf documentinf);

    boolean deleteDocument(int document_id);

    boolean editDocument(Documentinf documentinf);

    boolean delSomeDocs(int[] list);

}
