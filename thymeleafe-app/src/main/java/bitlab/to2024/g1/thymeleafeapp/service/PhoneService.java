package bitlab.to2024.g1.thymeleafeapp.service;

import bitlab.to2024.g1.thymeleafeapp.db.DbManager;
import bitlab.to2024.g1.thymeleafeapp.exception.PhoneCreateException;
import bitlab.to2024.g1.thymeleafeapp.model.Phone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class PhoneService {
    public List<Phone> getSortedPhones(){
        List<Phone> phones = DbManager.getPhones();
        return phones.stream()
                .sorted(Comparator.comparing(Phone::getPrice))
                .toList();
    }

    /**
     * определяет статус и добавляет в статус
     * @param phone - данные из формы
     */
    public void addPhone(Phone phone){
        log.info("STARTED creation phone name: {}, price: {}", phone.getName(), phone.getPrice());

        // определить статус
        String status = defineStatus(phone);
        phone.setStatus(status);

        // добавить в базу
        try {
            Phone savedPhone = DbManager.save(phone);
            log.info("SUCCESSFULLY creation phone ID: {}", savedPhone.getId());
        } catch (Exception e) {
            log.error("FAILED creation phone name: {}, price: {}", phone.getName(), phone.getPrice());
            throw new PhoneCreateException("FAILED", e);
        }
    }

    /**
     * метод для определения статуса по цене
     * @param phone - данные из формы
     * @return статус
     */
    private String defineStatus(Phone phone){
        if(phone.getPrice()>500000){
            return "Expensive";
        } else if (phone.getPrice() > 400000) {
            return "Acceptable";
        } else {
            return "Cheap";
        }
    }
}
