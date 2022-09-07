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



    @Test
    void zipCsvReaderTest() throws Exception {
        InputStream is = classLoader.getResourceAsStream("QAG9-tst.zip");
        ZipInputStream zip = new ZipInputStream(is);
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.getName().contains("testCsv.csv")) {
                try {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zip, UTF_8));
                    List<String[]> csv = csvReader.readAll();
                    assertThat(csv).contains(
                            new String[]{"Name", "Style", "Type"},
                            new String[]{"Дайте Танк!", "shy punk", "band"},
                            new String[]{"AC/DC", "hard rock", "band"},
                            new String[]{"Kendric Lamar", "rap", "performer"}
                    );
                } finally {
                    is.close();
                }
            }
        }
    }

    @Test
    void zipXLSReaderTest() throws Exception {
        InputStream is = classLoader.getResourceAsStream("QAG9-tst.zip");
        ZipInputStream zis = new ZipInputStream(is);
        ZipFile zfile = new ZipFile(new File("src/test/resources/" + "QAG9-tst.zip"));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.getName().contains("file_example_XLS_10.xls")) {
                try (InputStream stream = zfile.getInputStream(entry)) {
                    XLS xls = new XLS(stream);
                    assertThat(
                            xls.excel.getSheetAt(0)
                                    .getRow(5)
                                    .getCell(2)
                                    .getStringCellValue()
                    ).contains("Magwood");
                }
            }
        }

    }


    @Test
    void zipPdfReaderTest() throws Exception {
        InputStream is = classLoader.getResourceAsStream("QAG9-tst.zip");
        ZipInputStream zip = new ZipInputStream(is);
        ZipEntry entry;
        ZipFile zfile = new ZipFile(new File("src/test/resources/" + "QAG9-tst.zip"));
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.getName().contains("SP-404mk2_reference_v114_eng01.pdf")) {
                try (InputStream stream = zfile.getInputStream(entry)) {
                    PDF pdf = new PDF(stream);
                    assertThat(pdf.numberOfPages).isEqualTo(138);

                }
            }
        }

    }
}
