import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
//导入webcollector包里的类

import java.util.HashSet;
import java.util.Set;
//导入Java包里的类

public class WebControllerTest extends BreadthCrawler {
    //储存所有想要爬取的页面，存到一个字符串集合里，并且有去重功能
    static Set<String> urlList = new HashSet<>();
    // 爬取的时候，会有一个seed网页，也就是说，迭代递归通过这个网址，此处定义了一个string，CRAWLURL为seed
    public static final String CRAWLURL = "http://zh.bilinguis.com/book/alice/zh/nl";
    // 种子页面CRAWLURL里面的网页会符合什么标准，比如这个，每一章都类似，c1,c2,c3,c……所以最后用了一个%d，之后迭代这个页面的时候，可以直接用循环变量i替换
    public static final String PAGEURL = "http://zh.bilinguis.com/book/alice/zh/nl/c%d";
    //循环的开始和结束变量
    public static final int PAGESTART = 1;
    public static final int PAGEEND = 12;
    // 想要爬取的目标页面应该符合某种格式，这里利用正则来匹配，也就是说，只要是c1,c5,c2,c3等的子页面，都可以匹配到。c后面，首先一个数字，之后剩下的全都要。
    public static final String REGEXURL = "http://zh.bilinguis.com/book/alice/zh/nl/c[0-9]*";

    public WebControllerTest(String crawlPath, boolean autoParse) {
        /**
         * @param crawlPath 存放此次爬取信息的路径名字，会生成在src下。
         * @param autoParse 如果autoParse is true,BreadthCrawler 将会从页面自动提取符合正则的链接
         */
        super(crawlPath, autoParse);
        //添加种子页面
        this.addSeed(CRAWLURL);
        //迭代种子页面的子页面
        for(int pageIndex = PAGESTART; pageIndex<=PAGEEND;pageIndex++){
            //利用format替换%d
            String seedUrl = String.format(PAGEURL, pageIndex);
            //将新找到的页面也加入到种子页面
            this.addSeed(seedUrl);
            //也就是说，迭代完成后，这12个子页面和一开始的CRAWLURL都会作为第一层的页面。
        }
        this.addRegex(REGEXURL);
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        //此处是任意访问到一个页面，先拿到该页面网页
        String url = page.url();
        //网页符合正则的规则，才加入到连接集合里
        if(page.matchUrl(REGEXURL)){
            //提取URL或者Content获取标题等操作。
            urlList.add(url);
        }
    }

    public static void main(String[] args) {
        //本代码运行后的结果就是将爬取到的所有符合条件的网址输出出来，其他进一步的操作之后再说。
        WebControllerTest webControllerTest = new WebControllerTest("WebControllercrawlpath", true);
        try {
            //设置爬取的线程数
            webControllerTest.setThreads(50);
            //设置每次迭代爬取的网页数量上限
            //webControllerTest.setTopN(100);
            webControllerTest.getConf().setTopN(100);
            //爬取的深度
            webControllerTest.start(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(urlList);
    }
}

