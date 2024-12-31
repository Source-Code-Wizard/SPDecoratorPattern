package source.code.wizard.sbdecoratorpattern.decorator.types;

import org.springframework.stereotype.Service;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;

@Service
public class PrivateHelicopterToursServiceDecorator extends TripServiceDecoratorBase {
    @Override
    public double getPrice() {
        return tripService.getPrice() + calculateHelicopterToursPrice();
    }

    private double calculateHelicopterToursPrice() {
        // Private helicopter tours of Mt. Fuji and major cities
        return 7000f;
    }

    @Override
    public String getDescription() {
        return tripService.getDescription() + " + Private Helicopter Tours (Mt. Fuji, Tokyo, Osaka)";
    }

    @Override
    public TripDecoratorType getType() {
        return TripDecoratorType.HELICOPTER_TOURS;
    }
}
