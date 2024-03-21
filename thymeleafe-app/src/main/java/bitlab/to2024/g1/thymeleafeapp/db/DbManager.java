package bitlab.to2024.g1.thymeleafeapp.db;

import bitlab.to2024.g1.thymeleafeapp.model.Phone;
import lombok.Getter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    @Getter
    private static List<Phone> phones = new ArrayList<>();
    private static Long id = 7L;

    static {
        phones.add(new Phone(1L, "Samsung", 1234567, "124 Gb", "ДОРОГО"));
        phones.add(new Phone(2L, "Iphone 13 Pro", 2234567, "124 Gb", "ДОРОГО"));
        phones.add(new Phone(3L, "Iphone 11", 3234567, "124 Gb", "ПРИЕМЛЕМО"));
        phones.add(new Phone(4L, "Samsung", 4234567, "124 Gb", "ДОРОГО"));
        phones.add(new Phone(5L, "Samsung", 5234567, "124 Gb", "ДОРОГО"));
        phones.add(new Phone(6L, "Samsung", 6234567, "124 Gb", "ДОРОГО"));
    }

    public static Phone save(Phone phone){
//        if ("Samsung".equals(phone.getName())){
//            throw new RuntimeException("UNIQUE VALUE");
//        }
        phone.setId(id);
        phones.add(phone);
        id++;
        return phone;
    }
}
