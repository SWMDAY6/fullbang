package day6.fullbang.utility;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.List;

public class MarketPriceUtil {

    private static final Double standardCriticalValue = 1.96D;

    public static Double getMean(List<Double> prices) {

        Double sum = 0D;

        for (Double price : prices) {
            sum += price;
        }

        return sum / prices.size();
    }

    public static Double getOffsetOfConfidenceInterval(List<Double> prices) {
        return standardCriticalValue * getStandardDeviation(prices) / sqrt(prices.size());
    }

    public static Double getStandardDeviation(List<Double> values) {

        List<Double> squaredValues = new ArrayList<>();
        values.forEach(v -> squaredValues.add(pow(v, 2)));

        return sqrt(getMean(squaredValues) - pow(getMean(values), 2));
    }
}
