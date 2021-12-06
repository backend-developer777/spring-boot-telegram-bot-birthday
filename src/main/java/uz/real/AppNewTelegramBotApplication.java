package uz.real;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import uz.real.bot.MyConfigurationBot;

@SpringBootApplication
@EnableScheduling
public class AppNewTelegramBotApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new MyConfigurationBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        SpringApplication.run(AppNewTelegramBotApplication.class, args);
    }

}
