import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Created by zhanghl
 */
public class DongaCrawl {
    private static final String URL_PREFIX = "https://english.etnews.com/news/section.html?id1=";
    private static final String url_path = "src/main/resources/";


    public static void main(String[] args) {

        ArrayList<String> enUrl_List = new ArrayList<String>();
        // 此处采用相对路径，工程目录默认就可以获取，所以用相对路径获取resources内容
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // 1.创建webdriver驱动
        WebDriver driver = new ChromeDriver();
        /*Document doc = null;*/
        for (int i = 0; i <= 11; i++) {
            String url = URL_PREFIX + String.format("%02d", i);
            System.out.println(url);
            /*try {
                doc = Jsoup.connect(url).timeout(5000).get();
                Elements elements = doc.select("#contents_list").select("li");
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }*/
            driver.get(url);
            WebElement webElement = driver.findElement(By.id("ContentsViewBtn"));
            while (webElement.isEnabled()) {
                try {
                    webElement.click();
                    webElement = driver.findElement(By.id("ContentsViewBtn"));
                } catch (Exception e) {
                    break;
                }
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            List<WebElement> contentsList = driver.findElements(By.className("clearfix"));
            for (WebElement web : contentsList) {
                String urlTemp = web.getAttribute("href");
                enUrl_List.add(urlTemp);
            }
            try {
                saveTxtFile(String.join("\n", enUrl_List), url_path + "enUrl_" + i + ".txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveTxtFile(String aligner, String file) throws IOException {
        File writename = new File(file); // 相对路径，如果没有则要建立一个新的output。txt文件
        writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        out.write(aligner); // \r\n即为换行
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
    }


}
