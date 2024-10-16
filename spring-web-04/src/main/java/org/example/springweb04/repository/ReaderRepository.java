package org.example.springweb04.repository;

import org.example.springweb04.entity.Reader;
import org.example.springweb04.model.request.ReaderUpdateRequest;
import org.example.springweb04.util.file.FileUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReaderRepository {

    private final FileUtil<Reader> readerFileUtil = new FileUtil<>();
    private final String fileName = "db/readers.json";

    public List<Reader> getAll() {
        try {
            return readerFileUtil.readDataFromFile(fileName, Reader[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Reader reader) {
        List<Reader> readers = getAll();

        int maxId = 0;
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getId() > maxId) {
                maxId = readers.get(i).getId();
            }
        }
        reader.setId(maxId + 1);

        readers.add(reader);

        readerFileUtil.writeDataToFile(readers, fileName);
    }

    public void delete(int id) {
        List<Reader> readers = getAll();
        readers.removeIf(reader -> reader.getId() == id);
        readerFileUtil.writeDataToFile(readers, fileName);
    }

    public Reader getReader(int id) {
        List<Reader> readers = getAll();
        for (Reader reader : readers) {
            if (reader.getId() == id) {
                return reader;
            }
        }
        return null;
    }

    public void updateReader(ReaderUpdateRequest readerUpdateRequest) {
        List<Reader> readers = getAll();
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getId() == readerUpdateRequest.getId()) {
                readers.get(i).setName(readerUpdateRequest.getName());
                readers.get(i).setAddress(readerUpdateRequest.getAddress());
                readers.get(i).setEmail(readerUpdateRequest.getEmail());
                readers.get(i).setPhone(readerUpdateRequest.getPhone());
                break;
            }
        }
        readerFileUtil.writeDataToFile(readers, fileName);
    }
}
