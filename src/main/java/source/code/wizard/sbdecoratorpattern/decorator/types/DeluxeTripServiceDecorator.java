package source.code.wizard.sbdecoratorpattern.decorator.types;

import org.springframework.stereotype.Service;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;

@Service
public class DeluxeTripServiceDecorator extends TripServiceDecoratorBase {
    @Override
    public double getPrice() {
        return tripService.getPrice() + calculatePriceForDeluxePackage();
    }

    private double calculatePriceForDeluxePackage() {
        // Put here your service logic
        return 10000f;
    }

    @Override
    public String getDescription() {
        return "Deluxe Package (First Class Travel, accommodation in the tallest skyscraper of Japan)";
    }

    @Override
    public TripDecoratorType getType() {
        return TripDecoratorType.DELUXE;
    }
}
