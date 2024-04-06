package bitlab.to2024.g1.thymeleafeapp.config;

import bitlab.to2024.g1.thymeleafeapp.db.DbManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Monitoring {
    /**
     * пример реализации Configuration
     */
    @Scheduled(fixedDelay = 5000)
    public void monitoring(){
        DbManager.getPhones()
                .stream().anyMatch(phone -> {
                    if(phone.getPrice() > 1000000){
                        System.out.println("UNIQUE PHONE");
                    }
                    return false;
                });
    }
}
