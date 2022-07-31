package day6.fullbang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MarketPriceDto {

    private final String region1DepthName;
    private final String region2DepthName;
    private final String region3DepthName;
    private final String addressCode;

    private final Integer mean;
    private final Integer startPointOfConfidenceInterval;
    private final Integer endPointOfConfidenceInterval;
    private final Integer meanOfConfidenceInterval;
}
