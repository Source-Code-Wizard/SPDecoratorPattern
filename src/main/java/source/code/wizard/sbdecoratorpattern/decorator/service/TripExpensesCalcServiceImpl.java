package source.code.wizard.sbdecoratorpattern.decorator.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import source.code.wizard.sbdecoratorpattern.decorator.TripInfoDTO;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;
import source.code.wizard.sbdecoratorpattern.decorator.types.TripServiceDecoratorBase;

import java.util.*;

@Service
public class TripExpensesCalcServiceImpl implements TripExpensesCalcService {
    private Map<TripDecoratorType, TripServiceDecoratorBase> decoratorsMap;
    private final @Qualifier("BasicPackageTripService") TripService standardTripService;

    TripExpensesCalcServiceImpl(final Set<TripServiceDecoratorBase> decoratorsSet, final @Qualifier("BasicPackageTripService") TripService standardTripService) {
        this.standardTripService = standardTripService;
        decoratorsMap = new HashMap<>();
        decoratorsSet.forEach(decorator -> {
            decoratorsMap.put(decorator.getType(), decorator);
        });
    }

    public TripInfoDTO getPriceAndDescription(final Set<TripDecoratorType> decoratorTypesSet) {

        final ArrayList<TripDecoratorType> decoratorTypesArray = new ArrayList<>(decoratorTypesSet);

        final TripServiceDecoratorBase tripServiceDecorator = buildDecoratorChain(decoratorTypesArray);

        if (tripServiceDecorator != null)
            return new TripInfoDTO(tripServiceDecorator.getPrice(), tripServiceDecorator.getDescription());
        else
            return new TripInfoDTO(0.0, " ");
    }

    private TripServiceDecoratorBase buildDecoratorChain(final List<TripDecoratorType> decoratorTypes) {
        TripServiceDecoratorBase tripServiceDecorator = null;
        for (int decoratorTypeIndex = 0; decoratorTypeIndex < decoratorTypes.size(); decoratorTypeIndex++) {
            tripServiceDecorator = decoratorsMap.get(decoratorTypes.get(decoratorTypeIndex));
            if (decoratorTypeIndex == 0) {
                tripServiceDecorator.setTripService(standardTripService);
            } else {
                TripServiceDecoratorBase previousTripServiceDecorator = decoratorsMap.get(decoratorTypes.get(decoratorTypeIndex - 1));
                tripServiceDecorator.setTripService(previousTripServiceDecorator);
            }
        }
        return tripServiceDecorator;
    }
}
