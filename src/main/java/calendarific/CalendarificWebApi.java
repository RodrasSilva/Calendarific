package calendarific;

import calendarific.dto.CalendarificResponseDto;
import calendarific.dto.HolidaysDto;
import com.google.gson.Gson;
import util.requests.Request;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class CalendarificWebApi {

    private static final String CALENDARIFIC_API_KEY = "3f7a769491060037a7f77551c391c1f3d146bc13";
    private static final String CALENDARIFIC_SEARCH =
            "https://calendarific.com/api/v2/holidays/?&api_key=" + CALENDARIFIC_API_KEY + "&country=%s&year=%s";
    private static HashMap<String, String> acronyms = new HashMap<>();
    private static boolean isAcronymsFilled = false;
    private final Request request;
    private final Gson gson;

    public CalendarificWebApi(Request request) {
        this(request, new Gson());
    }

    public CalendarificWebApi(Request request, Gson gson) {
        if (!isAcronymsFilled) {
            fillAcronyms();
        }
        this.request = request;
        this.gson = gson;
    }

    public CompletableFuture<HolidaysDto[]> getCalendar(String country, String year) {
        String acr = null;
        if (country == null || year == null || (acr = acronyms.get(country.toLowerCase())) == null) {
            return CompletableFuture.completedFuture(new HolidaysDto[0]);
        }
        String url = String.format(CALENDARIFIC_SEARCH, acr, year);
        return request.getLines(url).thenApply(
                urlBody -> {
                    CalendarificResponseDto response = gson.fromJson(urlBody, CalendarificResponseDto.class);
                    return response.getResponse().getHolydays();
                });
    }

    private static void fillAcronyms() {
        acronyms.put("afghanistan", "AF");
        acronyms.put("albania", "AL");
        acronyms.put("algeria", "DZ");
        acronyms.put("american samoa", "AS");
        acronyms.put("andorra", "AD");
        acronyms.put("angola", "AO");
        acronyms.put("anguilla", "AI");
        acronyms.put("antigua and barbuda", "AG");
        acronyms.put("argentina", "AR");
        acronyms.put("armenia", "AM");
        acronyms.put("aruba", "AW");
        acronyms.put("australia", "AU");
        acronyms.put("austria", "AT");
        acronyms.put("azerbaijan", "AZ");
        acronyms.put("bahrain", "BH");
        acronyms.put("bangladesh", "BD");
        acronyms.put("barbados", "BB");
        acronyms.put("belarus", "BY");
        acronyms.put("belgium", "BE");
        acronyms.put("belize", "BZ");
        acronyms.put("benin", "BJ");
        acronyms.put("bermuda", "BM");
        acronyms.put("bhutan", "BT");
        acronyms.put("bolivia", "BO");
        acronyms.put("bosnia and herzegovina", "BA");
        acronyms.put("botswana", "BW");
        acronyms.put("brazil", "BR");
        acronyms.put("british virgin islands", "VG");
        acronyms.put("brunei", "BN");
        acronyms.put("bulgaria", "BG");
        acronyms.put("burkina faso", "BF");
        acronyms.put("burundi", "BI");
        acronyms.put("cabo verde", "CV");
        acronyms.put("cambodia", "KH");
        acronyms.put("cameroon", "CM");
        acronyms.put("canada", "CA");
        acronyms.put("cayman islands", "KY");
        acronyms.put("central african republic", "CF");
        acronyms.put("chad", "TD");
        acronyms.put("chile", "CL");
        acronyms.put("china", "CN");
        acronyms.put("colombia", "CO");
        acronyms.put("comoros", "KM");
        acronyms.put("congo", "CG");
        acronyms.put("congo democratic republic", "CD");
        acronyms.put("cook islands", "CK");
        acronyms.put("costa rica", "CR");
        acronyms.put("cote d'ivoire", "CI");
        acronyms.put("croatia", "HR");
        acronyms.put("cuba", "CU");
        acronyms.put("curaçao", "CW");
        acronyms.put("cyprus", "CY");
        acronyms.put("czech republic", "CZ");
        acronyms.put("denmark", "DK");
        acronyms.put("djibouti", "DJ");
        acronyms.put("dominica", "DM");
        acronyms.put("dominican republic", "DO");
        acronyms.put("east timor", "TL");
        acronyms.put("ecuador", "EC");
        acronyms.put("egypt", "EG");
        acronyms.put("el salvador", "SV");
        acronyms.put("equatorial guinea", "GQ");
        acronyms.put("eritrea", "ER");
        acronyms.put("estonia", "EE");
        acronyms.put("ethiopia", "ET");
        acronyms.put("falkland islands", "FK");
        acronyms.put("faroe islands", "FO");
        acronyms.put("fiji", "FJ");
        acronyms.put("finland", "FI");
        acronyms.put("france", "FR");
        acronyms.put("french polynesia", "PF");
        acronyms.put("gabon", "GA");
        acronyms.put("gambia", "GM");
        acronyms.put("georgia", "GE");
        acronyms.put("germany", "DE");
        acronyms.put("ghana", "GH");
        acronyms.put("gibraltar", "GI");
        acronyms.put("greece", "GR");
        acronyms.put("greenland", "GL");
        acronyms.put("grenada", "GD");
        acronyms.put("guam", "GU");
        acronyms.put("guatemala", "GT");
        acronyms.put("guernsey", "GG");
        acronyms.put("guinea", "GN");
        acronyms.put("guinea-bissau", "GW");
        acronyms.put("guyana", "GY");
        acronyms.put("haiti", "HT");
        acronyms.put("holy see (vatican city)", "VA");
        acronyms.put("honduras", "HN");
        acronyms.put("hong kong", "HK");
        acronyms.put("hungary", "HU");
        acronyms.put("iceland", "IS");
        acronyms.put("india", "IN");
        acronyms.put("indonesia", "ID");
        acronyms.put("iran", "IR");
        acronyms.put("iraq", "IQ");
        acronyms.put("ireland", "IE");
        acronyms.put("isle of man", "IM");
        acronyms.put("israel", "IL");
        acronyms.put("italy", "IT");
        acronyms.put("jamaica", "JM");
        acronyms.put("japan", "JP");
        acronyms.put("jersey", "JE");
        acronyms.put("jordan", "JO");
        acronyms.put("kazakhstan", "KZ");
        acronyms.put("kenya", "KE");
        acronyms.put("kiribati", "KI");
        acronyms.put("kosovo", "XK");
        acronyms.put("kuwait", "KW");
        acronyms.put("kyrgyzstan", "KG");
        acronyms.put("laos", "LA");
        acronyms.put("latvia", "LV");
        acronyms.put("lebanon", "LB	");
        acronyms.put("lesotho", "LS");
        acronyms.put("liberia", "LR");
        acronyms.put("libya", "LY");
        acronyms.put("liechtenstein", "LI");
        acronyms.put("lithuania", "LT");
        acronyms.put("luxembourg", "LU");
        acronyms.put("macau", "MO");
        acronyms.put("madagascar", "MG");
        acronyms.put("malawi", "MW");
        acronyms.put("malaysia", "MY");
        acronyms.put("maldives", "MV");
        acronyms.put("mali", "ML");
        acronyms.put("malta", "MT");
        acronyms.put("marshall islands", "MH");
        acronyms.put("martinique", "MQ");
        acronyms.put("mauritania", "MR");
        acronyms.put("mauritius", "MU");
        acronyms.put("mayotte", "YT");
        acronyms.put("mexico", "MX");
        acronyms.put("micronesia", "FM");
        acronyms.put("moldova", "MD");
        acronyms.put("monaco", "MC");
        acronyms.put("mongolia", "MN");
        acronyms.put("montenegro", "ME");
        acronyms.put("montserrat", "MS");
        acronyms.put("morocco", "MA");
        acronyms.put("mozambique", "MZ");
        acronyms.put("myanmar", "MM");
        acronyms.put("namibia", "NA");
        acronyms.put("nauru", "NR");
        acronyms.put("nepal", "NP");
        acronyms.put("netherlands", "NL");
        acronyms.put("new caledonia", "NC");
        acronyms.put("new zealand", "NZ");
        acronyms.put("nicaragua", "NI");
        acronyms.put("niger", "NE");
        acronyms.put("nigeria", "NG");
        acronyms.put("north korea", "KP");
        acronyms.put("north macedonia", "MK");
        acronyms.put("northern mariana islands", "MP");
        acronyms.put("norway", "NO");
        acronyms.put("oman", "OM");
        acronyms.put("pakistan", "PK");
        acronyms.put("palau", "PW");
        acronyms.put("panama", "PA");
        acronyms.put("papua new guinea", "PG");
        acronyms.put("paraguay", "PY");
        acronyms.put("peru", "PE");
        acronyms.put("philippines", "PH");
        acronyms.put("poland", "PL");
        acronyms.put("portugal", "PT");
        acronyms.put("puerto rico", "PR");
        acronyms.put("qatar", "QA");
        acronyms.put("reunion", "RE");
        acronyms.put("romania", "RO");
        acronyms.put("russia", "RU");
        acronyms.put("rwanda", "RW");
        acronyms.put("saint helena", "SH");
        acronyms.put("saint kitts and nevis", "KN");
        acronyms.put("saint lucia", "LC");
        acronyms.put("saint martin", "MF");
        acronyms.put("saint pierre and miquelon", "PM");
        acronyms.put("saint vincent and the grenadines", "VC");
        acronyms.put("samoa", "WS");
        acronyms.put("san marino", "SM");
        acronyms.put("sao tome and principe", "ST");
        acronyms.put("saudi arabia", "SA");
        acronyms.put("senegal", "SN");
        acronyms.put("serbia", "RS");
        acronyms.put("seychelles", "SC");
        acronyms.put("sierra leone", "SL");
        acronyms.put("singapore", "SG");
        acronyms.put("sint maarten", "SX");
        acronyms.put("slovakia", "SK");
        acronyms.put("slovenia", "SI");
        acronyms.put("solomon islands", "SB");
        acronyms.put("somalia", "SO");
        acronyms.put("south africa", "ZA");
        acronyms.put("south korea", "KR");
        acronyms.put("south sudan", "SS");
        acronyms.put("spain", "ES");
        acronyms.put("sri lanka", "LK");
        acronyms.put("st. barts", "BL");
        acronyms.put("sudan", "SD");
        acronyms.put("suriname", "SR");
        acronyms.put("sweden", "SE");
        acronyms.put("switzerland", "CH");
        acronyms.put("syria", "SY");
        acronyms.put("taiwan", "TW");
        acronyms.put("tajikistan", "TJ");
        acronyms.put("tanzania", "TZ");
        acronyms.put("thailand", "TH");
        acronyms.put("the bahamas", "BS");
        acronyms.put("togo", "TG");
        acronyms.put("tonga", "TO");
        acronyms.put("trinidad and tobago", "TT");
        acronyms.put("tunisia", "TN");
        acronyms.put("turkey", "TR");
        acronyms.put("turkmenistan", "TM");
        acronyms.put("turks and caicos islands", "TC");
        acronyms.put("tuvalu", "TV");
        acronyms.put("us virgin islands", "VI");
        acronyms.put("uganda", "UG");
        acronyms.put("ukraine", "UA");
        acronyms.put("united arab emirates", "AE");
        acronyms.put("united kingdom", "GB");
        acronyms.put("united states", "US");
        acronyms.put("uruguay", "UY");
        acronyms.put("uzbekistan", "UZ");
        acronyms.put("vanuatu", "VU");
        acronyms.put("venezuela", "VE");
        acronyms.put("vietnam", "VN");
        acronyms.put("wallis and futuna", "WF");
        acronyms.put("yemen", "YE");
        acronyms.put("zambia", "ZM");
        acronyms.put("zimbabwe", "ZW");
        acronyms.put("eswatini", "SZ");

        isAcronymsFilled = true;
    }


}
