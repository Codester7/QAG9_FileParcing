import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class ParcingTestHW1 {
    ClassLoader classLoader = ParcingTestHW1.class.getClassLoader();
    private final File zipFile = new File("src/test/resources/QAG9-tst.zip");


    @Test
    void zipCsvReaderTest() throws Exception {
        String csvFileName = "testCsv.csv";

        try (ZipFile archive = new ZipFile(zipFile)) {
            ZipEntry csvZipEntry = archive.getEntry(csvFileName);
            try (InputStream is = archive.getInputStream(csvZipEntry);
                 InputStreamReader isReader = new InputStreamReader(is, UTF_8);
                 CSVReader csvReader = new CSVReader(isReader)) {
                List<String[]> csv = csvReader.readAll();
                assertThat(csv).contains(
                        new String[]{"Name", "Style", "Type"},
                        new String[]{"Дайте Танк!", "shy punk", "band"},
                        new String[]{"AC/DC", "hard rock", "band"},
                        new String[]{"Kendric Lamar", "rap", "performer"}
                );
            }
        }
    }

    @Test
    void zipXLSReaderTest() throws Exception {
        String csvFileName = "file_example_XLS_10.xls";

        try (ZipFile archive = new ZipFile(zipFile)) {
            ZipEntry csvZipEntry = archive.getEntry(csvFileName);
            try (InputStream is = archive.getInputStream(csvZipEntry)) {
                XLS xls = new XLS(is);
                assertThat(
                        xls.excel.getSheetAt(0)
                                .getRow(5)
                                .getCell(2)
                                .getStringCellValue())
                        .contains("Magwood");
            }
        }
    }


    @Test
    void zipPdfReaderTest() throws Exception {
        String pdfFileName = "SP-404mk2_reference_v114_eng01.pdf";

        try (ZipFile archive = new ZipFile(zipFile)) {
            ZipEntry csvZipEntry = archive.getEntry(pdfFileName);
            try (InputStream is = archive.getInputStream(csvZipEntry)) {
                PDF pdf = new PDF(is);
                assertThat(pdf.numberOfPages).isEqualTo(138);

            }
        }
    }

}