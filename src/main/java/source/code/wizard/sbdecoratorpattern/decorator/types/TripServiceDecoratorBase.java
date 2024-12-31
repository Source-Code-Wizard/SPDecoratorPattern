package source.code.wizard.sbdecoratorpattern.decorator.types;

import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;
import source.code.wizard.sbdecoratorpattern.decorator.service.TripService;

abstract public class TripServiceDecoratorBase implements TripService {
    protected TripService tripService;

    public abstract TripDecoratorType getType();

    public void setTripService(final TripService tripService) {
        this.tripService = tripService;
    }
}
