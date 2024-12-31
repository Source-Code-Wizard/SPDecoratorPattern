package source.code.wizard.sbdecoratorpattern.decorator.service;

import source.code.wizard.sbdecoratorpattern.decorator.TripInfoDTO;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;

import java.util.Set;

public interface TripExpensesCalcService {
    TripInfoDTO getPriceAndDescription(final Set<TripDecoratorType> decoratorTypesSet);
}
