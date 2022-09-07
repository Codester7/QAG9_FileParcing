//import com.codeborne.pdftest.PDF;
//import com.codeborne.selenide.Selenide;
//import com.codeborne.xlstest.XLS;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.opencsv.CSVReader;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.List;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;
//
//import static com.codeborne.selenide.Selenide.$;
//import static java.nio.charset.StandardCharsets.UTF_8;
//import static org.assertj.core.api.Java6Assertions.assertThat;
//
public class ParcingTestExamples {
//    ClassLoader classLoader = ParcingTestExamples.class.getClassLoader();
//
//    @Test
//    void pdfTest() throws Exception {
//        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
//        File file = $("a[href*='junit-user-guide-5.8.2.pdf']").download();
//        PDF pdf = new PDF(file);
//        assertThat(pdf.author).contains("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein");
//    }
//
//    @Test
//    void xlsTest() throws Exception {
//        Selenide.open("http://romashka2008.ru/price");
//        File file = $(".site-content__right a[href*='/f/prajs_ot_0806.xls']").download();
//        XLS xls = new XLS(file);
//        assertThat(
//                xls.excel.getSheetAt(0)
//                        .getRow(22)
//                        .getCell(2)
//                        .getStringCellValue()
//        ).contains("БОЛЬШАЯ РАСПРОДАЖА");
//    }
//
//    @Test
//    void csvTest() throws Exception {
//        InputStream is = classLoader.getResourceAsStream("testCsv.csv");
//        CSVReader csvReader = new CSVReader(new InputStreamReader(is, UTF_8));
//        List<String[]> csv = csvReader.readAll();
//        assertThat(csv).contains(
//                new String[] {"Name","Status","Domashka"},
//                new String[] {"Vlad","molodec","true"}
//        );
//    }
//
//    @Test
//    void zipTest() throws Exception {
//        InputStream is = classLoader.getResourceAsStream("sample-zip-file.zip");
//        ZipInputStream zis = new ZipInputStream(is);
//        ZipEntry entry;
//        while ((entry = zis.getNextEntry()) != null) {
//            assertThat(entry.getName()).isEqualTo("sample.txt");
//        }
//    }
//
//    @Test
//    void jsonTest() {
//        InputStream is = classLoader.getResourceAsStream("testJson.json");
//        Gson gson = new Gson();
//        JsonObject jsonObject = gson.fromJson(new InputStreamReader(is), JsonObject.class);
//        assertThat(jsonObject.get("name").getAsString()).isEqualTo("Vlad");
//        assertThat(jsonObject.get("isGoodStudent").getAsBoolean()).isEqualTo(true);
//        assertThat(jsonObject.get("skill").getAsJsonObject().get("level").getAsInt()).isEqualTo("low");
//    }
//
////    @Test
////    void jsonTestNG() {
////        InputStream is = classLoader.getResourceAsStream("teacher.json");
////        Gson gson = new Gson();
////        Teacher jsonObject = gson.fromJson(new InputStreamReader(is), Teacher.class);
////        assertThat(jsonObject.getName()).isEqualTo("Dmitrii");
////        assertThat(jsonObject.isGoodTeacher()).isEqualTo(true);
////        assertThat(jsonObject.getPassport().getNumber()).isEqualTo(1234);
////    }
}
//
