package source.code.wizard.sbdecoratorpattern.decorator.types;

import org.springframework.stereotype.Service;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;

@Service
public class Michelin3StarDiningServiceDecorator extends TripServiceDecoratorBase {
    @Override
    public double getPrice() {
        return tripService.getPrice() + calculateMichelinDiningPrice();
    }

    private double calculateMichelinDiningPrice() {
        // Reservations at top Michelin-starred restaurants
        // Implement logic
        return 3000f;
    }

    @Override
    public String getDescription() {
        return tripService.getDescription() + " + Michelin 3-Star Restaurant Tour (Including Sukiyabashi Jiro)";
    }

    @Override
    public TripDecoratorType getType() {
        return TripDecoratorType.MICHELIN_DINING;
    }
}
