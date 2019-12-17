package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoshareacademy.menu.EventsPrinter.printEvents;

public class EventsByOrganizer {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    // to zniknie
    static String promotedOrganizer1Builder = "1. Gdański Archipelag Kultury";
    static String promotedOrganizer2Builder = "2. Wojewódzka i Miejska Biblioteka Publiczna w Gdańsku";
    static String promotedOrganizer3Builder = "3. Miejski Teatr MINIATURA";
    static String promotedOrganizer9Builder = "9. Wyjście do poprzedniego menu";


    static void showByOrganizer() {
        FilterRepository filterRepository = new FilterRepository();
        int returnCheckInt = 0;

        while (returnCheckInt != 9) {
            MenuBuilder.printPromotedOrganizers();

            switch (ChoiceGetter.getChoice()) {
                case 1:
                    printEvents(filterRepository.filterAllOrganisers("Gdański Archipelag Kultury"));
                    stdout.info("\n");
                    break;
                case 2:
                    printEvents(filterRepository.filterAllOrganisers("Wojewódzka i Miejska Biblioteka Publiczna w Gdańsku"));
                    stdout.info("\n");
                    break;
                case 3:

                    printEvents(filterRepository.filterAllOrganisers("Miejski Teatr MINIATURA"));
                    stdout.info("\n");
                    break;
                case 9:
                    ScreenCleaner.cleanConsoleWindow();
                    stdout.info("        POWRÓT DO WYŻSZEGO POZIOMU       \n\n");
                    returnCheckInt = 9;
                    break;
                case 0:
                    break;
                default:
                    MenuBuilder.printNumberInactiveInfo();
            }
        }
    }
}