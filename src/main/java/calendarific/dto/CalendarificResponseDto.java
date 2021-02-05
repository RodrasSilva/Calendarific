package calendarific.dto;

public class CalendarificResponseDto {
    private final MetaDto meta;
    private final ResponseDto response;

    public CalendarificResponseDto(MetaDto meta, ResponseDto response) {
        this.meta = meta;
        this.response = response;
    }

    public MetaDto getMeta() {
        return meta;
    }

    public ResponseDto getResponse() {
        return response;
    }
}
