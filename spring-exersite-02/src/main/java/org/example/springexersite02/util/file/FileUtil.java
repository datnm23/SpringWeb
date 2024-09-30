package org.example.springexersite02.util.file;

import com.google.gson.*;
import org.example.springexersite02.constant.DateTimeConstant;
import org.example.springexersite02.util.StringUtil;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil<T> implements DataWritable<T>, DataReadable<T> {

    private static final Gson gson = new GsonBuilder()
            .serializeNulls()
            .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                @Override
                public JsonElement serialize(LocalDate date, Type type, JsonSerializationContext jsonSerializationContext) {
                    return new JsonPrimitive(date.format(DateTimeConstant.DATE_FORMATTER));
                }
            })
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeConstant.DATE_FORMATTER);
                }
            })
            .create();

    @Override
    public void writeDataToFile(List<T> data, String fileName) {
    }

    @Override
    public List<T> readDataFromFile(String fileName, Class<T[]> clazz) throws IOException {
        if (StringUtil.isNullOrEmpty(fileName)) {
            return null;
        }
        String absolutePath = new ClassPathResource(fileName).getFile().getAbsolutePath();
        try (FileReader reader = new FileReader(absolutePath)) {
            T[] dataArr = gson.fromJson(reader, clazz);
            return dataArr == null ? null : new ArrayList<>(Arrays.asList(dataArr));
        }
    }
}
