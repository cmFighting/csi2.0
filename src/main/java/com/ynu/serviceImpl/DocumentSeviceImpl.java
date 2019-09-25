package com.ynu.serviceImpl;

import com.ynu.mapper.DocumentinfMapper;
import com.ynu.pojo.DocumentWithUser;
import com.ynu.pojo.Documentinf;
import com.ynu.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentSeviceImpl implements DocumentService {

    @Autowired
    private DocumentinfMapper documentinfMapper;

    @Override
    public List<DocumentWithUser> getAllDocuments() {
        return documentinfMapper.getAllDocumentWithUsers();
    }

    @Override
    public List<DocumentWithUser> getDocumentByTitle(String title) {
        return documentinfMapper.selectDocumentByTitle(title);
    }

    @Override
    public Documentinf getDocumentById(int document_id) {
        return documentinfMapper.selectDocumentById(document_id);
    }

    @Override
    public boolean addDocument(Documentinf documentinf) {
        documentinfMapper.addDocument(documentinf);
        return true;
    }

    @Override
    public boolean deleteDocument(int document_id) {
        documentinfMapper.deleteDocumentById(document_id);
        return true;
    }

    @Override
    public boolean editDocument(Documentinf documentinf) {
        documentinfMapper.updateDocument(documentinf);
        return true;
    }

    @Override
    public boolean delSomeDocs(int[] list) {
        documentinfMapper.deleteSomeDoc(list);
        return true;
    }
}
