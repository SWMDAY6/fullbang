package day6.fullbang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import day6.fullbang.domain.Place;
import day6.fullbang.domain.Product;
import day6.fullbang.dto.response.MarketPriceDto;
import day6.fullbang.dto.response.PriceInfoDto;
import day6.fullbang.service.PlaceService;
import day6.fullbang.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MarketPriceController {

    private final ProductService productService;
    private final PlaceService placeService;

    @GetMapping("/price/{id}")
    @ResponseBody
    public PriceInfoDto getPriceByProductId(@PathVariable(name = "id") Long id) {
        return productService.findOne(id).toPriceInfoDto();
    }

    @GetMapping("/price")
    @ResponseBody
    public List<PriceInfoDto> getPriceByPlaceName(@RequestParam(name = "place_name") String placeName,
        @RequestParam String date) {

        List<Product> products = productService.findByPlaceName(placeName, date);
        List<PriceInfoDto> priceInfos = new ArrayList<>();

        for (Product product : products) {
            priceInfos.add(product.toPriceInfoDto());
        }

        return priceInfos;
    }

    @GetMapping("/price")
    @ResponseBody
    public List<PriceInfoDto> getPriceByAddressCode(@RequestParam(name = "address_code_head") String addressCodeHead,
        @RequestParam String date) {

        List<Place> places = placeService.findByAddressCode(addressCodeHead);
        List<PriceInfoDto> priceInfos = new ArrayList<>();

        for (Place place : places) {
            productService.findByPlaceId(place.getId(), date)
                .forEach(product -> priceInfos.add(product.toPriceInfoDto()));
        }

        return priceInfos;
    }

    @GetMapping("/market-price")
    @ResponseBody
    public MarketPriceDto getMarketPrice(@RequestParam(name = "address_code_head") String addressCodeHead,
        @RequestParam String date) {

        List<Place> places = placeService.findByAddressCode(addressCodeHead);
        List<PriceInfoDto> priceInfos = new ArrayList<>();

        for (Place place : places) {
            productService.findByPlaceId(place.getId(), date)
                .forEach(product -> priceInfos.add(product.toPriceInfoDto()));
        }

        // TODO refactor above duplicate code with getPriceByAddressCode()

        return productService.getMarketPrice(priceInfos); // TODO implement getMarketPrice()
    }
}
