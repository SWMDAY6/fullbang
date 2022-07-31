package day6.fullbang.dto.response;


import day6.fullbang.domain.Address;
import day6.fullbang.domain.Place;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaceInfoDto {
	private String placeName;
	private String placeType;
	private String addressFullName;
	private String region1DepthName;
	private String region2DepthName;
	private String region3DepthName;
	private String addressCode;

	public PlaceInfoDto(Place place, Address address) {
		this(address);
		this.placeName=place.getName();
		this.placeType=place.getType();
	}
	public PlaceInfoDto(Address address){
		this.addressFullName = address.getAddressFullName();
		this.region1DepthName = address.getRegion1DepthName();
		this.region2DepthName = address.getRegion2DepthName();
		this.region3DepthName = address.getRegion3DepthName();
		this.addressCode = address.getAddressCode();
	}
}
