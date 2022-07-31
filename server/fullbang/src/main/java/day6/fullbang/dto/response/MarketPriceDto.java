package day6.fullbang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarketPriceDto {

    private String region1DepthName;
    private String region2DepthName;
    private String region3DepthName;
    private String addressCode;

    private Double mean;
    private Double startPointOfConfidenceInterval;
    private Double endPointOfConfidenceInterval;
    private Double confidenceLevel;
}
