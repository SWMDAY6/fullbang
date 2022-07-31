package day6.fullbang.service;

import static day6.fullbang.utility.MarketPriceUtil.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import day6.fullbang.domain.Product;
import day6.fullbang.dto.response.MarketPriceDto;
import day6.fullbang.dto.response.PriceInfoDto;
import day6.fullbang.repository.ProductRepository;
import day6.fullbang.utility.MarketPriceUtil;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    public List<Product> findByPlaceName(String placeName, String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return productRepository.findByPlaceName(placeName, localDate);
    }

    public List<Product> findByPlaceId(Long placeId, String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return productRepository.findByPlaceId(placeId, localDate);
    }

    public MarketPriceDto getMarketPrice(List<PriceInfoDto> priceInfos) {

        MarketPriceDto marketPriceDto = new MarketPriceDto();

        List<Double> prices = new ArrayList<>();

        for (PriceInfoDto priceInfoDto : priceInfos) {
            prices.add(Double.valueOf(priceInfoDto.getPrice()));
        }

        Double mean = getMean(prices);
        Double offsetOfConfidenceInterval = getOffsetOfConfidenceInterval(prices);

        marketPriceDto.setMean(mean);
        marketPriceDto.setStartPointOfConfidenceInterval(mean - offsetOfConfidenceInterval);
        marketPriceDto.setEndPointOfConfidenceInterval(mean + offsetOfConfidenceInterval);
        marketPriceDto.setConfidenceLevel(0.95D); // TODO refactor

        return marketPriceDto;
    }
}
