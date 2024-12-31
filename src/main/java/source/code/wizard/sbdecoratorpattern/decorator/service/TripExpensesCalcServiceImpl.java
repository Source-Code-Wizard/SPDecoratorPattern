package source.code.wizard.sbdecoratorpattern.decorator.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import source.code.wizard.sbdecoratorpattern.decorator.TripInfoDTO;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;
import source.code.wizard.sbdecoratorpattern.decorator.types.TripServiceDecoratorBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        TripServiceDecoratorBase tripServiceDecorator = null;
        for (int decoratorTypeIndex = 0; decoratorTypeIndex < decoratorTypesArray.size(); decoratorTypeIndex++) {
            tripServiceDecorator = decoratorsMap.get(decoratorTypesArray.get(decoratorTypeIndex));
            if (decoratorTypeIndex == 0) {
                tripServiceDecorator.setTripService(standardTripService);
            } else {
                TripServiceDecoratorBase previousTripServiceDecorator = decoratorsMap.get(decoratorTypesArray.get(decoratorTypeIndex - 1));
                tripServiceDecorator.setTripService(previousTripServiceDecorator);
            }
        }
        if (tripServiceDecorator != null)
            return new TripInfoDTO(tripServiceDecorator.getPrice(), tripServiceDecorator.getDescription());
        else
            return new TripInfoDTO(0.0, " ");
    }
}
