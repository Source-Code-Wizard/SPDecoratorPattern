package source.code.wizard.sbdecoratorpattern.decorator.types;

import org.springframework.stereotype.Service;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;

@Service
public class SupercarRentalServiceDecorator extends TripServiceDecoratorBase {
    @Override
    public double getPrice() {
        return tripService.getPrice() + calculateSupercarRentalPrice();
    }

    private double calculateSupercarRentalPrice() {
        // Premium Japanese supercars like Nissan GT-R or Lexus LFA
        return 5000f;
    }

    @Override
    public String getDescription() {
        return tripService.getDescription() + " + Premium Supercar Rental (GT-R, LFA, NSX available)";
    }

    @Override
    public TripDecoratorType getType() {
        return TripDecoratorType.SUPERCAR_RENTAL;
    }
}
