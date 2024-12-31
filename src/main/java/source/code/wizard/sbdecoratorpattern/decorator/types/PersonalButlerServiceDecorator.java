package source.code.wizard.sbdecoratorpattern.decorator.types;

import org.springframework.stereotype.Service;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;

@Service
public class PersonalButlerServiceDecorator extends TripServiceDecoratorBase {
    @Override
    public double getPrice() {
        return tripService.getPrice() + calculateButlerServicePrice();
    }

    private double calculateButlerServicePrice() {
        // 24/7 personal butler and concierge service
        // Implement logic
        return 4000f;
    }

    @Override
    public String getDescription() {
        return tripService.getDescription() + " + 24/7 Personal Butler and Concierge Service";
    }

    @Override
    public TripDecoratorType getType() {
        return TripDecoratorType.PERSONAL_BUTLER;
    }
}
