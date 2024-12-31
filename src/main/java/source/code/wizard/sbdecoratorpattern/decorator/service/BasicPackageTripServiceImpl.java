package source.code.wizard.sbdecoratorpattern.decorator.service;

import org.springframework.stereotype.Service;

@Service("BasicPackageTripService")
public class BasicPackageTripServiceImpl implements TripService {
    @Override
    public double getPrice() {
        return 3000f;
    }

    @Override
    public String getDescription() {
        return "This is the standard package for traveling to Japan";
    }
}
