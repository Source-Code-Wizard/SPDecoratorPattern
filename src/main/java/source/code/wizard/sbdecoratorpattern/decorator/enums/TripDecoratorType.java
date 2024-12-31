package source.code.wizard.sbdecoratorpattern.decorator.enums;

import lombok.Getter;

@Getter
public enum TripDecoratorType {
    BASIC("Basic Package"),
    DELUXE("Deluxe Package"),
    SUPERCAR_RENTAL("Supercar Experience"),
    GEISHA_EXPERIENCE("Geisha Experience"),
    MICHELIN_DINING("Michelin Dining"),
    HELICOPTER_TOURS("Helicopter Tours"),
    PERSONAL_BUTLER("Butler Service");

    private final String name;
    TripDecoratorType(String name) {
        this.name = name;
    }

}