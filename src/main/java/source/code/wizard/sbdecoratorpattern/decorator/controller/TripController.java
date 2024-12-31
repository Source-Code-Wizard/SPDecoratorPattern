package source.code.wizard.sbdecoratorpattern.decorator.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import source.code.wizard.sbdecoratorpattern.decorator.TripInfoDTO;
import source.code.wizard.sbdecoratorpattern.decorator.enums.TripDecoratorType;
import source.code.wizard.sbdecoratorpattern.decorator.service.TripExpensesCalcService;
import source.code.wizard.sbdecoratorpattern.decorator.service.TripExpensesCalcServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/trips")
public class TripController {

    private final TripExpensesCalcService tripExpensesCalcService;

    public TripController(TripExpensesCalcServiceImpl tripExpensesCalcService) {
        this.tripExpensesCalcService = tripExpensesCalcService;
    }

    @PostMapping(value = "/getPriceAndDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TripInfoDTO> getPriceAndDesc(@RequestBody Set<TripDecoratorType> decoratorTypeList) {
        return ResponseEntity.
                ok(tripExpensesCalcService.getPriceAndDescription(decoratorTypeList));
    }
}
