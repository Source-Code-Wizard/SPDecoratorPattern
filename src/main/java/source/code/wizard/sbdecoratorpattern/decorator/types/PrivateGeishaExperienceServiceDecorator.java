package source.code.wizard.sbdecoratorpattern.decorator.types;

import org.springframework.stereotype.Service;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;

@Service
public class PrivateGeishaExperienceServiceDecorator extends TripServiceDecoratorBase {
    @Override
    public double getPrice() {
        return tripService.getPrice() + calculateGeishaExperiencePrice();
    }

    private double calculateGeishaExperiencePrice() {
        // Private tea ceremony and dinner with Geisha in Gion, Kyoto
        // Implement logic
        return 2000f;
    }

    @Override
    public String getDescription() {
        return tripService.getDescription() + " + Exclusive Private Geisha Experience in Kyoto";
    }

    @Override
    public TripDecoratorType getType() {
        return TripDecoratorType.GEISHA_EXPERIENCE;
    }
}
